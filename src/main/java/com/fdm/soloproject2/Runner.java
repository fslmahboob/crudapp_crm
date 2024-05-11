package com.fdm.soloproject2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Users;
import com.fdm.soloproject2.repository.UsersRepo;
import com.fdm.soloproject2.service.UsersService;

import jakarta.transaction.Transactional;

@Service
public class Runner implements ApplicationRunner 
{
	UsersRepo usersRepo;
	UsersService usersService;
	
	@Autowired
	public Runner(UsersRepo usersRepo, UsersService usersService) {
		this.usersRepo = usersRepo;
		this.usersService = usersService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		// Initialise data
		initData();
	}

	// -------------------------------------------------------------------------------------------------		
			// DATALOADER

	private void initData()
	{

	ArrayList<Users> users = new ArrayList<>();
	
	Users user1 = new Users("Elis", "elis123", "Wynn", "ew@fdm.com", "Australia", "Sydney", null);
	users.add(user1);
	Users user2 = new Users("John", "jdabc", "Doe", "jd@fdm.com", "Australia", "Melbounrne", null);
	users.add(user2);
	Users user3 = new Users("Emily", "emb123", "Brown", "emily@hotmail.com", "Australia", "Perth", null);
	users.add(user3);
	Users user4 = new Users("Michael", "nike", "Jordan", "mike@nike.com", "USA", "New York", null);
	users.add(user4);
	Users user5 = new Users("Olivia", "oli123", "Taylor", "oli@gmail.com", "Canada", "Montreal", null);
	users.add(user5);
	
	usersService.saveAll(users);
	}

}
