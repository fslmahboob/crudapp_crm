package com.fdm.soloproject2.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "potcandidates")
public class PotCandidates
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidate_id;
	
	// Relationship
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Jobs job;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "mobile", nullable = false, unique = true)
	private String Mobile;

	@Column(name = "country", nullable = false)
	private String Country;
	
	@Column(name = "city", nullable = false)
	private String City;
	
	@Column(name = "trainingenddate", nullable = false)
	private LocalDate trainingenddate;

	// No args constructor
	public PotCandidates()
	{
		
	}
	
	// Getters and Setters
	public int getCandidate_id()
	{
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id)
	{
		this.candidate_id = candidate_id;
	}

	public Jobs getJob()
	{
		return job;
	}

	public void setJob(Jobs job)
	{
		this.job = job;
	}

	public String getFirst_name()
	{
		return first_name;
	}

	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}

	public String getLast_name()
	{
		return last_name;
	}

	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return Mobile;
	}

	public void setMobile(String mobile)
	{
		Mobile = mobile;
	}

	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	public String getCity()
	{
		return City;
	}

	public void setCity(String city)
	{
		City = city;
	}

	public LocalDate getTrainingenddate()
	{
		return trainingenddate;
	}

	public void setTrainingenddate(LocalDate trainingenddate)
	{
		this.trainingenddate = trainingenddate;
	}
	
	// Args constructor
	public PotCandidates(Jobs job, String first_name, String last_name, String email, String mobile, String country,
	        String city, LocalDate trainingenddate)
	{
		super();
		this.job = job;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		Mobile = mobile;
		Country = country;
		City = city;
		this.trainingenddate = trainingenddate;
	}

	// toString method
	@Override
	public String toString()
	{
		return "PotCandidates [candidate_id=" + candidate_id + ", first_name=" + first_name + ", last_name=" + last_name
		        + ", email=" + email + ", Mobile=" + Mobile + ", Country=" + Country + ", City=" + City
		        + ", trainingenddate=" + trainingenddate + "]";
	}




	

}
