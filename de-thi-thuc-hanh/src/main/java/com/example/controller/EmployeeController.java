package com.example.controller;

import com.example.model.entity.Branch;
import com.example.model.entity.Employee;
import com.example.model.repository.IBranchRepository;
import com.example.model.service.BranchService;
import com.example.model.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BranchService branchService;



    @Autowired
    private IBranchRepository branchRepository;

    @ModelAttribute("branchs")
    public Iterable<Branch> branches() {
        return branchService.findAll();
    }
//    @GetMapping("/list")
//    public ModelAndView listEmployees() {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        Iterable<Employee> employees = employeeService.findAll();
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.remove(employee.getId());
        return "redirect:list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewInfo(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @GetMapping("/sort")
    public ModelAndView getSortedEmployeesByAge() {
        ModelAndView modelAndView = new ModelAndView("/sort-by-age");
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        employees.sort(Comparator.comparingInt(Employee::getAge));
//        employees.sort(Comparator.comparingInt(Employee::getAge).reversed());
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    //    @GetMapping("/search-by-name")
//    public ModelAndView listEmployees(@RequestParam("search") Optional<String> search, Pageable pageable){
//        Page<Employee> employees;
//        if(search.isPresent()){
//            employees = employeeService.findAllByNameContaining(search.get(), pageable);
//        } else {
//            employees = employeeService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }

        @GetMapping("/search-by-branch")
    public ModelAndView listEmployees(@RequestParam("search") Optional<String> search, Pageable pageable){

            Page<Employee> employees;
        if(search.isPresent()){
            Long a =Long.parseLong(search.get());
            Optional<Branch> branch = branchRepository.findById(a);
            employees = employeeService.findAllByBranch(Optional.of(branch).get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
