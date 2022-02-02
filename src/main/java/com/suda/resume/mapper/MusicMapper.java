package com.suda.resume.mapper;

import com.suda.resume.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {
    List<Music> getAll();

    List<Music> getByNameOrSinger(@Param("str") String str);

    Music getById(@Param("id") int id);

    int update( Music music);

    int deleteById(@Param("id") int id);

    int add(Music music);
}
