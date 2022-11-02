package baitap.service;

import baitap.model.Student;
import baitap.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }
}
