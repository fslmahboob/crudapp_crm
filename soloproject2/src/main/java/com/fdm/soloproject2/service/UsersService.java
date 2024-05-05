package com.fdm.soloproject2.service;

import java.util.List;

import com.fdm.soloproject2.model.Users;

public interface UsersService
{
	public Users saveUser(Users user);
	
	public List<Users> getAllUsers();
	
	public Users getUserById(Integer id);
	
	public Users updateUser(Users user);
	
	public void deleteUserById(Integer id);
}
