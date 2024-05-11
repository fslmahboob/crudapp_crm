package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Users;
import com.fdm.soloproject2.repository.UsersRepo;

import exceptions.ConflictException;
import exceptions.NotFoundException;

@Service
public class UserServiceImpl implements UsersService
{
	private UsersRepo usersRepo;
	
	PasswordEncoder encoder;

	@Autowired
	public UserServiceImpl(UsersRepo usersRepo, PasswordEncoder encoder)
	{
		this.usersRepo = usersRepo;
		this.encoder = encoder;
	}
	
	public void registerUser(Users user) {
		if (usersRepo.existsByFirstname(user.getFirstname())) {
			throw new ConflictException("User with name "+user.getFirstname()+" already exists. Change your name");
		}
		else {
			// PASSWORD ENCODING
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			usersRepo.save(user);
			System.out.println("NEW USER ADDED: "+user.getFirstname());
		}
	}

	
	@Override
	public Users saveUser(Users user)
	{
		return usersRepo.save(user);
	}

	@Override
	public List<Users> getAllUsers()
	{
		return usersRepo.findAll();
	}

	@Override
	public Users getUserById(Integer id)
	{
		if (usersRepo.existsById(id) == false)
		{
			throw new RuntimeException("Cannot find: "+id);
		}
		else 
		{
			System.out.println("User with ID "+id+" was found.");
			return usersRepo.findById(id).get();
		}
	}

	@Override
	public Users updateUser(Users upduser)
	{
		Users dbuser = usersRepo.save(upduser);
		return dbuser;
	}

	@Override
	public void deleteUserById(Integer id)
	{
		usersRepo.deleteById(id);
		
		if (usersRepo.existsById(id))
		{
			throw new RuntimeException("Delete failed: User with ID "+id+" could not be deleted :(");
		}
		else 
		{
			System.out.println("User with ID "+id+" was deleted.");
		}
	}
	
	public Users findUserByFirstName(String firstname) {
		return usersRepo.findByFirstname(firstname).orElseThrow(()->new NotFoundException("Could not find user with name "+firstname));
	}
	
	public void saveAll(List<Users> users) {
		for (Users user : users) {
			registerUser(user);
		}
	}



}
