package com.fdm.soloproject2.service;

import java.util.List;

import com.fdm.soloproject2.model.PotCandidates;

public interface PotCandidatesService
{
	public PotCandidates savePotCandidates(PotCandidates potcandidate);
	
	public List<PotCandidates> getAllPotCandidates();
	
	public PotCandidates getPotCandidateById(Integer id);
	
	public PotCandidates updatePotCandidate(PotCandidates updpotcandidate);
	
	public void deletePotCandidateById(Integer id);

}
