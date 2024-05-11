package com.fdm.soloproject2.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@Column(name = "first_name", nullable = false)
	private String firstname;
	
	private String password;
	
	@Column(name = "last_name", nullable = false)
	private String lastname;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	// Relationships
	@OneToMany(mappedBy = "user")
	private List<Leads> lead;

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public List<Leads> getLead()
	{
		return lead;
	}

	public void setLead(List<Leads> lead)
	{
		this.lead = lead;
	}
	
	public Users()
	{
		
	}
	
	@Autowired
	public Users(String firstname, String password, String lastname, String email, String country, String city,
	        List<Leads> lead)
	{
		super();
		this.firstname = firstname;
		this.password = password;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.city = city;
		this.lead = lead;
	}

	
	
	
	
	
}
