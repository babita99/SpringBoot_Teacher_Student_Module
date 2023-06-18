package com.TeacherStudent.TeacherStudent.Service;

import com.TeacherStudent.TeacherStudent.Model.Teacher;
import com.TeacherStudent.TeacherStudent.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Teacher signUpTeacher(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }
    public Teacher loginTeacher(String email, String password) {
        System.out.println("email"+email+"password"+password);
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher != null && passwordEncoder.matches(password, teacher.getPassword())) {
            return teacher;
        }
        return null;
    }
}
