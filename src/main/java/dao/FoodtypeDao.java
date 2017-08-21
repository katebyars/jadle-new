package dao;


import models.Foodtype;


import java.util.List;

public interface FoodtypeDao {

    //create
    void add(Foodtype foodtype); // Q

    //read
    List<Foodtype> getAll();
    //Foodtype findById(int id);
    // List<Restaurant> getRestaurantsByFoodtype(int id);

    //update
    //void update(String name, int id);

    //delete
    void deleteById(int id); //see above
}
