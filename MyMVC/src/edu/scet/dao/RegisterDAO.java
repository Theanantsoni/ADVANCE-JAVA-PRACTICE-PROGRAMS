package edu.scet.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.scet.model.StudentGUIBean;

public class RegisterDAO {
	public boolean register(StudentGUIBean studReg) {
		String nm=studReg.getNm();
		String pwd=studReg.getPwd();
		String addr=studReg.getAddr();
		String contact=studReg.getContact();
		String emailId=studReg.getEmailId();
		Connection con=MyConnection.getConnection();
		try{
			Statement stmt=con.createStatement();
			String query="insert into student values('"+nm+"','"+pwd+"','"+addr+"','"+contact+"','"+emailId+"')";
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
