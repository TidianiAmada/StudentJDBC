package com.saraya.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;


import com.saraya.model.Student;

public class StudentDAOImpl implements StudentDAO {

	static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet result=null;
	
	public void insert(Student student) {
		try(FileInputStream fls= new FileInputStream("resources/application.properties");) {
			
			Properties pp= new Properties();
			pp.load(fls);
			String dvname = (String) pp.get("JDBC_DRIVER");
			String url= (String) pp.get("URL");
			String username= (String) pp.get("USER");
			String password= (String) pp.get("PASSWORD");
			Class.forName(dvname);
			conn=DriverManager.getConnection(url, username, password);
			String query = "insert into inscription_list (?,?) ";
			
			pstm=conn.prepareStatement(query);
//			pstm.setDate(1, new Date(1997, 05, 11));
//			pstm.setString(2, "Tidiani");
//			pstm.setString(3, "Yoff Ngaparu");
//			pstm.setDate(4, new Date(2014, 07, 25));
			//pstm.setString(1,   student.getDate_de_naissance());
			pstm.setString(1, student.getPrenom_nom());
			pstm.setString(2, student.getAdresse());
			//pstm.setString(4, student.getDate_inscription());
			
			pstm.execute();
			logger.info("Query Executed !");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {

				if(pstm != null) pstm.close();
				if(conn != null) conn.close();	
			}
			catch (Exception ex) {
				logger.error(ex.getMessage(),ex);
			}
		}
	}

	public int remove(String prenom_nom) {
		int result=1;
		try(FileInputStream fls= new FileInputStream("resources/application.properties");) {
			
			Properties pp= new Properties();
			pp.load(fls);
			String dvname = (String) pp.get("JDBC_DRIVER");
			String url= (String) pp.get("URL");
			String username= (String) pp.get("USER");
			String password= (String) pp.get("PASSWORD");
			Class.forName(dvname);
			conn=DriverManager.getConnection(url, username, password);
			String query = "DELETE FROM inscription_list WHERE prenom_nom = ? ";
			
			pstm=conn.prepareStatement(query);
			pstm.setString(1, prenom_nom);
			result=pstm.executeUpdate();
			logger.info("Query Executed !");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {

				if(pstm != null) pstm.close();
				if(conn != null) conn.close();	
			}
			catch (Exception ex) {
				logger.error(ex.getMessage(),ex);
			}
		}

		return result;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Set<Student> stds=null;
try(FileInputStream fls= new FileInputStream("resources/application.properties");) {
			
			Properties pp= new Properties();
			pp.load(fls);
			String dvname = (String) pp.get("JDBC_DRIVER");
			String url= (String) pp.get("URL");
			String username= (String) pp.get("USER");
			String password= (String) pp.get("PASSWORD");
			Class.forName(dvname);
			conn=DriverManager.getConnection(url, username, password);
			String query = "select prenom_nom from inscription_list ";
			
			pstm=conn.prepareStatement(query);
//			
			pstm.executeUpdate();
			stds=  (Set<Student>) pstm.getResultSet();
			System.out.println(stds.toString());
			logger.info("Query Executed !");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {

				if(pstm != null) pstm.close();
				if(conn != null) conn.close();	
			}
			catch (Exception ex) {
				logger.error(ex.getMessage(),ex);
			}
		}

		
		return stds;
	}

	@Override
	public void update(String date_de_naissance, String adresse) {
		// TODO Auto-generated method stub
		
	}

}
