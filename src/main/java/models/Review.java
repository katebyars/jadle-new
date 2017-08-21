package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Review {

    private String writtenBy;
    private int rating;
    private Timestamp createdAt;
    private int id;
    private int restaurantId; //i will be used to connect Restaurant to Review.
    private String content;

    public Review(String writtenBy, int rating, int restaurantId) {
        this.writtenBy = writtenBy;
        this.rating = rating;
        this.restaurantId = restaurantId;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
