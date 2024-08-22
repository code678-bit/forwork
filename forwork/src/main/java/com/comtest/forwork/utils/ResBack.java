package com.comtest.forwork.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBack {

    Integer code;

    String text;

    Object body;


    public static ResBack SUCCESS(Integer code, String text, Object body) {
        return new ResBack(code, text, body);
    }

    public static ResBack FAILURE(Integer code, String text, Object body) {
        return new ResBack(code, text, body);
    }

}
