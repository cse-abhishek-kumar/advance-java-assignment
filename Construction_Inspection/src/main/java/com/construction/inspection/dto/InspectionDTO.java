package com.construction.inspection.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InspectionDTO {
	private Long id;
	private String siteName;
	private String inspectorName;
	private LocalDate inspectionDate;
	private String remarks;
	private String photoFileName;
	private String reportFileName;
	private LocalDateTime createdAt;
}
