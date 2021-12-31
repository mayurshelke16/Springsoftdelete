package com.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.Admindao;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Admin;

import lombok.var;

@Service
public class ServiceImplementation implements serviceInterface {

	@Autowired
	private Admindao admindao;

	@Override
	public Admin addAdmin(Admin admin) {
		
		if(admin.getName().isEmpty() || admin.getName().length()==0) {
			throw new ResourceNotFoundException("Admin name not Empty: "+ admin.getName());
		}else
			if(admin.getSurname().isEmpty() || admin.getSurname().length()==0)
			{
				throw new ResourceNotFoundException("admin Surname is not Empty: "+admin.getSurname());
			}else
				if(admin.getAddress().isEmpty() || admin.getAddress().length()==0)
				{
					throw new ResourceNotFoundException("admin Address is not Empty: "+admin.getAddress());
				}else
					if(admin.getPincode().isEmpty() || admin.getPincode().length()<=4)
					{
						throw new ResourceNotFoundException("admin pincode is not Empty: "+admin.getPincode());
					}else
						if(admin.getAge()==0 || admin.getAge()<=17)
						{
							throw new ResourceNotFoundException("admin Age is not Empty: "+admin.getAge());
						}else
							if(admin.getEmail().isEmpty() || admin.getEmail().length()<=5)
							{
								throw new ResourceNotFoundException("admin Email is not Empty or gretarthan lenth 6: "+admin.getEmail());
							}
		
		Admin adminsave = admindao.save(admin);
		return adminsave;
	}

	@Override
	public List<Admin> getdata() {
	//	List<Admin> list = admindao.findAll();
		//System.out.println(list);
		//list.sort(Comparator.comparing(Admin::getName));
		//list.sort((Admin s1, Admin s2)->s1.getName().compareTo(s2.getName()));
		//List<Admin> admins= new ArrayList<Admin>();		
		//admins.addAll(list);
	//	return admins;
				return admindao.findAllAdmin();
	}

	@Override
	public Admin getAdminId(int id) {
		return admindao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id :" + id));
	}

	
	 /* @Override
	  public Admin deleteID(int id) 
	  {
		  Admin existadmin= admindao.findById(id).orElseThrow(() -> new
	  ResourceNotFoundException("Admin not found with id :" + id));
	  
	  admindao.deleteId(existadmin.getId()); 
	  // admindao.deleteById(id); 
	  return existadmin;
	  
	  }*/
	 
	
	
	
	

	@Override
	public List<Admin> searchUser(String name) {
		
		return admindao.findByName(name);
		}

	@Override
	public List<Admin> sortdob() {
		
		return admindao.findAllByOrderByDOBAsc();
			//return admindao.findAllByOrderByAgeAsc();	
	}

	@Override
	public Admin update(Admin admin) {
		Admin adminsave = admindao.save(admin);
		return adminsave;
	}

	@Override
	public void deleteId(int id) {
		
		admindao.deleteId(id);
		
	}

	@Override
	public void deletDetails(int id) {
		 admindao.findById(id).orElseThrow(() -> new
				  ResourceNotFoundException("Admin not found with id :" + id));
	}

	
	

	
	

}
