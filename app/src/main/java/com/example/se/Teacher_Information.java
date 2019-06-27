package com.example.se;

import android.widget.EditText;

import cn.bmob.v3.BmobObject;

public class Teacher_Information extends BmobObject {
    private String name;
   private String id;
   private String real_id;
    private String address;
    private String sex;
    private String age;
    private String area;
    private String years;
    private String fit_age;
    private String phone;
    private String password;
    private String introducation;
    private String mail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{"+"name='"+name+'\''+",address'"+ address + '\'' + '}';

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getFit_age() {
        return fit_age;
    }

    public void setFit_age(String fit_age) {
        this.fit_age = fit_age;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroducation() {
        return introducation;
    }

    public void setIntroducation(String introducation) {
        this.introducation = introducation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReal_id() {
        return real_id;
    }

    public void setReal_id(String real_id) {
        this.real_id = real_id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
