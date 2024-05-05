package com.fdm.soloproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdm.soloproject2.model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>
{
	//Optional<PotCandidates> findByName(String name);
	
	//boolean existsByName(String name);
}
