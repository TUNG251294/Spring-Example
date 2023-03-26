package com.example.model.entity;

import com.example.model.entity.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;
    public Branch(){}

    public Branch(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Branch(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
