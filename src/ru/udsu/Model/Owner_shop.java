package ru.udsu.Model;

public class Owner_shop {
    private Integer id;
    private Integer id_shop;
    private Integer id_owner;

    public Owner_shop(Integer id, Integer id_shop, Integer id_owner) {
        //TODO конструктор владелец-магазин (связующая сущность)
        this.id = id;
        this.id_shop = id_shop;
        this.id_owner = id_owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_shop() {
        return id_shop;
    }

    public void setId_shop(Integer id_shop) {
        this.id_shop = id_shop;
    }

    public Integer getId_owner() {
        return id_owner;
    }

    public void setId_owner(Integer id_owner) {
        this.id_owner = id_owner;
    }
}
