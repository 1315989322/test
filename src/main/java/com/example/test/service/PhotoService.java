package com.example.test.service;

import com.example.test.entity.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> findPhotoByStudentPort(Integer studentPort);
    boolean insertPhoto(Photo photo);
    boolean deletePhotoById(Integer photoId);
}
