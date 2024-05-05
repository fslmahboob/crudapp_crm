package com.fdm.soloproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdm.soloproject2.model.Contacts;

@Repository
public interface ContactsRepo extends JpaRepository<Contacts, Integer>
{
	//Optional<PotCandidates> findByName(String name);
	
	//boolean existsByName(String name);
}
