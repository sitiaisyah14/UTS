package com.example.dtschapter03.models;

public class Contact {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String name;
    private String phone;
    private Integer imageUrl;

    public Contact(String name, String phone, Integer imageUrl) {
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }
}
