package com.example.test.controller;
import com.example.test.entity.Student;
import com.example.test.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/deleteStudent/{studentPort}")
    public String deleteStudent(@PathVariable("studentPort") Integer studentPort,Model model){
        boolean flag= studentService.deleteStudentByStudentPort(studentPort);
        if(flag){
            String message="删除成功";
            model.addAttribute("message",message);
            return "forward:/userList";
        }
        String message="删除失败";
        model.addAttribute("message",message);
        return "forward:/userList";
    }

    @RequestMapping("/updateStudent")
    public String update(@Validated Student student,Model model){
      boolean flag= studentService.updateStudentInfo(student);
      if(flag){
          String message="修改成功";
          model.addAttribute("message",message);
          return "forward:/userList";
      }
        String message="修改失败";
        model.addAttribute("message",message);
        return "forward:/userList";
    }

    @RequestMapping("/addStudent")
    public String addStudent(@Validated Student student, Model model){
    boolean  flag=studentService.insertStudent(student);
    if(flag){
        String message="添加成功";
        model.addAttribute("message",message);
        return "forward:/userList";
    }
        String message="添加失败";
        model.addAttribute("message",message);
        return "forward:/userList";
    }
}

