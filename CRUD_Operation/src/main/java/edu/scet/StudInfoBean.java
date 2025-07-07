package edu.scet;

public class StudInfoBean {

	private int StudId;
	private String studName;
	private String studSurname;
	private String studMobile;
	private String studEmail;
	private int studAge;
	
	public void setStudId(int studId) {
		this.StudId = studId;
	}
	
	public int getStudId() {
		return this.StudId;
	}
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public String getStudName() {
		return this.studName;
	}
	
	public void setStudSurname(String studSurname) {
		this.studSurname = studSurname;
	}
	
	public String getStudSurname() {
		return this.studSurname;
	}
	
	public void setStudMobile(String studMobile) {
		this.studMobile = studMobile;
	}
	
	public String getStudMobile() {
		return this.studMobile;
	}
	
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	
	public String getStudEmail() {
		return this.studEmail;
	}
	
	public void setStudAge(int StudAge) {
		this.studAge = StudAge;
	}
	
	public int getStudAge() {
		return this.studAge;
	}
	
}
