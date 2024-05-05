package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Leads;
import com.fdm.soloproject2.repository.LeadsRepo;

@Service
public class LeadsServiceImpl implements LeadsService
{

	@Autowired
	private LeadsRepo leadsRepo;
	
	@Override
	public Leads saveLead(Leads lead)
	{
		return leadsRepo.save(lead);
	}

	@Override
	public List<Leads> getAllLeads()
	{
		return leadsRepo.findAll();
	}

	@Override
	public Leads getLeadById(Integer id)
	{
		if (leadsRepo.existsById(id) == false)
		{
			throw new RuntimeException("Cannot find: "+id);
		}
		else 
		{
			System.out.println("User with ID "+id+" was found.");
			return leadsRepo.findById(id).get();
		}
	}

	@Override
	public Leads updateLead(Leads updlead)
	{
		Leads dblead = leadsRepo.save(updlead);
		return dblead;
	}

	@Override
	public void deleteLeadById(Integer id)
	{
		leadsRepo.deleteById(id);
		
		if (leadsRepo.existsById(id))
		{
			throw new RuntimeException("Delete failed: Job with ID "+id+" could not be deleted :(");
		}
		else 
		{
			System.out.println("Job with ID "+id+" was deleted.");
		}
	}

}
