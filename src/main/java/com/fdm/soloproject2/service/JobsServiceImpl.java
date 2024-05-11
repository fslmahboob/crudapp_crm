package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Jobs;
import com.fdm.soloproject2.repository.JobsRepo;

@Service
public class JobsServiceImpl implements JobsService
{
	
	@Autowired
	private JobsRepo jobsRepo;
	
	// CREATE
	@Override
	public Jobs saveJob(Jobs job)
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
		return jobsRepo.save(job);
	}
	
	// READ
	@Override
	public List<Jobs> getAllJobs()
	{
		return jobsRepo.findAll();
	}
	
	@Override
	public Jobs getJobById(Integer id)
	{
		if (jobsRepo.existsById(id) == false)
		{
			throw new RuntimeException("Cannot find: "+id);
		}
		else 
		{
			System.out.println("Job with ID "+id+" was found.");
			return jobsRepo.findById(id).get();
		}
	}
	
	// UPDATE
	@Override
	public Jobs updateJob(Jobs updjob)
	{
		Jobs dbjob = jobsRepo.save(updjob);
		return dbjob;
	}
	
	// DELETE
	@Override
	public void deleteJobById(Integer id)
	{
		jobsRepo.deleteById(id);
		
		if (jobsRepo.existsById(id))
		{
			throw new RuntimeException("Delete failed: Job with ID "+id+" could not be deleted :(");
		}
		else 
		{
			System.out.println("Job with ID "+id+" was deleted.");
		}
	}

}
