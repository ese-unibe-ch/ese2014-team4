package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignupForm {


    private Long id;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a User Name")
    private String userName;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
    private String password;


    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
    message = "Must be valid email address")
    private String email;

    public String getUserName() {
        return userName;
    }
    
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
