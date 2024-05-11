package com.fdm.soloproject2.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


// Entity table that links to all the available job opportunities and their respective contacts
@Entity
@Table(name = "leads")
public class Leads
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lead_id;
	
	// Relationships
	@OneToMany(mappedBy = "lead")
	private List<Jobs> job;
	
	@ManyToOne
	@JoinColumn(name = "contact_id")
	private Contacts contact;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	public Leads()
	{
		
	}

	public int getLead_id()
	{
		return lead_id;
	}

	public void setLead_id(int lead_id)
	{
		this.lead_id = lead_id;
	}

	public List<Jobs> getJob()
	{
		return job;
	}

	public void setJob(List<Jobs> job)
	{
		this.job = job;
	}

	public Contacts getContact()
	{
		return contact;
	}

	public void setContact(Contacts contact)
	{
		this.contact = contact;
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}

	public Leads(List<Jobs> job, Contacts contact, Users user)
	{
		super();
		this.job = job;
		this.contact = contact;
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "Leads [lead_id=" + lead_id + ", job=" + job + ", contact=" + contact + ", user=" + user + "]";
	}

}
