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

import ch.unibe.ese2014.team4.controller.pojos.Sex;



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
    
    private Sex sex;
    private String age;
    private String phoneNumber;
    private String userDescription;

    
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;
    
	@Lob 
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "bookmarks", joinColumns = @JoinColumn(name = "user_id"))
    private List<Long> bookmarks = new ArrayList<Long>();

	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
	private Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	 public List<Long> getBookmarks() {
			return bookmarks;
	}
	 
	public void setBookmarks(List<Long> bookmarks) {
		this.bookmarks = bookmarks;
	}
	
	
	@Lob 
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "inbox", joinColumns = @JoinColumn(name = "user_id"))
	public List<Long> inbox = new ArrayList<Long>();
	
	@Lob 
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "sent", joinColumns = @JoinColumn(name = "user_id"))
	public List<Long> sent = new ArrayList<Long>();
	
    
	public User(){
    	this.profile = new Profile();
    	this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
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


	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
//UserDetails methods
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}
	
	public void setAuthorities(Collection<GrantedAuthority> authorities){
		this.authorities = authorities;
	}



	
	//all set to return true, otherwise user cannot login.
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
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Long> getInbox() {
		return inbox;
	}

	public void setInbox(List<Long> inbox) {
		this.inbox = inbox;
	}

	public List<Long> getSent() {
		return sent;
	}

	public void setSent(List<Long> sent) {
		this.sent = sent;
	}





}
