package com.suda.resume.service;

import com.suda.resume.mapper.AchievementMapper;
import com.suda.resume.pojo.Achievement;
import com.suda.resume.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    AchievementMapper mapper;

    public List<Achievement> getAll() {
        return mapper.getAll();
    }

    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    public List<Achievement> getByName(String name) {
        return mapper.getByName(MyUtil.addPercentSignToString(name));
    }

    public Achievement getById(int id) {
        return mapper.getById(id);
    }

    public List<Achievement> getByGrade(int min, int max) {
        return mapper.getByGrade(min, max);
    }

    public List<Achievement> getByCredit(int min, int max) {
        return mapper.getByCredit(min, max);
    }

    public int add(Achievement achievement) {

        return mapper.add(achievement);

    }

    public int update(Achievement achievement) {

        return mapper.update(achievement);


    }
}
