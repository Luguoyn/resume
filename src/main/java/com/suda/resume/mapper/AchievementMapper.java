package com.suda.resume.mapper;

import com.suda.resume.pojo.Achievement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AchievementMapper {

    @Select("SELECT * FROM achievement")
    List<Achievement> getAll();

    @Delete("DELETE FROM achievement WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    @Select("SELECT * FROM achievement WHERE name like #{name}")
    List<Achievement> getByName(@Param("name") String name);

    @Select("SELECT * FROM achievement WHERE id = #{id}")
    Achievement getById(@Param("id") int id);

    @Select("SELECT * FROM achievement WHERE grade >= #{a} AND grade <= #{b}")
    List<Achievement> getByGrade(@Param("a") int min, @Param("b") int max);

    @Select("SELECT * FROM achievement WHERE credit >= #{a} AND credit <= #{b}")
    List<Achievement> getByCredit(@Param("a") int min, @Param("b") int max);

    @Insert("insert into achievement(name, grade, credit)" +
            " values (#{name}, #{grade}, #{credit})")
    int add(Achievement achievement);

    @Update("update achievement " +
            "set name=#{name}, " +
            "    grade=#{grade}, " +
            "    credit=#{credit} " +
            "where id = #{id};")
    int update(Achievement achievement);
}
