package com.construction.inspection.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.construction.inspection.dto.InspectionDTO;
import com.construction.inspection.entity.Inspection;
import com.construction.inspection.exception.InvalidFileException;
import com.construction.inspection.exception.ResourceNotFoundException;
import com.construction.inspection.mapper.InspectionMapper;
import com.construction.inspection.repository.InspectionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InspectionService {
	private final InspectionRepository repository;
	
	@Value("${app.upload.dir}")
	private String uploadBaseDir;
	private static final Set<String> ALLOWED_PHOTO_TYPES=Set.of("image/jpeg","image/png");
	private static final Set<String> ALLOWED_PHOTO_EXTENSIONS=Set.of(".jpg",".jpeg",".png");
	private static final Set<String> ALLOWED_REPORT_TYPES=Set.of("application/pdf");
	private static final Set<String> ALLOWED_REPORT_EXTENSIONS=Set.of(".pdf");
	
	public InspectionDTO createInspection(String siteName,String inspectorName,LocalDate inspectionDate,String remarks,MultipartFile sitePhoto,MultipartFile safetyReport) {
		validateFile(sitePhoto,ALLOWED_PHOTO_TYPES,ALLOWED_PHOTO_EXTENSIONS,"Site photo must be JPG or PNG");
		validateFile(safetyReport, ALLOWED_REPORT_TYPES, ALLOWED_REPORT_EXTENSIONS, "Safety report must be a PDF");
		Inspection inspection = Inspection.builder().siteName(siteName).inspectorName(inspectorName).inspectionDate(inspectionDate).remarks(remarks).photoFileName("").reportFileName("").build();
		inspection=repository.save(inspection);
		
		Path inspectionDir = Paths.get(uploadBaseDir,inspection.getId().toString());
		
		try {
			Files.createDirectories(inspectionDir);
		}catch(IOException e) {
			throw new RuntimeException("Could not create upload directory",e);
		}
		
		String photoName = saveFile(sitePhoto,inspectionDir);
		String reportName = saveFile(safetyReport, inspectionDir);
		
		inspection.setPhotoFileName(photoName);
		inspection.setReportFileName(reportName);
		inspection = repository.save(inspection);
		
		return InspectionMapper.toDTO(inspection);
		
	}
	public InspectionDTO getInspectionById(Long id) {
		Inspection inspection = findOrThrow(id);
		return InspectionMapper.toDTO(inspection);
	}
	public Resource getSitePhoto(Long id) {
		Inspection inspection = findOrThrow(id);
		return loadFileAsResource(inspection.getId(),inspection.getPhotoFileName());
	}
	public Resource getSafetyReport(Long id) {
		Inspection inspection = findOrThrow(id);
		return loadFileAsResource(inspection.getId(),inspection.getReportFileName());
	}
	
	private Inspection findOrThrow(Long id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Inspection not found with id: "+id));
	}
	private void validateFile(MultipartFile file,Set<String> allowedMimes,Set<String> allowedExtensions,String errorMessage) {
		if(file==null||file.isEmpty()) {
			throw new InvalidFileException("File must not be empty");
		}
		String contentType = file.getContentType();
		if(contentType==null||!allowedMimes.contains(contentType.toLowerCase())) {
			throw new InvalidFileException(errorMessage+" (invalid MIME type)");
		}
		String originalName=file.getOriginalFilename();
		if(originalName==null) throw new InvalidFileException("File is missing");
		String ext = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
		if(!allowedExtensions.contains(ext)) {
			throw new InvalidFileException(errorMessage+" (invalid extension)");
		}
	}
	private String saveFile(MultipartFile file,Path directory) {
		String original= file.getOriginalFilename();
		String ext = original.substring(original.lastIndexOf("."));
		String filename = UUID.randomUUID().toString()+ext;
		if(original.contains("..")) {
			throw new InvalidFileException("Filename contains invalid characters)");
		}
		try {
			Path dest = directory.resolve(filename);
			Files.copy(file.getInputStream(), dest,StandardCopyOption.REPLACE_EXISTING);
			return filename;
		}catch(IOException e) {
			throw new RuntimeException("Failed to save file: "+filename,e);
		}
	}
	private Resource loadFileAsResource(Long inspectionId,String filename) {
		try {
			Path filePath = Paths.get(uploadBaseDir,inspectionId.toString(),filename).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(!resource.exists()) {
				throw new ResourceNotFoundException("File not found: "+filename);
			}
			return resource;
		}catch(Exception e) {
			throw new ResourceNotFoundException("File not found: "+filename);
		}
	}
}