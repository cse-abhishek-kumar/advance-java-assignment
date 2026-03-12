package com.construction.inspection.mapper;

import com.construction.inspection.dto.InspectionDTO;
import com.construction.inspection.entity.Inspection;

public class InspectionMapper {
	public static InspectionDTO toDTO(Inspection ins) {
		InspectionDTO dto = new InspectionDTO();
		dto.setId(ins.getId());
		dto.setSiteName(ins.getSiteName());
		dto.setInspectorName(ins.getInspectorName());
		dto.setInspectionDate(ins.getInspectionDate());
		dto.setRemarks(ins.getRemarks());
		dto.setPhotoFileName(ins.getPhotoFileName());
		dto.setReportFileName(ins.getReportFileName());
		dto.setCreatedAt(ins.getCreatedAt());
		return dto;
	}
//	public static Inspection toEntity(InspectionDTO ) {
//		
//	}
}
