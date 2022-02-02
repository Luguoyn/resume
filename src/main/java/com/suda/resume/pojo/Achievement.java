package com.suda.resume.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    private int id;
    private String name;
    private int grade;
    private int credit;
}
