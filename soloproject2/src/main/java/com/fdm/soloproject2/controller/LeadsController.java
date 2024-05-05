package com.fdm.soloproject2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.soloproject2.model.Leads;
import com.fdm.soloproject2.service.LeadsService;

@RestController
@RequestMapping("/leads")
public class LeadsController
{
	@Autowired
	private LeadsService leadsService;
	
	@PostMapping("/register")
	public String add(@RequestBody Leads lead)
	{
		leadsService.saveLead(lead);
		return "New Lead Added";
	}
	
	@GetMapping("/getall")
	public List<Leads> getAllLeads()
	{
		return leadsService.getAllLeads();
	}
	
	@GetMapping("byid/{id}")
	public Leads getLeadById(@PathVariable int id) 
	{
		Leads lead = leadsService.getLeadById(id);
		if (lead == null)
		{
			throw new RuntimeException("Lead not found - " + id);
		}
		
		return lead;	
	}
	
	@PutMapping("{id}")
	public Leads update(@RequestBody Leads lead, @PathVariable int id)
	{
		return leadsService.updateLead(lead);
	}
	
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable Integer id)
	{
		Leads templead = leadsService.getLeadById(id);
		
		// throw exception if null
		if (templead == null)
		{
			throw new RuntimeException("Lead ID not found - " + id);
		}
		// delete operation
		leadsService.deleteLeadById(id);
		
		return "Deleted lead id - " + id;
		
	}

}
