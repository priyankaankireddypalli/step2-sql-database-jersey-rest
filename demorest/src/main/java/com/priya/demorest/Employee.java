package com.priya.demorest;
//POJO CLASS - Model Employee
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private int empid;
	private String firstname;
	private String surname;
	private int age;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", surname=" + surname + ", age=" + age + "]";
	}
	

}
