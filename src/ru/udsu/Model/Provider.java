package ru.udsu.Model;

public class Provider {
    private Integer id;
    private String name;
    private String adress;
    private String number;
    private Double price_supply;

    public Provider(Integer id, String name, String adress, String number, Double price_supply) {
        //TODO Конструктор Поставщика
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.number = number;
        this.price_supply = price_supply;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getPrice_supply() {
        return price_supply;
    }

    public void setPrice_supply(Double price_supply) {
        this.price_supply = price_supply;
    }
}
