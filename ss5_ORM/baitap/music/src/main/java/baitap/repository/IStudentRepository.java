package baitap.repository;


import baitap.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
}
