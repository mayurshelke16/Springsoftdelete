package com.demo.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.demo.model.Admin;

public interface serviceInterface {

   public Admin addAdmin(Admin admin);
   
public  List<Admin> getdata();

public Admin getAdminId(int id);

public void deleteId(int id);

public List<Admin> searchUser(String name);

public List<Admin> sortdob();

public Admin update(Admin admin);

public void deletDetails(int id);

;






}
