package com.TeacherStudent.TeacherStudent.Controller;

import com.TeacherStudent.TeacherStudent.Model.Teacher;
import com.TeacherStudent.TeacherStudent.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Teacher> signUpTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.signUpTeacher(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Teacher> loginTeacher(@RequestBody Teacher request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Teacher teacher = teacherService.loginTeacher(email, password);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
