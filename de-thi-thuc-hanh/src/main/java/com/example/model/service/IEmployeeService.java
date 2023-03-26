package com.example.model.service;

import com.example.model.entity.Branch;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
    Page<Employee> findAllByBranch(Optional<Branch> branch, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);

}
