package com.jbk.orgnizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor



public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	

	String name;
	String department;
	String status;
	String phoneno;
	double salary;
	Date createddtm;
	String createdby;
	Date updateddtm;
	String updatedby;
	@Column(unique = true)
	String emailid;
	String gender;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	Country country;

//	public Employee() {
//		
//	}
//	public Employee(String name, String department, String status, String phoneno, double salary, Date createddtm,
//			String createdby, Date updateddtm, String updatedby, String emailid, String gender, Country country) {
//		super();
//		this.name = name;
//		this.department = department;
//		this.status = status;
//		this.phoneno = phoneno;
//		this.salary = salary;
//		this.createddtm = createddtm;
//		this.createdby = createdby;
//		this.updateddtm = updateddtm;
//		this.updatedby = updatedby;
//		this.emailid = emailid;
//		this.gender = gender;
//		this.country = country;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public void setPhoneno(String phoneno) {
//		this.phoneno = phoneno;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//	public void setCreateddtm(Date createddtm) {
//		this.createddtm = createddtm;
//	}
//
//	public void setCreatedby(String createdby) {
//		this.createdby = createdby;
//	}
//
//	public void setUpdateddtm(Date updateddtm) {
//		this.updateddtm = updateddtm;
//	}
//
//	public void setUpdatedby(String updatedby) {
//		this.updatedby = updatedby;
//	}
//
//	public void setEmailid(String emailid) {
//		this.emailid = emailid;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", status=" + status
//				+ ", phoneno=" + phoneno + ", salary=" + salary + ", createddtm=" + createddtm + ", createdby="
//				+ createdby + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + ", emailid=" + emailid
//				+ ", gender=" + gender + ", country=" + country + "]";
//	}

	

	
	
	
}
