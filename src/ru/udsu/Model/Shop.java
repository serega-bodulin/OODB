package ru.udsu.Model;

public class Shop {
    private Integer id;
    private String name;
    private String adress;
    private String phone;
    private Integer auth_capital; //уставной капитал
    private String profile;

    public Shop(Integer id, String name, String adress, String phone, Integer auth_capital, String profile) {
        //TODO конструктор магазин
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.auth_capital = auth_capital;
        this.profile = profile;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAuth_capital() {
        return auth_capital;
    }

    public void setAuth_capital(Integer auth_capital) {
        this.auth_capital = auth_capital;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
