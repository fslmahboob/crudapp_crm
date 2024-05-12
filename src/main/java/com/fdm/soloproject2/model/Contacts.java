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
	
	@Column(name = "companyname", unique = true)
	private String companyname;
	
	@Column(name = "firstname", unique = true)
	private String firstname;
	
	@Column(name = "lastname", unique = true)
	private String lastname;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "mobile", unique = true)
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

	public String getCompanyname()
	{
		return companyname;
	}

	public void setCompany_name(String companyname)
	{
		this.companyname = companyname;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirst_name(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLast_name(String lastname)
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

	public List<Leads> getLead()
	{
		return lead;
	}

	public void setLead(List<Leads> lead)
	{
		this.lead = lead;
	}

	public Contacts(String companyname, String firstname, String lastname, String email, String mobile,
	        List<Leads> lead)
	{
		super();
		this.companyname = companyname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		Mobile = mobile;
		this.lead = lead;
	}
	
	public Contacts()
	{
		
	}

	@Override
	public String toString()
	{
		return "Contacts [contact_id=" + contact_id + ", companyname=" + companyname + ", firstname=" + firstname
		        + ", lastname=" + lastname + ", email=" + email + ", Mobile=" + Mobile + ", lead=" + lead + "]";
	}
	
	

}
