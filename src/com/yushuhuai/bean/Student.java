package com.yushuhuai.bean;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String phone;
    private String clazz_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(String clazz_id) {
        this.clazz_id = clazz_id;
    }

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }



    public Student(Integer id, String name, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }


    public Student(Integer id, String name, String gender, String phone, String clazz_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.clazz_id = clazz_id;
    }

    public Student(String name, String gender, String phone, String clazz_id) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.clazz_id = clazz_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", clazz_id=" + clazz_id +
                "} \n";
    }
}
