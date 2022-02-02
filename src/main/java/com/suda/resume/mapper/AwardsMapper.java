package com.suda.resume.mapper;

import com.suda.resume.pojo.Awards;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardsMapper {
    List<Awards> getAll();

    List<Awards> getByName(String name);

    Awards getById(int id);

    int add(Awards awards);

    int update(Awards awards);

    int deleteById(int id);
}
