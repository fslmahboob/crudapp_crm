package com.fdm.soloproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdm.soloproject2.model.Jobs;

@Repository
public interface JobsRepo extends JpaRepository<Jobs, Integer>
{
	//Optional<PotCandidates> findByName(String name);
	
	//boolean existsByName(String name);
}
