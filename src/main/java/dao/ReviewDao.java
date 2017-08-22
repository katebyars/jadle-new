package dao;


import models.Review;

import java.util.List;

public interface ReviewDao {

    //create
    void add (Review review);

    //read
    //List<Review> getAll(); //Admin may want to view all reviews together to check for trolls
    Review findById(int id);
    List<Review> getAllReviewsByRestaurant(int restaurantId);

    //update
    void update(String writtenBy, int rating, int restaurantId, int id, String content);

    //delete
    void deleteById(int id);
    //void clearAll();
}
