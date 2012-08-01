package org.willclark.addressbook.model;

import org.willclark.addressbook.Model;
import org.willclark.addressbook.Params;
import org.willclark.addressbook.Require;

public class Person extends Model<Person> {

	private long id = -1;
	private boolean active;
		
	@Require
	private String firstName;
	
	@Require
	private String lastName;
	
	public Person() {}
		
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person=[");
		sb.append("id=").append(id).append(",");
		sb.append("active=").append(active).append(",");
		sb.append("firstName=").append(firstName).append(",");
		sb.append("lastName=").append(lastName);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Person parse(Params params) {
		Person person = new Person();
		person.id = params.getLong("id");
		person.active = params.getBoolean("active");
		person.firstName = params.getString("firstName");
		person.lastName = params.getString("lastName");
		return person;
	}
	
}
