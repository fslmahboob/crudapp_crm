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

import com.fdm.soloproject2.model.PotCandidates;
import com.fdm.soloproject2.service.PotCandidatesService;

@RestController
@RequestMapping("/potcandidates")
public class PotCandidatesController
{
	@Autowired
	private PotCandidatesService potCandidatesService;
	
	@PostMapping("/register")
	public String add(@RequestBody PotCandidates potCandidate)
	{
		potCandidatesService.savePotCandidates(potCandidate);
		return "New Potential Candidate Added";
	}
	
	@GetMapping("/getall")
	public List<PotCandidates> getAllPotCandidates()
	{
		return potCandidatesService.getAllPotCandidates();
	}
	
	@GetMapping("byid/{id}")
	public PotCandidates getPotCandidateById(@PathVariable int id) 
	{
		PotCandidates potcandidate = potCandidatesService.getPotCandidateById(id);
		if (potcandidate == null)
		{
			throw new RuntimeException("Potential candidate ID not found - " + id);
		}
		
		return potcandidate;	
	}
	
	@PutMapping("{id}")
	public PotCandidates update(@RequestBody PotCandidates potcandidate, @PathVariable int id)
	{
		return potCandidatesService.updatePotCandidate(potcandidate);
	}
	
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable Integer id)
	{
		PotCandidates temppotcandidate = potCandidatesService.getPotCandidateById(id);
		
		// throw exception if null
		if (temppotcandidate == null)
		{
			throw new RuntimeException("Potential Candidate ID not found - " + id);
		}
		// delete operation
		potCandidatesService.deletePotCandidateById(id);
		
		return "Deleted potential candidate id - " + id;
		
	}


	
//	@GetMapping("byName/{name}")
//	public PotCandidates getPotCandidateByFirstName(@PathVariable String name) 
//	{
//		return potCandidatesService.findPotCandidateByName(name);
//	}
	
}
