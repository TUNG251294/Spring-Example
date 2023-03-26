package com.finalexammodule4.controller;

import com.finalexammodule4.model.Employee;
import com.finalexammodule4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam("search") Optional<String> search) {
        Iterable<Employee> employees;
//        if(search.isPresent()){
//            employees = blogService.findAllByAuthor(search.get());
//        } else {
        employees = employeeService.findAll();
//        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/info/{id}")
    public ModelAndView viewInfo(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/info");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @GetMapping("/sort")
    public ModelAndView getSortedEmployeesByAge() {
        ModelAndView modelAndView = new ModelAndView("sort");
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        employees.sort(Comparator.comparingInt(Employee::getAge));
//        employees.sort(Comparator.comparingInt(Employee::getAge).reversed());
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

        @GetMapping("/search")
    public ModelAndView listEmployees(@RequestParam("search") String search){
        Iterable<Employee> employees;
        if(search != null){
            employees = employeeService.findAllByNameContaining(search);
        } else {
            employees = employeeService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "update";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String delete(Long id) {
        employeeService.remove(id);
        return "redirect:/list";
    }
}
