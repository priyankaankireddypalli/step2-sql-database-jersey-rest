package com.priya.demorest;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
	
	EmployeeRepository repo = new EmployeeRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // what type of data your returning should be specified
//	public Employee getEmployee() {
//		System.out.println("getEmployee() called");
//		Employee e1 = new Employee();
//		e1.setEmpid(1);
//		e1.setFirstname("priya");
//		e1.setSurname("ankireddy");
//		e1.setAge(25);
//		return e1;
//	}
	
	// creating a static assigning
//	public List<Employee> getEmployees() {
//		System.out.println("getEmployee() called");
//		Employee e1 = new Employee();
//		e1.setEmpid(1);
//		e1.setFirstname("priya");
//		e1.setSurname("ankireddy");
//		e1.setAge(25);
//		Employee e2 = new Employee();
//		e2.setEmpid(2);
//		e2.setFirstname("raghu");
//		e2.setSurname("yadav");
//		e2.setAge(23);
//		List<Employee> employees = Arrays.asList(e1,e2);
//		return employees;
//	}
	//creating a repository
	public List<Employee> getEmployees() {
		System.out.println("getEmployee() called");
		
	
		return repo.getEmployees();
	}
	
	
	@POST
	@Path("employee")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //accepts only xml and json
	public Employee createEmployee(Employee e1) {
		System.out.println("in creation");
		System.out.println(e1);
		repo.create(e1);
		return e1;
	}
	// to update an employee
	
	@PUT
	@Path("employee")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //accepts only xml and json
	public Employee updateEmployee(Employee e1) {
		System.out.println("in updation");
		System.out.println(e1);
		if(repo.getEmployee(e1.getEmpid()).getEmpid()==0) {
			repo.create(e1);
		}
		else {
			repo.update(e1);
		}
	
		return e1;
	}
	
	// to get one particular employee by id
	@GET
	@Path("employee/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee getEmployee(@PathParam("id") int eid) {
		return repo.getEmployee(eid);
	}
	
	@DELETE
	@Path("employee/{id}")
	public Employee deleteEmployee(@PathParam("id") int eid) {
		Employee e = repo.getEmployee(eid);
		if(e.getEmpid()!=0) {
			repo.delete(eid);
		}
		return e;
		
	}
}
