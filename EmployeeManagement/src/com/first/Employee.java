package com.first;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee>  {

	   private static final long serialVersionUID = 1L; 
	   private int id; 
	   private String name; 
	   private String profession;  
	   
	   public Employee(){} 
	   
	   public Employee(int id, String name, String profession) {
		   this.id = id;
		   this.name = name;
		   this.profession = profession;
	   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		return true;
	}

	@Override
	public int compareTo(Employee emp) {
		if(this.id > emp.getId()) 
			return 1;
		else if(this.id < emp.getId())
			return -1;
		else 
			return 0;
	}	 
}
