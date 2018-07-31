package com.example.test.controller;

import com.example.test.commons.ClientPage;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/photo")
    public String photo(){

        return "photo";
    }
    @RequestMapping("/userList")
    public String userList(ClientPage clientPage,Model model){
        int pages=studentService.selectCount();
        pages=(int)Math.floor(pages/clientPage.getPageSize());
        if(clientPage==null){
            clientPage=new ClientPage();
        }
        if(clientPage.getPageNum()<=0){
            clientPage.setPageNum(1);
        }
        if(clientPage.getPageNum()>pages){
            clientPage.setPageNum(pages);
        }

        List<Student> students= studentService.findAllStudentPage(clientPage);
        model.addAttribute("students",students);
        model.addAttribute("clientPage",clientPage);
        return "userList";
    }

    @RequestMapping("/toUpdate/{studentPort}")
    public String toUpdate(@PathVariable("studentPort")Integer studentPort, Model model){
        Student student=studentService.findStudentByStudentPort(studentPort);
        model.addAttribute("student",student);
        return "updateStudent";
    }
}
