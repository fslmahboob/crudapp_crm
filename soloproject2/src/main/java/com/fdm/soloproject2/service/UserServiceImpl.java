package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Users;
import com.fdm.soloproject2.repository.UsersRepo;

@Service
public class UserServiceImpl implements UsersService
{
	@Autowired
	private UsersRepo usersRepo;

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

}
