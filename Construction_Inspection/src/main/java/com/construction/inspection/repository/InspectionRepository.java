package com.construction.inspection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.inspection.entity.Inspection;

public interface InspectionRepository extends JpaRepository<Inspection, Long>{

}
