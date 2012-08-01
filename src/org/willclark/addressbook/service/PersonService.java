package org.willclark.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.willclark.addressbook.Database;
import org.willclark.addressbook.Service;
import org.willclark.addressbook.exception.ServiceException;
import org.willclark.addressbook.model.Person;

public class PersonService extends Service<Person> {

	public PersonService(Database database) {
		super(database);
	}

	@Override
	public Person find(Person model) throws ServiceException {		
		List<Person> people = database.getPeople();
				
		// search by id
		try {
			return people.get((int) model.getId()-1);			
		}
		catch (IndexOutOfBoundsException e) {
			// do nothing
		}
		
		// search by name
		for(Person each : findAll()) {
			if (each.getFirstName().equalsIgnoreCase(model.getFirstName()) && each.getLastName().equalsIgnoreCase(model.getLastName())) return each; 
		}

		return null;
	}
	
	@Override
	public List<Person> findAll() throws ServiceException {
		List<Person> people = new ArrayList<Person>();
		for(Person each : database.getPeople()) {
			if (each.isActive()) people.add(each);
		}
		return people;
	}

	@Override
	public void create(Person model) throws ServiceException {
		if (model == null) throw new IllegalArgumentException("This method requires an argument of type Person!");
		if (find(model) != null) throw new ServiceException("This person already exists!");
				
		List<Person> people = database.getPeople();
		model.setActive(true);
		model.setId(people.size()+1);		
		people.add(model);
		
		database.setPeople(people);
	}

	@Override
	public void update(Person model) throws ServiceException {
		if (model == null) throw new IllegalArgumentException("This method requires an argument of type Person!");
		if (find(model) == null) throw new ServiceException("This person does not exist!");
		
		List<Person> people = database.getPeople();		
		people.set((int) model.getId()-1, model);
		database.setPeople(people);
		
	}

	@Override
	public void delete(Person model) throws ServiceException {
		model.setActive(false);
		update(model);
	}
	
}
