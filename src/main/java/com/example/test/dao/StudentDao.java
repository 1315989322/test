package com.example.test.dao;

import com.example.test.commons.ClientPage;
import com.example.test.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StudentDao {
    @Insert("insert into student (student_name,student_birthday)values(#{studentName},str_to_date(#{studentBirthday},'%Y-%m-%d'))")
    boolean insertStudent(Student student);
    @Select("select student_port ,student_name ,date_format(student_birthday,'%Y-%m-%d') student_birthday  " +
            "from student limit #{currentPage},#{pageSize}")
    @Results({
            @Result(column = "student_port",property = "studentPort"),
            @Result(column = "student_name",property = "studentName"),
            @Result(column = "student_birthday",property = "studentBirthday")
//            , @Result(property = "photoList",column = "studentPort",many = @Many(select = "com.example.test.dao.findPhotoByStudentPort"))
    }
    )
    List<Student> findAllStudentPage(ClientPage clientPage);

    @Select("select count(*) from student")
    Integer selectCount();

    @Select("select student_port ,student_name ,date_format(student_birthday,'%Y-%m-%d') student_birthday  " +
            "from student where student_port=#{studentPort}")
    @Results({
            @Result(column = "student_port",property = "studentPort"),
            @Result(column = "student_name",property = "studentName"),
            @Result(column = "student_birthday",property = "studentBirthday")
    })
    Student findStudentByStudentPort(Integer studentPort);

    @Delete("delete from student where student_port=#{studentPort}")
    boolean deleteStudentByStudentPort(Integer studentPort);

    @Update(
            "update student set student_name=#{studentName}" +
            ",student_birthday=str_to_date(#{studentBirthday},'%Y-%m-%d')" +
            " where student_port=#{studentPort}" )
    boolean updateStudentInfo(Student student);

}
