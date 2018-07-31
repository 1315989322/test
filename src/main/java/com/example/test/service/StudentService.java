package com.example.test.service;

import com.example.test.commons.ClientPage;
import com.example.test.entity.Student;

import java.util.List;

public interface StudentService {
    boolean insertStudent(Student student);
    List<Student> findAllStudentPage(ClientPage clientPage);
    boolean deleteStudentByStudentPort(Integer studentPort);
    Student findStudentByStudentPort(Integer studentPort);
    boolean updateStudentInfo(Student student);
    Integer selectCount();
}
