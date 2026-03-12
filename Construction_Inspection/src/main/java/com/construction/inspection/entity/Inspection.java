package com.construction.inspection.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="inspections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inspection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String siteName;
	@Column(nullable = false)
	private String inspectorName;
	@Column(nullable = false)
	private LocalDate inspectionDate;
	private String remarks;
	@Column(nullable = false)
	private String photoFileName;
	@Column(nullable = false)
	private String reportFileName;
	@Column(nullable = false,updatable = false)
	private LocalDateTime createdAt;
	@PrePersist
	protected void onCreate() {
		this.createdAt=LocalDateTime.now();
	}
	
}
