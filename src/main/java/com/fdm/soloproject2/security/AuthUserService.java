package com.fdm.soloproject2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.fdm.soloproject2.repository.UsersRepo;
import com.fdm.soloproject2.model.Users;

@Service
public class AuthUserService implements org.springframework.security.core.userdetails.UserDetailsService{
	private UsersRepo usersRepo;

	@Autowired
	public AuthUserService(UsersRepo usersRepo) {
		super();
		this.usersRepo = usersRepo;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = this.usersRepo.findByFirstname(username).orElseThrow(
				()-> new UsernameNotFoundException(username));
		return new AuthUser(users);
	}
	
	

}
