package com.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.demo.model.Admin;
import com.demo.service.serviceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private serviceInterface serveInterface;
	
/************************* add admin details   ************************************************/
	@PostMapping("/adminadd")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin)
	{
		log.info("Request to add admin");
		Admin adminsave=serveInterface.addAdmin(admin);
		return new ResponseEntity<Admin>(adminsave,HttpStatus.CREATED);	
	}
	
	
/**********    Show admin details **************************/	
	@GetMapping("/show")
	public ResponseEntity<List<Admin>> getdatils()
	{
		List<Admin> admindtetail=serveInterface.getdata();
		return new ResponseEntity<List<Admin>>(admindtetail,HttpStatus.OK);
	}
	
/**********  Featch Admin details by using id   ***********************/	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getadminID(@PathVariable int id)
	{
		Admin listofadmin=serveInterface.getAdminId(id);
		return new ResponseEntity<Admin>(listofadmin,HttpStatus.OK);
	
	}
	
/**************  Permant deleted Admin details by using id   ***********************/			
	
	  @DeleteMapping("/Hard/{id}") 
	  public ResponseEntity<Admin>deleteIDHard(@PathVariable("id") int id) { 
		  serveInterface.deletDetails(id);
	  return new ResponseEntity<Admin>(HttpStatus.ACCEPTED); }
	 
/*******************  Soft deleted Admin details by using id   ***********************/	
	@DeleteMapping("/Soft/{id}")
   public ResponseEntity<Void> deleteIDSoft(@PathVariable("id") int id)
   {
	   serveInterface.deleteId(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	   
   }
/*******************  Update admin detail   ***********************/		
	@PutMapping("/update")
	public ResponseEntity<Admin> updatdetails(@Valid @RequestBody Admin admin)
	{
		Admin adminsaveData=serveInterface.update(admin);
		return new ResponseEntity<Admin>(adminsaveData,HttpStatus.CREATED);
	}
	
/****************  Featch Admin details by using name   ***********************/		
	@GetMapping("/{name}")
	public ResponseEntity<List<Admin>> getdetails(@PathVariable String name)
	{
		List<Admin> admindtetail=serveInterface.searchUser(name);
		return new ResponseEntity<List<Admin>>(admindtetail,HttpStatus.OK);
		
	}
	
/*************  Sort Admin details by using Date of Birth   ***********************/	
	@GetMapping("/sortdob")
	public ResponseEntity<List<Admin>> sortByDOB()
	{
		List<Admin> sortdata= serveInterface.sortdob();
	
		return new ResponseEntity<List<Admin>>(sortdata,HttpStatus.OK);	
	}
	

	
	
}
