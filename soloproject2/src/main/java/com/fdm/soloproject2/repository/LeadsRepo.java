package com.fdm.soloproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdm.soloproject2.model.Leads;

public interface LeadsRepo extends JpaRepository<Leads, Integer>
{
	//Optional<PotCandidates> findByName(String name);
	
	//boolean existsByName(String name);
}
