package com.priya.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
	
	
	Connection con = null;
	public EmployeeRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/priya","root","1593");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from employee";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpid(rs.getInt("id"));
				e.setFirstname(rs.getString("name"));
				e.setSurname(rs.getString("surname"));
				e.setAge(rs.getInt("age"));
				
				
				employees.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	
	public Employee getEmployee(int eid) {
		
		
		String sql = "select * from employee where id="+eid;
		Employee e = new Employee();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				e.setEmpid(rs.getInt("id"));
				e.setFirstname(rs.getString("name"));
				e.setSurname(rs.getString("surname"));
				e.setAge(rs.getInt("age"));
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
		
	}

	public void create(Employee e1) {
		String sql = "insert into employee values(?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, e1.getEmpid());
			st.setString(2, e1.getFirstname());
			st.setString(3, e1.getSurname());
			st.setInt(4, e1.getAge());
			st.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public void update(Employee e1) {
		String sql = "update employee set name=?,surname=?,age=? where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, e1.getFirstname());
			st.setString(2, e1.getSurname());
			st.setInt(3, e1.getAge());
			st.setInt(4, e1.getEmpid());
			
			st.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	public void delete(int eid) {
String sql = "delete from employee where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			
			st.setInt(1, eid);
			
			st.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}		
	}
	
}
