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

import com.fdm.soloproject2.model.Users;
import com.fdm.soloproject2.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController
{
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/register")
	public String add(@RequestBody Users user)
	{
		usersService.saveUser(user);
		return "New User Added";
	}
	
	@GetMapping("/getall")
	public List<Users> getAllUsers()
	{
		return usersService.getAllUsers();
	}
	
	@GetMapping("byid/{id}")
	public Users getUserById(@PathVariable int id) 
	{
		Users user = usersService.getUserById(id);
		if (user == null)
		{
			throw new RuntimeException("User not found - " + id);
		}
		
		return user;	
	}
	
	@PutMapping("{id}")
	public Users update(@RequestBody Users user, @PathVariable int id)
	{
		return usersService.updateUser(user);
	}
	
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable Integer id)
	{
		Users tempuser = usersService.getUserById(id);
		
		// throw exception if null
		if (tempuser == null)
		{
			throw new RuntimeException("User ID not found - " + id);
		}
		// delete operation
		usersService.deleteUserById(id);
		
		return "Deleted user id - " + id;
		
	}
}
