package com.fdm.soloproject2.model;

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
	private int candidateid;
	
	// Relationship
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Jobs job;
	
	@Column(name = "first_name", nullable = false)
	private String firstname;
	
	@Column(name = "last_name", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "mobile", nullable = false, unique = true)
	private String Mobile;

	@Column(name = "country", nullable = false)
	private String Country;
	
	@Column(name = "city", nullable = false)
	private String City;
	
	@Column(name = "trainingenddate", nullable = false)
	private String trainingenddate;

	// No args constructor
	public PotCandidates()
	{
		
	}
	
	// Getters and Setters
	public int getCandidate_id()
	{
		return candidateid;
	}

	public void setCandidate_id(int candidateid)
	{
		this.candidateid = candidateid;
	}

	public Jobs getJob()
	{
		return job;
	}

	public void setJob(Jobs job)
	{
		this.job = job;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
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

	public String getTrainingenddate()
	{
		return trainingenddate;
	}

	public void setTrainingenddate(String trainingenddate)
	{
		this.trainingenddate = trainingenddate;
	}
	
	// Args constructor
	public PotCandidates(Jobs job, String firstname, String lastname, String email, String mobile, String country,
	        String city, String trainingenddate)
	{
		super();
		this.job = job;
		this.firstname = firstname;
		this.lastname = lastname;
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
		return "PotCandidates [candidate_id=" + candidateid + ", first_name=" + firstname + ", last_name=" + lastname
		        + ", email=" + email + ", Mobile=" + Mobile + ", Country=" + Country + ", City=" + City
		        + ", trainingenddate=" + trainingenddate + "]";
	}




	

}
