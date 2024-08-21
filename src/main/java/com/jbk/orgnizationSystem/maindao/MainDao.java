package com.jbk.orgnizationSystem.maindao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.orgnizationSystem.entity.Country;
import com.jbk.orgnizationSystem.entity.Employee;



@Repository
public class MainDao {

	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is addedd...";
		}catch (Exception e) {
						
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;		
	}
	
	
	


	public String updateCountry(Country c,int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session= factory.openSession();
			tx=session.beginTransaction();
			
		
		Country country= session.get(Country.class, id);
		country.setCname(c.getCname());
		
		
		session.merge(country);
		tx.commit();
		msg="Country is update...";
			
		}catch (Exception e) {
			
				if(tx!=null) {
				tx.rollback();
			}
				e.printStackTrace();
	}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}







	public String deletecountry(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
		
			Country country = session.get(Country.class, id);
			session.remove(country);
			msg = "country deleted succesfully";
			tx.commit();
		}catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
	}finally {
		if (session != null) {
			session.close();
		}
	}
		return msg;
	
	}





	public List<Country> getAllCountry() {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		String Query = null;
		List<Country>List = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query = "from Country";
			
			Query<Country> query = session.createQuery(Query, Country.class);
			List = query.list();
			tx.commit();
			
			
			}catch (Exception e) {
				// TODO: handle exception
				if (tx != null) {
					tx.rollback();
				}
			} finally {
				if (session != null) {
					session.close();
				}
			}
		
		return List;
	

	}





	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		
		try {		
			 session= factory.openSession();
			tx=session.beginTransaction();		
			session.persist(emp);
			tx.commit();
			msg="Employee is addedd  successfully...";
			}catch (Exception e) {
							
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();			
			}finally {
				
				if(session!=null) {
					session.close();
				}			
			}
			
			return msg;		
		}





	public String updateEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
	
		try {
			session= factory.openSession();
			tx=session.beginTransaction();
		Employee employee= session.get(Employee.class, emp.getId());
		
		
		employee.setName(emp.getName());
		employee.setGender(emp.getGender());
		employee.setDepartment(emp.getDepartment());
		employee.setEmailid(emp.getEmailid());
		employee.setPhoneno(emp.getPhoneno());
		employee.setCreatedby(emp.getCreatedby());
		employee.setCreateddtm(emp.getCreateddtm());
		employee.setUpdatedby(emp.getUpdatedby());
		employee.setUpdateddtm(emp.getUpdateddtm());
		employee.setStatus(emp.getStatus());
		employee.setCountry(emp.getCountry());
		
		session.merge(employee);
		tx.commit();
		msg="employee is update...";
		
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();	
				
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;
	}


	public String deleteemployee(int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
	
		try {		
			 session= factory.openSession();
			tx=session.beginTransaction();		
			
			Employee employee= session.get(Employee.class, id);
			session.remove(employee);
			tx.commit();
			msg="Employee is delete successfully...";
			}catch (Exception e) {
							
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();			
			}finally {
				
				if(session!=null) {
					session.close();
				}			
			}
		
		return msg;
	}
	
	
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String Query = null;
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Query = "from Employee";
			Query<Employee> query = session.createQuery(Query, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e3) {
			if (tx != null) {
				tx.rollback();
			}
			e3.printStackTrace();

			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;
	}
	
	public Employee getEmpById(int id) {
		
		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp;

	}

	public List<Employee> getEmpByStatus(String status) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		Query<Employee> query = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			hqlQuery = "from Employee where status=:mystatus";

			query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);

			list = query.list();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}
	
	public Employee loginapi(Employee e) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		Query<Employee> query = null;
		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphoneno";

			query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("myemailid", e.getEmailid());
			query.setParameter("myphoneno", e.getPhoneno());

			employee = query.uniqueResult();

			tx.commit();

		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;

	}

}


