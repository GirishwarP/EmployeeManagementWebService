package com.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	//Method to return all the employees
	public List<Employee> getAllEmployees() {

		List<Employee> list = null;

		try {
			File file = new File("Users.dat");

			if (!file.exists()) {
				Employee user1 = new Employee(1, "Navin", " Sr. Manager");
				Employee user2 = new Employee(2, "Girish", "Software Engineer");
				Employee user3 = new Employee(3, "Nishant", "Finance Manager");
				Employee user4 = new Employee(4, "Aditya", "Sales Manager");
				Employee user5 = new Employee(5, "Wilson", "Software Engineer");
				
				list = new ArrayList<Employee>();
				
				list.add(user1);
				list.add(user2);
				list.add(user3);
				list.add(user4);
				list.add(user5);
				
				saveEmployeeList(list);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				list = (List<Employee>) ois.readObject();
				ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	//Method to save all the employees in employees.dat file
	private void saveEmployeeList(List<Employee> userList) {

		try {
			File file = new File("Users.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to get employee on ID 
	public Employee getEmployee(int id) {
		List<Employee> list = getAllEmployees();
		
		for(Employee emp : list) {
			if(emp.getId() == id) {
				return emp;
			}
		}
		
		return null;
	}
	
	//Method to add new employee
	public int addEmployee(Employee emp2) {
		List<Employee> list = getAllEmployees();
		boolean employeeExist = false;
		
		for(Employee emp1 : list) {
			if(emp1.getId() == emp2.getId()) {
				employeeExist = true;
				break;
			}
		}
		if(!employeeExist) {
			list.add(emp2);
			saveEmployeeList(list);
			return 1;
		}
		return 0;
	}
	
	//Method to update existing employee
	public int updateEmployee(Employee emp2) {
		List<Employee> list = getAllEmployees();
		
		for(Employee emp1 : list) {
			if(emp1.getId() == emp2.getId()) {
				int index = list.indexOf(emp1);
				list.set(index, emp2);
				saveEmployeeList(list);
				return 1;
			}
		}
		return 0;
	}
	
	//Method to delete existing employee
	public int deleteEmployee(int id) {
		List<Employee> list = getAllEmployees();
		
		for(Employee emp1 : list) {
			if(id == emp1.getId()) {
				int index = list.indexOf(emp1);
				list.remove(index);
				saveEmployeeList(list);
				return 1;
			}
		}
		return 0;
	}
}
