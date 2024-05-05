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

import com.fdm.soloproject2.model.Jobs;
import com.fdm.soloproject2.service.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsController
{
	@Autowired
	private JobsService jobsService;
	
	@PostMapping("/register")
	public String add(@RequestBody Jobs job)
	{
		jobsService.saveJob(job);
		return "New Job Added";
	}
	
	@GetMapping("/getall")
	public List<Jobs> getAllJobs()
	{
		return jobsService.getAllJobs();
	}
	
	@GetMapping("byid/{id}")
	public Jobs getJobById(@PathVariable int id) 
	{
		Jobs job = jobsService.getJobById(id);
		if (job == null)
		{
			throw new RuntimeException("Job not found - " + id);
		}
		
		return job;	
	}
	
	@PutMapping("{id}")
	public Jobs update(@RequestBody Jobs job, @PathVariable int id)
	{
		return jobsService.updateJob(job);
	}
	
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable Integer id)
	{
		Jobs tempjob = jobsService.getJobById(id);
		
		// throw exception if null
		if (tempjob == null)
		{
			throw new RuntimeException("Job ID not found - " + id);
		}
		// delete operation
		jobsService.deleteJobById(id);
		
		return "Deleted job id - " + id;
		
	}

}
