package com.TeacherStudent.TeacherStudent.Repository;

import com.TeacherStudent.TeacherStudent.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByEmail(String email);
}
