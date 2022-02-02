package com.suda.resume.service;

import com.suda.resume.mapper.AwardsMapper;
import com.suda.resume.pojo.Awards;
import com.suda.resume.pojo.Music;
import com.suda.resume.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService {
    @Autowired
    AwardsMapper mapper;

    public List<Awards> getAll(){
        return mapper.getAll();
    }

    public List<Awards> getByName(String name){
        return mapper.getByName(MyUtil.addPercentSignToString(name));
    }

    public Awards getById(int id){
        return mapper.getById(id);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }

    public int update(Awards awards){
        return mapper.update(awards);
    }

    public int add(Awards awards){
        return mapper.add(awards);
    }


}
