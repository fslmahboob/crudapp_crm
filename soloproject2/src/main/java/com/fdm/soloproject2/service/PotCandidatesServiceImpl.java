package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.PotCandidates;
import com.fdm.soloproject2.repository.PotCandidatesRepo;

@Service
public class PotCandidatesServiceImpl implements PotCandidatesService
{

	@Autowired
	private PotCandidatesRepo potCandidatesRepo;
	
	// CREATE
	@Override
	public PotCandidates savePotCandidates(PotCandidates potcandidate)
	{
//		if (potCandidatesRepo.existsByName(potcandidate.getFirst_name()) && potCandidatesRepo.existsByName(potcandidate.getLast_name())) 
//		{
//			throw new ConflictException("User with name "+ potcandidate.getFirst_name() + " " + potcandidate.getLast_name() + " already exists. Change details.");
//		}
//		else 
//		{
//			System.out.println("New user" + potcandidate.getFirst_name() + " " + potcandidate.getLast_name() + "added");
//			return potCandidatesRepo.save(potcandidate);
//		}
		return potCandidatesRepo.save(potcandidate);
	}

	// READ
	@Override
	public List<PotCandidates> getAllPotCandidates()
	{
		return potCandidatesRepo.findAll();
	}

	@Override
	public PotCandidates getPotCandidateById(Integer id)
	{
		
		if (potCandidatesRepo.existsById(id) == false)
		{
			throw new RuntimeException("Cannot find: "+id);
		}
		else 
		{
			System.out.println("User with ID "+id+" was found.");
			return potCandidatesRepo.findById(id).get();
		}
	}
	
	// UPDATE
	@Override
	public PotCandidates updatePotCandidate(PotCandidates updpotcandidate)
	{
		PotCandidates dbpotcandidate = potCandidatesRepo.save(updpotcandidate);
		return dbpotcandidate;
	}
	
	// DELETE
	@Override
	public void deletePotCandidateById(Integer id)
	{
		potCandidatesRepo.deleteById(id);
		
		if (potCandidatesRepo.existsById(id))
		{
			throw new RuntimeException("Delete failed: User with ID "+id+" could not be deleted :(");
		}
		else 
		{
			System.out.println("User with ID "+id+" was deleted.");
		}
	}

//	@Override
//	public PotCandidates findPotCandidateByName(String name)
//	{
//		return potCandidatesRepo.findByName(name).orElseThrow(()->new NotFoundException("Could not find user with name "+name));
//	}

	
	
	

}
