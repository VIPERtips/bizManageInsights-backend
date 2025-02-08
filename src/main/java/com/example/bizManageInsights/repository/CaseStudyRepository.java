package com.example.bizManageInsights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bizManageInsights.model.CaseStudy;

public interface CaseStudyRepository extends JpaRepository<CaseStudy, Integer> {

}
