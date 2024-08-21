package com.jbk.orgnizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.orgnizationSystem.entity.Country;
import com.jbk.orgnizationSystem.entity.Employee;
import com.jbk.orgnizationSystem.maindao.MainDao;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	
	public String addCountry(Country c) {
		String msg= dao.addCountry(c);
		if(Objects.isNull(msg)) {
		 msg="country is not addedd";
		}
		return msg;
	}


	public String updateCountry(Country c, int id) {
      String msg= dao.updateCountry(c ,id);
		if(Objects.isNull(msg)) {
			 msg="country is not updatated...";
			}
			return msg;
		
	}





	public String deletecountry(int id) {
		         String msg= dao.deletecountry(id);
		         
		         if(Objects.isNull(msg)) {
					 msg="country is not deleted...";
					}
					
		         return msg;
		         
		
	}





	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		if (list.isEmpty() == true) {
			return null;
		}
		return list;
		
	}






	public String addEmployee(Employee emp) {
		
		String msg=dao.addEmployee(emp);
		
		if(Objects.isNull(msg)) {
			 msg="country is not deleted...";
			}
			
        return msg;
	}


	public String updateEmployee(Employee emp) {
		String msg=dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			 msg="record is not deleted...";
			}
		return msg;
	}



	public String deleteemployee(int id) {
		String msg=	dao.deleteemployee(id);
		if(Objects.isNull(msg)) {
			 msg="record is not deleted...";
			}
		return msg;
	
	}
	
	public List<Employee> getAllEmp() {
	
		List<Employee> list = dao.getAllEmp();
		if (list.isEmpty() == true) {
			return null;
		}
		return list;
	
   }
	
	public Employee getEmpById(int id) {

		Employee emp = dao.getEmpById(id);
		if (Objects.isNull(emp)) {
			emp = null;
		}
		return emp;

	}

	public List<Employee> getEmpByStatus(String status) {
		// TODO Auto-generated method stub

		List<Employee> list = dao.getEmpByStatus(status);
		if (list.isEmpty()) {
			return null;
		}
		return list;

	}
	public HashMap loginapi(Employee e) {

		Employee emp = dao.loginapi(e);
		HashMap map = new HashMap();

		if (Objects.isNull(emp)) {
			map.put("msg", "invalid user");
			map.put("user", emp);
		} else {
			map.put("msg", "valid user");
			map.put("user", emp);
		}

		return map;

	}


}
	
	


