package com.saraya.service;

import java.util.Set;

import com.saraya.dao.StudentDAO;
import com.saraya.dao.StudentDAOImpl;
import com.saraya.dto.StudentDTO;
import com.saraya.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO std = new StudentDAOImpl();
	
	public void insert(StudentDTO student) {
		// TODO Auto-generated method stub
		std.insert(StudentDTO.prepareStudentEntity(student));
	}

	public int remove(String prenom_nom) {
		// TODO Auto-generated method stub
		return std.remove(prenom_nom);
	}

	@Override
	public Set<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return std.getAllStudent();
	}

	@Override
	public void update(String date_de_naissance, String adresse) {
		// TODO Auto-generated method stub
		
	}

}
