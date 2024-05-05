package com.fdm.soloproject2.service;

import java.util.List;

import com.fdm.soloproject2.model.Contacts;

public interface ContactsService
{
 	public Contacts saveContact(Contacts contact);
	
	public List<Contacts> getAllContacts();
	
	public Contacts getContactById(Integer id);
	
	public Contacts updateContact(Contacts contact);
	
	public void deleteContactById(Integer id);
}
