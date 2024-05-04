package com.fdm.soloproject2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	// Relationships
	@OneToMany(mappedBy = "user")
	private List<Leads> lead;
}
