package com.alibou.example1;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "school" // same name as the attribute in student
    ) // one school can have many students
    @JsonManagedReference // parent level : parent is in charge of the child and prevents the child from serializing the parent
    private List<Student> students;

    public School() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School(String name) {
        this.name = name;
    }
}
