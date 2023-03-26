package com.example.model.repository;

import com.example.model.entity.Branch;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query("SELECT e FROM Employee e WHERE e.branch.id = :id")
//    List<Employee> findByBranch(@Param("branch") Long id);
Page<Employee> findAllByNameContaining(String name, Pageable pageable);
//    Page<Employee> findAllByBranchContaining(Branch branch, Pageable pageable);



    Page<Employee> findAllByBranch(Optional<Branch> branch, Pageable pageable);
}

