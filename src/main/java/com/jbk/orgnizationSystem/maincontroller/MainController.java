package com.jbk.orgnizationSystem.maincontroller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.orgnizationSystem.entity.Country;
import com.jbk.orgnizationSystem.entity.Employee;
import com.jbk.orgnizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("addcountry")
	public String addCountry( @RequestBody Country c ) {
	String  msg = service.addCountry(c);
	return msg;
		
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {
		String msg = service.updateCountry(c,id);
		return msg;
		
		
	}
	
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg =service.deletecountry(id);
		return msg;
		
	}
	
	@GetMapping("getallcountry")
	public List<Country> getAllCountry() {
				List<Country>list =service.getAllCountry();
		return list;
	}
	
   @PostMapping("addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg= service.addEmployee(emp);
		return msg;
	}
   
   @PutMapping("updateemployee")
   public String updateEmployee(@RequestBody Employee emp) {
	   String msg= service.updateEmployee(emp);
	   return msg;
   }
   
   @DeleteMapping("deleteemployee/{id}")
   public String deleteemployee(@PathVariable int id) {
	  String msg= service.deleteemployee(id);
	   return msg;
   }
   
   @GetMapping("getallemp")
	public List<Employee> getAllEmp() {

		List<Employee> list = service.getAllEmp();
		return list;
	}
   @GetMapping("getempbyid/{id}")
	public Employee getEmpById(@PathVariable int id) {

		Employee emp = service.getEmpById(id);
		return emp;

	}

	@GetMapping("getempbystatus/{status}")
	public List<Employee> getEmpByStatus(@PathVariable String status) {

		List<Employee> list = service.getEmpByStatus(status);

		return list;

	}
	
	@PostMapping("logincheck")
	public HashMap loginapi(@RequestBody Employee e) {

		HashMap hs = service.loginapi(e);
		return hs;
	}

 
}
