package com.saraya.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.saraya.model.Student;

public interface StudentDAO {
	public void insert(Student student);
	public int remove(String prenom_nom); 
	public Set<Student> getAllStudent(); 
	public void update(String date_de_naissance, String adresse);
}
