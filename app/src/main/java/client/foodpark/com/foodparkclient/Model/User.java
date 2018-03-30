package client.foodpark.com.foodparkclient.Model;

/**
 * Created by dennis on 31/3/18.
 */

public class User {

    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;


    public User() {
    }


    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
