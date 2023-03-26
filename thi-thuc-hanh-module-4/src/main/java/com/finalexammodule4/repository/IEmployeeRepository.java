package com.finalexammodule4.repository;

import com.finalexammodule4.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee,Long> {
    Iterable<Employee> findAllByNameContaining(String name);
}
