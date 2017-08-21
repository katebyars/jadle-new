package models;


public class Restaurant {

    private String name;
    private String address;
    private String zipcode;
    private String phone;
    private String website;
    private String email;
    private String image;
    private int id;
    private DiningStyle diningStyle;

    public Restaurant(String name, String address, String zipcode, String phone, DiningStyle diningStyle) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = "no website listed";
        this.email = "no email available";
        this.image = "/resources/images/uploads/no_image.jpg";
        this.diningStyle = diningStyle;

    }

    public Restaurant(String name, String address, String zipcode, String phone, String website, String email, String image,  DiningStyle diningStyle) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
        this.email = email;
        this.image = image;
        this.diningStyle = diningStyle;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiningStyle getDiningStyle() {
        return diningStyle;
    }

    public void setDiningStyle(DiningStyle diningStyle) {
        this.diningStyle = diningStyle;
    }
}
