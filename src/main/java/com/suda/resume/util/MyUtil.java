package com.suda.resume.util;

public class MyUtil {
    public static String addPercentSignToString(String string){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("%");
        }
        return stringBuilder.toString();
    }
}
