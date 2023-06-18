package com.TeacherStudent.TeacherStudent.Service;

import com.TeacherStudent.TeacherStudent.Model.Student;
import com.TeacherStudent.TeacherStudent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAllStudents(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentRepository.findAll(pageRequest);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


}
