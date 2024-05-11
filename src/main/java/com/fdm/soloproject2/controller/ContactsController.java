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

import com.fdm.soloproject2.model.Contacts;
import com.fdm.soloproject2.service.ContactsService;

@RestController
@RequestMapping("/contacts")
public class ContactsController
{
	@Autowired
	private ContactsService contactsService;
	
	@PostMapping("/register")
	public String add(@RequestBody Contacts contact)
	{
		contactsService.saveContact(contact);
		return "New Job Added";
	}
	
	@GetMapping("/getall")
	public List<Contacts> getAllContacts()
	{
		return contactsService.getAllContacts();
	}
	
	@GetMapping("byid/{id}")
	public Contacts getContactById(@PathVariable int id) 
	{
		Contacts contact = contactsService.getContactById(id);
		if (contact == null)
		{
			throw new RuntimeException("Contact not found - " + id);
		}
		
		return contact;	
	}
	
	@PutMapping("{id}")
	public Contacts update(@RequestBody Contacts contact, @PathVariable int id)
	{
		return contactsService.updateContact(contact);
	}
	
	@DeleteMapping("{id}")
	public String deleteById(@PathVariable Integer id)
	{
		Contacts tempcontact = contactsService.getContactById(id);
		
		// throw exception if null
		if (tempcontact == null)
		{
			throw new RuntimeException("Contact ID not found - " + id);
		}
		// delete operation
		contactsService.deleteContactById(id);
		
		return "Deleted contact id - " + id;
		
	}

}
