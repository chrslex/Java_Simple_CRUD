package com.chrslex.cruddemo.dao;

import com.chrslex.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findALll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Student)
}
