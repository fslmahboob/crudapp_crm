package com.fdm.soloproject2.service;

import java.util.List;

import com.fdm.soloproject2.model.Jobs;

public interface JobsService
{
	public Jobs saveJob(Jobs job);
	
	public List<Jobs> getAllJobs();
	
	public Jobs getJobById(Integer id);
	
	public Jobs updateJob(Jobs job);
	
	public void deleteJobById(Integer id);
}
