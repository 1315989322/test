package com.example.test.controller;

import com.example.test.entity.Photo;
import com.example.test.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PhotoController {


    @Autowired
    private PhotoService photoService;
    @RequestMapping("/upload")
    public String upload(Integer studentPort, String photoBase64, Model model) throws IOException {
        Photo photo = new Photo();
//        System.out.println(photoBase64);
        byte[] tmp = photoBase64.getBytes();
        photo.setPhotoFile(tmp);
        photo.setStudentPort(studentPort);
        boolean flag = photoService.insertPhoto(photo);
        if (flag) {
            model.addAttribute("message", "上传成功");
            return "forward:/userList";
        }
        model.addAttribute("message", "上传失败");
        return "forward:/userList";
    }

    @RequestMapping("/lookPhoto/{studentPort}")
    public String look(@PathVariable("studentPort") Integer studentPort, Model model) throws UnsupportedEncodingException {

        List<Photo> photos = photoService.findPhotoByStudentPort(studentPort);
        for (Photo photo : photos
                ) {
            photo.setPhotoStr(new String(photo.getPhotoFile(), "UTF-8"));
        }
        model.addAttribute("photos",photos);
        return "forward:/userList";
    }

    @RequestMapping("deletePhoto")
    public @ResponseBody String deletePhoto(@RequestParam Integer photoId){
        boolean flag=photoService.deletePhotoById(photoId);
        if(flag){
            return "删除成功";
        }
        return "删除失败";
    }
}
