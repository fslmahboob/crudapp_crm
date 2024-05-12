package com.fdm.soloproject2.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class Jobs
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	// Relationships
	@OneToMany(mappedBy = "job")
	private List<PotCandidates> potcandidates;
	
	@ManyToOne
	@JoinColumn(name = "leadid")
	private Leads lead;
	
	// No args constructor
	public Jobs()
	{
		
	}

	// Getters and Setters
	public int getJob_id()
	{
		return job_id;
	}

	public void setJob_id(int job_id)
	{
		this.job_id = job_id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public List<PotCandidates> getPotcandidates()
	{
		return potcandidates;
	}

	public void setPotcandidates(List<PotCandidates> potcandidates)
	{
		this.potcandidates = potcandidates;
	}

	public Leads getLead()
	{
		return lead;
	}

	public void setLead(Leads lead)
	{
		this.lead = lead;
	}

	public Jobs(String title, String country, String city, List<PotCandidates> potcandidates, Leads lead)
	{
		super();
		this.title = title;
		this.country = country;
		this.city = city;
		this.potcandidates = potcandidates;
		this.lead = lead;
	}

	@Override
	public String toString()
	{
		return "Jobs [job_id=" + job_id + ", title=" + title + ", country=" + country + ", city=" + city
		        + ", potcandidates=" + potcandidates + ", lead=" + lead + "]";
	}
	
	
	

	

}
