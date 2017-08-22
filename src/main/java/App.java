import com.google.gson.Gson;
import dao.Sql2oFoodtypeDao;
import dao.Sql2oRestaurantDao;
import dao.Sql2oReviewDao;
import models.Foodtype;
import models.Restaurant;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oFoodtypeDao foodtypeDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oReviewDao reviewDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'"; //check me!

        Sql2o sql2o = new Sql2o(connectionString, "", "");
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();


        //CREATE
        post("/restaurants/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class); //make java from JSON with GSON
            restaurantDao.add(restaurant); //Do our thing with our DAO
            res.status(201);
            return gson.toJson(restaurant); //send it back to be displayed
        });
        post("/foodtypes/new", "application/json", (req, res) ->{
            Foodtype foodtype = gson.fromJson(req.body(), Foodtype.class);
            foodtypeDao.add(foodtype);
            res.status(201);
            return gson.toJson(foodtype);
        });
        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setRestaurantId(restaurantId);
            reviewDao.add(review);
            res.status(201);
            return gson.toJson(review);
        });

        //READ
        get("/restaurants", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(restaurantDao.getAll());//send it back to be displayed
        });
        get("/foodtypes", "application/json", (req, res) -> {
            return gson.toJson(foodtypeDao.getAll());
        });


        get("/restaurants/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(restaurantDao.findById(restaurantId));
         });
        get("/foodtypes/:id", "application/json", (req, res) -> {
            int foodtypeId = Integer.parseInt(req.params("id")) ;
            return gson.toJson(foodtypeDao.findById(foodtypeId));
         });
        get("/reviews/:id", "application/json", (req, res) -> {
           int reviewId = Integer.parseInt(req.params("id"));
           return gson.toJson(reviewDao.findById(reviewId));
        });

        //Filters
        after((req, res) ->{
           res.type("application/json");
        });
    }
}