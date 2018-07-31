package com.example.test.entity;

import java.io.Serializable;

public class Photo implements Serializable {
    private Integer photoId;
    private Integer studentPort;
    private byte[] photoFile;
    private String photoStr;

    public String getPhotoStr() {
        return photoStr;
    }

    public void setPhotoStr(String photoStr) {
        this.photoStr = photoStr;
    }

    public Integer getStudentPort() {
        return studentPort;
    }

    public void setStudentPort(Integer studentPort) {
        this.studentPort = studentPort;
    }

    public byte[] getPhotoFile() {
        return photoFile;
    }
    public void setPhotoFile(byte[] photoFile) {
        this.photoFile = photoFile;
    }
    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }
}
