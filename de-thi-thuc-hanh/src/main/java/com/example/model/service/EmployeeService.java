package com.example.model.service;

import com.example.model.entity.Branch;
import com.example.model.entity.Employee;
import com.example.model.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;


    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }


    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Employee> findAllByBranch(Optional<Branch> branch, Pageable pageable) {
        return employeeRepository.findAllByBranch(branch,pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
