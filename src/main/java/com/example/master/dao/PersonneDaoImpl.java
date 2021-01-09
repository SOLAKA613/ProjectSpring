package com.example.master.dao;

import java.util.Hashtable;

import com.example.master.entity.Person;

public class PersonneDaoImpl implements iPersonneDao{
	
	Hashtable<Long, Person> personnes= new Hashtable<Long,Person>();
	

	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return personnes.get(id);
	}
	
	@Override
	public Hashtable<Long, Person> findAllPersons() {
		// TODO Auto-generated method stub
		return this.personnes;
	}

	@Override
	public Person addPerson(Person personne) {
		// TODO Auto-generated method stub
		personnes.putIfAbsent(personne.getId(), personne);
		return personne;
	}

	@Override
	public Person updatePerson(Person personne) {
		// TODO Auto-generated method stub
		personnes.put(personne.getId(), personne);
		return personne;
	}

	@Override
	public Person deletePerson(Long id) {
		// TODO Auto-generated method stub
		personnes.remove(id);
		return findById(id);
	}

}
