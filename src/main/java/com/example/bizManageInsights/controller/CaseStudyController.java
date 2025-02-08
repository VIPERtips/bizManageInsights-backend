package com.example.bizManageInsights.controller;

import com.example.bizManageInsights.model.CaseStudy;
import com.example.bizManageInsights.service.CaseStudyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/case-studies")
@CrossOrigin(origins = {"http://localhost:3000","https://biz-manage-insights.vercel.app"})
public class CaseStudyController {

    @Autowired
    private  CaseStudyService caseStudyService;
    @GetMapping
    public ResponseEntity<?> getAllCaseStudies() {
        try {
            List<CaseStudy> caseStudies = caseStudyService.getAllCaseStudies();
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", caseStudies
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                        "status", "error",
                        "message", e.getMessage()
                    ));
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCaseStudyById(@PathVariable int id) {
        try {
            CaseStudy caseStudy = caseStudyService.getCaseStudyById(id).get();
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", caseStudy
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                        "status", "error",
                        "message", e.getMessage()
                    ));
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createCaseStudy(@RequestBody CaseStudy caseStudy) {
        try {
            CaseStudy createdCaseStudy = caseStudyService.createCaseStudy(caseStudy);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                        "status", "success",
                        "message", "Case study created successfully",
                        "data", createdCaseStudy
                    ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                        "status", "error",
                        "message", e.getMessage()
                    ));
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCaseStudy(@PathVariable int id, @RequestBody CaseStudy updatedCaseStudy) {
        try {
            CaseStudy caseStudy = caseStudyService.updateCaseStudy(id, updatedCaseStudy);
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Case study updated successfully",
                "data", caseStudy
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                        "status", "error",
                        "message", e.getMessage()
                    ));
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCaseStudy(@PathVariable int id) {
        try {
            caseStudyService.deleteCaseStudy(id);
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Case study deleted successfully"
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                        "status", "error",
                        "message", e.getMessage()
                    ));
        }
    }
}
