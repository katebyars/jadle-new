package dao;


import models.Foodtype;
import models.Restaurant;


import java.util.List;

public interface FoodtypeDao {

    //create
    void add(Foodtype foodtype);
    void addFoodtypeToRestaurant(Restaurant restaurant, Foodtype foodtype);

    //read
    List<Foodtype> getAll();
    Foodtype findById(int id);
    List<Restaurant> getAllRestaurantsForAFoodtype(int id);


    //update
    //void update(String name, int id);

    //delete
    void deleteById(int id); //see above
}
