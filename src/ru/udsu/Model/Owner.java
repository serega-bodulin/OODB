package ru.udsu.Model;

import java.util.Date;

public class Owner {
    private Integer id;
    private String name;
    private String phone;
    private String adress;
    private String contribution;
    private String number_reg;
    private String date_reg;

    public Owner(Integer id, String name, String phone, String adress, String contribution, String number_reg, String date_reg) {
        //TODO коснтруктор владелец
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.contribution = contribution;
        this.number_reg = number_reg;
        this.date_reg = date_reg;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getNumber_reg() {
        return number_reg;
    }

    public void setNumber_reg(String number_reg) {
        this.number_reg = number_reg;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }
}
