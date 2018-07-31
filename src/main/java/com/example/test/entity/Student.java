package com.example.test.entity;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable
{
    private Integer studentPort;
    private String studentName;
    private String studentBirthday;
    private List<Photo> photoList;

    public Integer getStudentPort() {
        return studentPort;
    }

    public void setStudentPort(Integer studentPort) {
        this.studentPort = studentPort;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
