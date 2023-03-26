package com.example.model.repository;

import com.example.model.entity.Branch;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
IBranchRepository extends JpaRepository<Branch,Long> {

    Page<Branch> findAllByNameContaining(String name, Pageable pageable);

}
