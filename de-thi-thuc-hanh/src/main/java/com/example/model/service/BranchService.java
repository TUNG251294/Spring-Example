package com.example.model.service;

import com.example.model.entity.Branch;
import com.example.model.repository.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BranchService implements IBranchService{
    @Autowired
    IBranchRepository branchRepository;
    @Override
    public Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public void save(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public void remove(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public Page<Branch> findAllByNameContaining(String name, Pageable pageable) {
        return branchRepository.findAllByNameContaining(name, pageable);
    }


}
