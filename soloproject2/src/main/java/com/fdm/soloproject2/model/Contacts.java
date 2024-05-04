package com.fdm.soloproject2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contact_id;
	
	@Column(name = "company_name", nullable = false)
	private String company_name;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "mobile", nullable = false, unique = true)
	private String Mobile;
	
	// Relationship
	@OneToMany(mappedBy = "contact")
	private List<Leads> lead;

	public int getContact_id()
	{
		return contact_id;
	}

	public void setContact_id(int contact_id)
	{
		this.contact_id = contact_id;
	}

	public String getCompany_name()
	{
		return company_name;
	}

	public void setCompany_name(String company_name)
	{
		this.company_name = company_name;
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

	public List<Leads> getLead()
	{
		return lead;
	}

	public void setLead(List<Leads> lead)
	{
		this.lead = lead;
	}

	public Contacts(String company_name, String first_name, String last_name, String email, String mobile,
	        List<Leads> lead)
	{
		super();
		this.company_name = company_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		Mobile = mobile;
		this.lead = lead;
	}

	@Override
	public String toString()
	{
		return "Contacts [contact_id=" + contact_id + ", company_name=" + company_name + ", first_name=" + first_name
		        + ", last_name=" + last_name + ", email=" + email + ", Mobile=" + Mobile + ", lead=" + lead + "]";
	}
	
	

}
