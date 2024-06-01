package com.example.userstories.service;

import com.example.userstories.entity.Student;
import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student getById(Integer id);
    List<Student> getAll();
    Student update(Integer id, Student studentDetail);
    void delete(Integer id);
}