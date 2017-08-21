package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Review {

    private int id;
    private String writtenBy;
    private int rating;
    private Timestamp createdAt;
    private int restaurantId;
    private String content;

    public Review(String writtenBy, int rating, int restaurantId, String content) {
        this.writtenBy = writtenBy;
        this.rating = rating;
        this.restaurantId = restaurantId;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.content = content;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (rating != review.rating) return false;
        if (restaurantId != review.restaurantId) return false;
        if (!writtenBy.equals(review.writtenBy)) return false;
        return content.equals(review.content);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + writtenBy.hashCode();
        result = 31 * result + rating;
        result = 31 * result + restaurantId;
        result = 31 * result + content.hashCode();
        return result;
    }
}
