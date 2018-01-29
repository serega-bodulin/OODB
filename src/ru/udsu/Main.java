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
            //МАГАЗИНЫ
            addShop(db,01, "Пятерочка", "Школьная ",
                    "123", 10000,
                    "Продуктовый");
            addShop(db,02, "SunRise", "Студенческая",
                    "1234", 15000,
                    "Ювелирный");
            addShop(db,03, "Хозтовары", "30 лет победы",
                    "12345", 12000,
                    "Хозяйственный");
            addShop(db,04, "Куртки", "40 лет победы",
                    "123456", 10000,
                    "Кожгалантерея");
            addShop(db,05, "Adidas", "50 ВЛКСМ",
                    "1234567", 13000,
                    "Одежда");
            addShop(db,05, "Nike", "Ленина",
                    "12345678", 12000,
                    "Одежда");
            //ВЛАДЕЛЬЦЫ
            addOwner(db,1,"Петров Иван Иванович","+7(950)123-45-67",
                    "10 лет победы", "150000",
                    "1", "01/05/2017");
            addOwner(db,2,"Петрова Людмила Алексеевна","+7(912)123-45-67",
                    "20 лет победы", "75000",
                    "2", "22/02/2013");
            addOwner(db,3,"Сергеев Сергей Сергеевич","+7(963)123-45-67",
                    "30 лет победы", "500000",
                    "3", "12/04/2011");
            addOwner(db,4,"Иванов Иван Иванович","+7(951)123-45-67",
                    "Школьная", "20000",
                    "4", "13/07/2017");
            addOwner(db,5,"Сидорова Анна Ивановна","+7(952)123-45-67",
                    "Песочная", "15000",
                    "5", "22/06/2014");
            addOwner(db,6,"Максимов Максим Антонович","+7(950)000-05-07",
                    "Молодежная", "8000",
                    "6", "01/11/2017");
            addOwner(db,7,"Антонов Антон Иванович","+7(982)222-33-44",
                    "Советская", "60000",
                    "7", "12/04/2016");
            addOwner(db,8,"Михайлов Михаил Михайлович","+7(963)111-22-44",
                    "Удмуртская", "25000",
                    "8", "14/02/2012");
            addOwner(db,9,"Бобров Борис Борисович","+7(912)000-22-44",
                    "Удмуртская", "25000",
                    "9", "14/02/2012");
            addProvider(db,1,"Сидоров Андрей Вячеславович","Курортная",
                    "+7(950)125-25-25",700000.0);
            addProvider(db,2,"Белоусов Юрий Васильевич","Воткинское шоссе",
                    "+7(911)111-11-11",100000.0);
            addProvider(db,3,"Григорьев Владимир Артемович","Спортивная",
                    "+7(922)222-22-22",40000.0);
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

    public static void addOwner(ObjectContainer db, Integer id, String name, String phone, String adress, String contribution, String number_reg, String date_reg) {
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
    //поиск самого дорогого поставщика
}
