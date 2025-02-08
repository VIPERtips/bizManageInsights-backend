package com.example.bizManageInsights.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class CaseStudy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String description,
					industry,
					problem,
					solution,
					results;
	private String author = "Tadiwa Blessed";
	
	private LocalDate publishedDate;
	
	public CaseStudy() {
		// TODO Auto-generated constructor stub
	}

	public CaseStudy(String title, String description, String industry, String problem, String solution, String results,
			String author, LocalDate publishedDate) {
		this.title = title;
		this.description = description;
		this.industry = industry;
		this.problem = problem;
		this.solution = solution;
		this.results = results;
		this.author = author;
		this.publishedDate = publishedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	
}
