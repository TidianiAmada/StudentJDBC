package com.saraya.service;


import java.util.Set;

import com.saraya.dto.StudentDTO;
import com.saraya.model.Student;

public interface StudentService {
	public void insert(StudentDTO student);
	public int remove(String prenom_nom);
	public Set<Student> getAllStudent(); 
	public void update(String date_de_naissance, String adresse);
}
