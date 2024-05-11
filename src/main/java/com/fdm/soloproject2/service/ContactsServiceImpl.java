package com.fdm.soloproject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.soloproject2.model.Contacts;
import com.fdm.soloproject2.repository.ContactsRepo;

@Service
public class ContactsServiceImpl implements ContactsService
{
	
	@Autowired
	private ContactsRepo contactsRepo;

	@Override
	public Contacts saveContact(Contacts contact)
	{
		return contactsRepo.save(contact);
	}

	@Override
	public List<Contacts> getAllContacts()
	{
		return contactsRepo.findAll();
	}

	@Override
	public Contacts getContactById(Integer id)
	{
		if (contactsRepo.existsById(id) == false)
		{
			throw new RuntimeException("Cannot find: "+id);
		}
		else 
		{
			System.out.println("Contact with ID "+id+" was found.");
			return contactsRepo.findById(id).get();
		}
	}

	@Override
	public Contacts updateContact(Contacts updcontact)
	{
		Contacts dbcontact = contactsRepo.save(updcontact);
		return dbcontact;
	}

	@Override
	public void deleteContactById(Integer id)
	{
		contactsRepo.deleteById(id);
		
		if (contactsRepo.existsById(id))
		{
			throw new RuntimeException("Delete failed: Contact with ID "+id+" could not be deleted :(");
		}
		else 
		{
			System.out.println("Contact with ID "+id+" was deleted.");
		}
		
	}
	
	

}
