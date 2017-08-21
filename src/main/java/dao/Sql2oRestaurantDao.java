package dao;

import models.Restaurant;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oRestaurantDao implements RestaurantDao{

    private final Sql2o sql2o;

    public Sql2oRestaurantDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Restaurant restaurant){
        String sql = "INSERT INTO restaurants (name, address, zipcode, phone, diningStyle) VALUES (:name, :address, :zipcode, :phone, :diningStyle)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(restaurant)
                    .executeUpdate()
                    .getKey();
            restaurant.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Restaurant> getAll(){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM restaurants")
                    .executeAndFetch(Restaurant.class);
        }
    }

    @Override
    public Restaurant findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM restaurants WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Restaurant.class);
        }
    }

    @Override
    public void update(int id, String name, String address, String zipcode, String phone, String website, String email, String image){
        String sql = "UPDATE restaurants SET (name, address, zipcode, phone, website, email, image) = (:name, :address, :zipcode, :phone, :website, :email, :image) WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("address", address)
                    .addParameter("zipcode", zipcode)
                    .addParameter("phone", phone)
                    .addParameter("website", website)
                    .addParameter("email", email)
                    .addParameter("image", image)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        try (Connection con = sql2o.open()){
            con.createQuery("DELETE FROM restaurants WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
