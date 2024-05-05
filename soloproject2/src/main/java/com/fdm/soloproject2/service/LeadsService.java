package com.fdm.soloproject2.service;

import java.util.List;

import com.fdm.soloproject2.model.Leads;

public interface LeadsService
{
	public Leads saveLead(Leads lead);
	
	public List<Leads> getAllLeads();
	
	public Leads getLeadById(Integer id);
	
	public Leads updateLead(Leads lead);
	
	public void deleteLeadById(Integer id);

}
