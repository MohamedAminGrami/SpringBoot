package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Role {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(nullable = false, unique =true)
   private String name;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Role(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Role(Integer id) {
	super();
	this.id = id;
	
}
public Role(String name) {
	super();
    this.name = name;
}
public Role() {
	super();
}
@Override
public String toString() {
	return this.name;
}

   
}

