package com.example.master.entity;

public class Person {
	
	private Long id;
	private String nom;
	private int age;
	
	public Person() {
		super();
	}

	public Person(Long id, String nom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + nom + ", age=" + age + "]";
	}

}
