package com.finalexammodule4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Integer salary;
    @JoinColumn(name = "branch_id")
    @ManyToOne
    private Branch branch;

    public Employee(Long id, String name, Integer age, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
