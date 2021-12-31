package com.demo.dao;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.demo.model.Admin;
@Repository
public interface Admindao extends JpaRepository<Admin, Integer>{

	List<Admin> getByname(String name);



	List<Admin> findByName(String name);
	
	List<Admin> findAllByOrderByDOBAsc();
	
	Optional<Admin>  findByEmail(String email);



	List<Admin> findAllByOrderByAgeAsc();


	@Modifying
	@Transactional 
	@Query(value =  "UPDATE admin SET deleted = true WHERE id=?",nativeQuery = true)
	public void deleteId(int id);


    @Query(value="select * from admin where deleted= false",nativeQuery = true)
	List<Admin> findAllAdmin();



	


	
}
