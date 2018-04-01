package client.foodpark.com.foodparkclient.Model;

/**
 * Created by dennis on 1/4/18.
 */

public class Food {

    private String Price;
    private String Description;
    private String Name;
    private String MenuId;
    private String Image;
    private String Discount;

    public Food() {
    }

    public Food(String price, String description, String name, String menuId, String image, String discount) {
        Price = price;
        Description = description;
        Name = name;
        MenuId = menuId;
        Image = image;
        Discount = discount;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
