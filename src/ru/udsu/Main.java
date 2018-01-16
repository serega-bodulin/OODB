package ru.udsu;

import com.db4o.*;
import com.db4o.query.Predicate;
import ru.udsu.Model.Owner;
import ru.udsu.Model.Provider;
import ru.udsu.Model.Shop;

import java.util.Date;
import java.util.List;

public class Main{


    public static void main(String[] args) {

        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DataBase_Shop");

        try{
            //Заполнение

            addShop(db,01, "Five", "40 let pobedi 5-21",
                    "8999955", 10000,
                    "Продуктовый");
            //clearDb(db);
            ObjectSet<?> result = db.query(Shop.class);
            listResult(result);

        } finally {
            db.close();
        }

    }

    public static void listResult(List<?> result) {
        for (Object obj:
             result) {
            System.out.println(result);
        }
    }

    public static void clearDb(ObjectContainer db) {
        ObjectSet result = db.queryByExample(new Object());
        while (result.hasNext()) db.delete(result.hasNext());
    }

    public static void addOwner(ObjectContainer db, Integer id, String name, String phone, String adress, String contribution, String number_reg, Date date_reg) {
        ObjectSet oldOwner = findOwner(db, name);

        if(oldOwner.size() == 0){
            Owner newOwner = new Owner(id, name, phone, adress,
                    contribution, number_reg, date_reg);
            db.store(newOwner);
        } else {
            System.out.println("Owner: " + name + " : " + number_reg);
        }
    }

    public static ObjectSet findOwner(ObjectContainer db, String name) {
        ObjectSet owner = db.query(new Predicate<Owner>() {
            @Override
            public boolean match(Owner owner) {
                return owner.getName().equals(name);
            }
        });
        return owner;
    }

    public static void addProvider(ObjectContainer db, Integer id, String name, String adress, String number, Double price_supply) {
        ObjectSet oldProvider = findProvider(db, name);
        if(oldProvider.size() == 0){
            Provider newProvider = new Provider(id, name, adress,
                    number, price_supply);
            db.store(newProvider);
        } else {
            System.out.println("Provider: " + name + " : " +
            price_supply);
        }
    }

    public static ObjectSet findProvider(ObjectContainer db, String name) {
        ObjectSet provider = db.query(new Predicate<Provider>() {
            @Override
            public boolean match(Provider provider) {
                return provider.getName().equals(name);
            }
        });
        return provider;
    }

    public static void addShop(ObjectContainer db, Integer id, String name, String adress, String phone, Integer auth_capital, String profile) {
        ObjectSet oldShop =  findShop(db, name);
        if(oldShop.size() == 0){
            Shop newShop = new Shop(id, name, adress, phone,
                    auth_capital, profile);
            db.store(newShop);
        } else {
            System.out.println("Shop: " + name + " : " + profile +
                    " : " + auth_capital);
        }
    }

    public static ObjectSet findShop(ObjectContainer db, String name) {
        ObjectSet shop = db.query(new Predicate<Shop>() {
            @Override
            public boolean match(Shop shop) {
                return shop.getName().equals(name);
            }
        });
        return shop;
    }


}
