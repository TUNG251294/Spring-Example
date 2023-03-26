package com.example.model.service;

import com.example.model.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBranchService extends IGeneralService<Branch> {
    Page<Branch> findAllByNameContaining(String name, Pageable pageable);

}
