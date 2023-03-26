package com.finalexammodule4.service;

import com.finalexammodule4.model.Employee;

import java.util.Optional;

public interface IEmployeeService<Employee> {
    Iterable<Employee> findAll();
    Optional<Employee> findById(Long id);
    void save(Employee employee);
    void remove(Long id);
    Iterable<Employee> findAllByNameContaining(String name);
}
