package com.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")

    private int age;
    @Column(name = "salary")

    private double Salary;
    @ManyToOne
    @JoinColumn(name = "`branch-id`")

    private Branch branch;

    public Employee() {
    }

    public Employee(String name, int age, double salary, Branch branch) {
        this.name = name;
        this.age = age;
        Salary = salary;
        this.branch = branch;
    }

    public Employee(Long id, String name, int age, double salary, Branch branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        Salary = salary;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
