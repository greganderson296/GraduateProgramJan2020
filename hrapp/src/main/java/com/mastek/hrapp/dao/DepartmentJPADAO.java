package com.mastek.hrapp.dao;


	
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.mastek.hrapp.entities.Department;

	@Repository // declare the DAO layer as repository to manage Data operations
	public interface DepartmentJPADAO extends CrudRepository<Department, Integer>{

}
