package com.example.test.service.impl;

import com.example.test.commons.ClientPage;
import com.example.test.dao.StudentDao;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public boolean insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> findAllStudentPage(ClientPage clientPage) {
        return studentDao.findAllStudentPage(clientPage);
    }

    @Override
    public boolean deleteStudentByStudentPort(Integer studentPort) {
        return studentDao.deleteStudentByStudentPort(studentPort);
    }

    @Override
    public boolean updateStudentInfo(Student student) {
        return studentDao.updateStudentInfo(student);
    }

    @Override
    public Integer selectCount() {
        return studentDao.selectCount();
    }

    @Override
    public Student findStudentByStudentPort(Integer studentPort) {
        return studentDao.findStudentByStudentPort(studentPort);
    }
}
