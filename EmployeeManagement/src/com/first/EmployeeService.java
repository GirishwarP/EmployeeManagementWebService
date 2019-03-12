package com.first;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/EmployeeService")
public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	@GET
	@Path("employees/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("employeeId") int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}
	
	@POST
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee createEmployee(Employee employee) {
		int result = employeeDao.addEmployee(employee);
		if(result == 1)
			return employee;
		else
			return null;
	}
	
	@PUT
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee employee) {
		int result = employeeDao.updateEmployee(employee);
		if(result == 1)
			return employee;
		else
			return null;
	}
	
	@DELETE 
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee deleteEmployee(Employee employee) {
		
		int result = employeeDao.deleteEmployee(employee.getId());
		if(result == 1)
			return employee;
		else
			return null;
	}
	
	@OPTIONS
	@Path("/employees/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSupportedOperations(){
	      return "<operations>GET, PUT, POST, DELETE</operations>";
	   }
	
}
