package com.example.master.dao;

import java.util.Hashtable;

import com.example.master.entity.Person;

public interface iPersonneDao {
	
	public Person findById(Long id);
	
	public Hashtable<Long,Person> findAllPersons();
	
	public Person addPerson(Person personne);
	
	public Person updatePerson(Person personne);
	
	public Person deletePerson(Long id);

}
