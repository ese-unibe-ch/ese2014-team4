package ch.unibe.ese2014.team4.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    
    private String username;
    private String email;
    
    /**
     * password is saved as a sha-digested hex-string.
     */
    private String password;
    private String role;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getRole() {

		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
