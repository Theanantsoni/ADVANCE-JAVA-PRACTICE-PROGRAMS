package edu.scet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.scet.model.StudentBean;

public class FetchStudentDAO {
	public StudentBean getStudentDetails(String nm) {
		StudentBean sb= null;
		Connection con=MyConnection.getConnection();
		try{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student where nm like '%"+nm+"%'");
			if (rs.next()) {
				sb=new StudentBean();
				sb.setNm(rs.getString("nm"));
				sb.setAddr(rs.getString("addr"));
				sb.setContact(rs.getString("contact"));
				sb.setEmailId(rs.getString("emailId"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sb;
	}
}
