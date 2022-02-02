package com.suda.resume.service;

import com.suda.resume.mapper.MusicMapper;
import com.suda.resume.pojo.Music;
import com.suda.resume.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicMapper mapper;

    public List<Music> getAll() {
        return mapper.getAll();
    }

    public List<Music> getByNameOrSinger(String str) {
        return mapper.getByNameOrSinger(MyUtil.addPercentSignToString(str));
    }

    public Music getById(int id){
        return mapper.getById(id);
    }

    public int update(Music music){
        return mapper.update(music);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }

    public int add(Music music){
        return mapper.add(music);
    }
}
