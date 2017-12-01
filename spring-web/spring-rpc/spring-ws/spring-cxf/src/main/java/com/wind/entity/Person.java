package com.wind.entity;

import java.io.Serializable;

/**
 * rest接口，实现类，实体类
 * @author com.wind
 */
public class Person implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
