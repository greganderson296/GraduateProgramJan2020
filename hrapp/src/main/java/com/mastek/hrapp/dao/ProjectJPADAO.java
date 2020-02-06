package com.mastek.hrapp.dao;


	
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.mastek.hrapp.entities.Project;

	@Repository // declare the DAO layer as repository to manage Data operations
	public interface ProjectJPADAO extends CrudRepository<Project, Integer>{

}
