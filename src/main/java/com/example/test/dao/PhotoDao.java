package com.example.test.dao;

import com.example.test.entity.Photo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PhotoDao {
   @Select("select photo_id ,student_port ,photo_file from photo where student_port=#{studentPort}")
   @Results(
           {
                @Result(property = "photoId",column = "photo_id"),
                @Result(property = "studentPort",column = "student_port"),
                @Result(property = "photoFile",column = "photo_file",jdbcType = JdbcType.BLOB)
           }
   )
   List<Photo> findPhotoByStudentPort(Integer studentPort);

   @Insert("insert into photo (student_port,photo_file) values(#{studentPort},#{photoFile})")
   boolean insertPhoto(Photo photo);

   @Delete("delete from photo where photo_id=#{photoId}")
   boolean deletePhoto(Integer photoId);
}
