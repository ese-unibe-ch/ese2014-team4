package ch.unibe.ese2014.team4.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
public class User implements UserDetails {



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
    
	@Lob 
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "bookmarks", joinColumns = @JoinColumn(name = "user_id"))
    private List<Long> bookmarks = new ArrayList<Long>();
    
    public List<Long> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(List<Long> bookmarks) {
		this.bookmarks = bookmarks;
	}
	public User(){
    	this.profile = new Profile();
    	this.profile.setOwner(this);
    	this.role = "ROLE_USER";
    }
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
//UserDetails methods
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> list = translateRole(role);
		return list;
	}

	private ArrayList<GrantedAuthority> translateRole(String roleString){
		ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		/*
		switch(roleString){											//change, if java < 1.7 
		case "ROLE_ADMIN":
			list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));		//no break on purpose!
		case "ROLE_USER":
			list.add(new SimpleGrantedAuthority("ROLE_USER"));
		default:
			list.add(new SimpleGrantedAuthority("ROLE_USER"));		//to support old users with role = null.
		}*/
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
		return list;
	}

	
	//all set to "user has access"
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
