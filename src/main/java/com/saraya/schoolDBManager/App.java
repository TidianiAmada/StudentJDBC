package com.saraya.schoolDBManager;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.saraya.dto.StudentDTO;
import com.saraya.service.StudentService;
import com.saraya.service.StudentServiceImpl;

public class App 
{
//	enum Regime{
//		INTERNAT, EXTERNAT, DEMI_PENSION 
//	}
    	static Logger logger = Logger.getLogger(App.class);
        public static void main(String[] args) {
        	
			StudentService stdser= new StudentServiceImpl();
			StudentDTO student = new StudentDTO("Tidiani","Yoff");
			
			stdser.insert(student);
			stdser.getAllStudent();
			logger.info("Operation successfully excecuted");
			System.out.println("Entrer prenom ");
			Scanner sc= new Scanner(System.in);
			String var = sc.next();
			int result= stdser.remove(var);
			if (result == 1) {
				logger.info("Success : Record deleted successfully ");
			} else {
				logger.info("Error : No record found for the given prenom ");
			}
			sc.close();
			
		}
    
}
