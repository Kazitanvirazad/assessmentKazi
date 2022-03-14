package com.datacollection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.customException.EmpExistsException;
import com.customException.EmpNotFoundException;
import com.datacollection.Emp;
import com.datacollection.EmpDb;

public class EOAHelperClass {

	public String createEmployee(Emp em) {
		try {
			if(!EmpDb.getData().containsKey(em.getEmpId())) {
				EmpDb.getData().put(em.getEmpId(), em);
				return em.getEmpId()+" "+em.getName()+" has been successfully added";
			}else {
				throw new EmpExistsException("Employee already exists!");
			}
		}catch(EmpExistsException e) {
			System.out.println(e.getMessage());
			return "Person already exists!";
		}
	}
	
	public String findEmployeeById(int id) {
		try {
			if(EmpDb.getData().containsKey(id)) {
				Emp e1=EmpDb.getData().get(id);
				return e1.getEmpId()+" "+e1.getName()+" "+e1.getCity()+" "+e1.getSalary();
			}else {
				throw new EmpNotFoundException("Employee not found in Database");
			}
		}catch(EmpNotFoundException e) {
			System.out.println(e.getMessage());
			return "Employee not found";
		}
	}

	public String updateEmployeeDetails(Emp e) {
		try {
			if(EmpDb.getData().containsKey(e.getEmpId())) {
				EmpDb.getData().replace(e.getEmpId(), e);
				return "Employee "+e.getName()+" has been updated successfully!";
			}else {
				throw new EmpNotFoundException("Employee not found in Database");
			}
		}catch(EmpNotFoundException em){
			System.out.println(em.getMessage());
			return  "Employee does not exist";
		}
	}
	
	public String deleteEmployee(int id) {
		try {
			if(EmpDb.getData().containsKey(id)) {
				EmpDb.getData().remove(id);
				return "Employee deleted successfully!";
			}else {
				throw new EmpNotFoundException("Employee not found in Database");
			}
		}catch(EmpNotFoundException e) {
			System.out.println(e.getMessage());
			return "Employee does not exist";
		}
	}
	
	public List<String> listAllEmp(){
		List<String> list=new ArrayList<>();
		Set<Integer> keys=EmpDb.getData().keySet();
		for(Integer key: keys) {
			Emp e=EmpDb.getData().get(key);
			String s=e.getEmpId()+" "+e.getName()+" "+e.getCity()+" "+e.getSalary();
			list.add(s);
		}
		
		return list;
		
	}
	
//	public static void main(String[] args) {
//		EOAHelperClass eo = new EOAHelperClass();
//		for(String s: eo.listAllEmp()) {
//			System.out.println(s);
//		}
//
//		System.out.println(eo.deleteEmployee(104));
//		
//		for(String s: eo.listAllEmp()) {
//			System.out.println(s);
//		}
////		System.out.println(eo.deleteEmployee(104));
////		System.out.println(eo.deleteEmployee(104));
////		Emp e=new Emp(194,"kazi","msd",8787);
////		System.out.println(eo.updateEmployeeDetails(e));
//		
////		System.out.println(eo.findEmployeeById(104));
////		Emp e1 = new Emp(108, "kazi", "msd", 3746);
////		eo.createEmployee(e1);
//
////		for(int i=100; i<EmpDb.getData().size()+100;i++) {
////			System.out.println(EmpDb.getData().get(i).getName());
////		}
//	}
}
