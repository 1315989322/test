package com.example.test.service.impl;

import com.example.test.dao.PhotoDao;
import com.example.test.entity.Photo;
import com.example.test.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDao photoDao;

    @Override
    public List<Photo> findPhotoByStudentPort(Integer studentPort) {
        return photoDao.findPhotoByStudentPort(studentPort);
    }

    @Override
    public boolean insertPhoto(Photo photo) {
        return photoDao.insertPhoto(photo);
    }

    @Override
    public boolean deletePhotoById(Integer photoId) {
        return photoDao.deletePhoto(photoId);
    }
}
