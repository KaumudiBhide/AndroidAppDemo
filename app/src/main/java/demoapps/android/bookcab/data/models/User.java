package demoapps.android.bookcab.data.models;

public class User {

    public String name;
    public String password;
    public String email;
    public String phone;
    public String address;

    public static final String DEFAULT_USER = "Raj Malhotra";
    public static final  String DEFAULT_PWD = "DDLJ";
    public static final  String DEFAULT_EMAIL = "raj.malhotra@yashraj.com";
    public static final  String DEFAULT_PHONE = "9988511223";
    public static final  String DEFAULT_ADDR = "Trafalgar Square, London";

    public User() {
        this.clearProfile();
    }

    public void clearProfile() {
        this.name = "";
        this.password = "";
        this.email = "";
        this.phone = "";
        this.address = "";
    }

    public void setDefaultProfile() {
        this.name = DEFAULT_USER;
        this.password = DEFAULT_PWD;
        this.email = DEFAULT_EMAIL;
        this.phone = DEFAULT_PHONE;
        this.address = DEFAULT_ADDR;
    }
}
