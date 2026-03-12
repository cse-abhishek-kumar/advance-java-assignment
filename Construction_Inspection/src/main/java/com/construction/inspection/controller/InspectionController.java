package com.construction.inspection.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.construction.inspection.dto.InspectionDTO;
import com.construction.inspection.service.InspectionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inspections")
@RequiredArgsConstructor
public class InspectionController {
	private final InspectionService inspectionService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<InspectionDTO> createInspection(@RequestParam("siteName") String siteName,
														@RequestParam("inspectorName") String inspectorName,
														@RequestParam("inspectionDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate inspectionDate,
														@RequestParam(value = "remarks",required = false) String remarks,
														@RequestParam("sitePhoto")MultipartFile sitePhoto,
														@RequestParam("safetyReport")MultipartFile safetyReport){
		InspectionDTO dto = inspectionService.createInspection(siteName, inspectorName, inspectionDate, remarks, sitePhoto, safetyReport);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InspectionDTO> getInspection(@PathVariable Long id){
		return ResponseEntity.ok(inspectionService.getInspectionById(id));
	}
	@GetMapping("/{id}/photo")
	public ResponseEntity<Resource> downloadPhoto(@PathVariable Long id){
		Resource resource = inspectionService.getSitePhoto(id);
		return buildFileResponse(resource);
	}
	@GetMapping("/{id}/report")
	public ResponseEntity<Resource> downloadReport(@PathVariable Long id){
		Resource resource = inspectionService.getSafetyReport(id);
		return buildFileResponse(resource);
	}
	
	private ResponseEntity<Resource> buildFileResponse(Resource resource){
		String contentType;
		try {
			contentType = Files.probeContentType(resource.getFile().toPath());
		}catch(IOException e) {
			contentType="application/octet-stream";
		}
		if(contentType==null) contentType="application/octet-stream";
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"").body(resource);
	}
}
