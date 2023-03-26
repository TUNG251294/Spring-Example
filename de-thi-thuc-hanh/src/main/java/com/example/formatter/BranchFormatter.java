package com.example.formatter;

import com.example.model.entity.Branch;

import com.example.model.service.IBranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
//Lớp ProvinceFormatter sử dụng provinceService để chuyển đổi id của province sang object của province.
//Đăng ký formatter @Override phương thức addFormatter() trong lớp ApplicationConfig
@Component
public class BranchFormatter implements Formatter<Branch> {

    private IBranchService branchService;

    @Autowired
    public BranchFormatter(IBranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public Branch parse(String text, Locale locale) throws ParseException {
        Optional<Branch> branchOptional = branchService.findById(Long.parseLong(text));
        return branchOptional.orElse(null);
    }

    @Override
    public String print(Branch object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
