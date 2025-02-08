package com.example.bizManageInsights.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.bizManageInsights.model.CaseStudy;
import com.example.bizManageInsights.repository.CaseStudyRepository;

@Service
public class CaseStudyService {
	@Autowired
	private CaseStudyRepository caseStudyRepository;
	
	public List<CaseStudy> getAllCaseStudies() {
	    List<CaseStudy> caseStudies = caseStudyRepository.findAll();

	    if (caseStudies.isEmpty()) {
	        throw new RuntimeException("No case studies have been added");
	    }

	    return caseStudies;
	}

	
	public Optional<CaseStudy> getCaseStudyById(int id) {
	    Optional<CaseStudy> caseStudy = caseStudyRepository.findById(id);

	    if (caseStudy.isEmpty()) {
	        throw new RuntimeException("Case study with ID " + id + " not found");
	    }

	    return caseStudy;
	}

	
	public CaseStudy createCaseStudy(CaseStudy caseStudy) {
	    List<String> missingFields = new ArrayList<>();

	    if (caseStudy.getTitle() == null || caseStudy.getTitle().isBlank()) {
	        missingFields.add("title");
	    }
	    if (caseStudy.getDescription() == null || caseStudy.getDescription().isBlank()) {
	        missingFields.add("description");
	    }
	    if (caseStudy.getProblem() == null || caseStudy.getProblem().isBlank()) {
	        missingFields.add("problem");
	    }

	    if (!missingFields.isEmpty()) {
	        throw new RuntimeException("Missing required fields: " + String.join(", ", missingFields));
	    }

	    caseStudy.setPublishedDate(LocalDate.now());
	    return caseStudyRepository.save(caseStudy);
	}
	 public CaseStudy updateCaseStudy(int id, CaseStudy updatedCaseStudy) {
	        return caseStudyRepository.findById(id).map(caseStudy -> {
	            caseStudy.setTitle(updatedCaseStudy.getTitle());
	            caseStudy.setDescription(updatedCaseStudy.getDescription());
	            caseStudy.setIndustry(updatedCaseStudy.getIndustry());
	            caseStudy.setProblem(updatedCaseStudy.getProblem());
	            caseStudy.setSolution(updatedCaseStudy.getSolution());
	            caseStudy.setResults(updatedCaseStudy.getResults());
	           caseStudy.setAuthor(updatedCaseStudy.getAuthor());
	            return caseStudyRepository.save(caseStudy);
	        }).orElseThrow(() -> new RuntimeException("Case Study not found"));
	    }
	 public void deleteCaseStudy(int id) {
		    CaseStudy caseStudy = caseStudyRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Case study with ID " + id + " not found"));

		    caseStudyRepository.delete(caseStudy);
		}


	
}
