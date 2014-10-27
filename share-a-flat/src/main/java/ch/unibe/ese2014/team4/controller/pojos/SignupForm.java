package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class SignupForm {
//TODO: validate password = passwordRepeated

    private Long id;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a User Name")
    private String username;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
    private String password;
    
    @NotNull
    private String passwordRepeated;


    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
    message = "Must be valid email address")
    private String email;

    public String getUsername() {
        return username;
    }
    
    
    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
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
