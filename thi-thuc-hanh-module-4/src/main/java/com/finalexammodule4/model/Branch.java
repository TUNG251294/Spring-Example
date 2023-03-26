package com.finalexammodule4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Quan hệ 1-nhiều, 1 chi nhánh có thể có nhiều nhân viên
    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;
}
