package ru.udsu.Model;

public class Provider_shop {
    private Integer id;
    private Integer id_provider;
    private Integer id_shop;

    public Provider_shop(Integer id, Integer id_provider, Integer id_shop) {
        //TODO Конструктор Поставщика-магазина (промежуточная сущность)
        this.id = id;
        this.id_provider = id_provider;
        this.id_shop = id_shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_provider() {
        return id_provider;
    }

    public void setId_provider(Integer id_provider) {
        this.id_provider = id_provider;
    }

    public Integer getId_shop() {
        return id_shop;
    }

    public void setId_shop(Integer id_shop) {
        this.id_shop = id_shop;
    }
}
