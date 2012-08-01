package org.willclark.addressbook;

import java.util.List;

import org.willclark.addressbook.exception.ServiceException;

public abstract class Service<T> {

	protected Database database;
	
	public Service(Database database) {
		this.database = database;
	}
	
	public abstract T find(T model) throws ServiceException;
	public abstract List<T> findAll() throws ServiceException;
	public abstract void create(T model) throws ServiceException;
	public abstract void update(T model) throws ServiceException;
	public abstract void delete(T model) throws ServiceException;
		
}
