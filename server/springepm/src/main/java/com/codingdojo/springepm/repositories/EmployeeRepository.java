package com.codingdojo.springepm.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.springepm.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	Optional<Employee> findByEmail(String email);

}
