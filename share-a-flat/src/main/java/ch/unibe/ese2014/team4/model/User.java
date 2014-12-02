package ch.unibe.ese2014.team4.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
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

    //password is saved as a sha-digested hex-string.
    private String password;
    
    private Sex sex;
    private String age;
    private String phoneNumber;
    private String userDescription;

    
    @OneToOne(cascade = {CascadeType.ALL})
    private Profile profile;
    
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
	private Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    
	@Lob 
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "bookmarks", joinColumns = @JoinColumn(name = "user_id"))
    private List<Long> bookmarks = new ArrayList<Long>();
	
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
	
	
	 public List<Long> getBookmarks() {
			return bookmarks;
	}
	 
	public void setBookmarks(List<Long> bookmarks) {
		this.bookmarks = bookmarks;
	}
	
	public User(){
    	this.profile = new Profile();
    	this.authorities.add(new SimpleGrantedAuthority("ROLE_REGISTERED"));
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
	public Collection<GrantedAuthority> getAuthorities() {

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
		
		return this.authorities.contains(new SimpleGrantedAuthority("ROLE_USER"));
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result
				+ ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result
				+ ((bookmarks == null) ? 0 : bookmarks.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inbox == null) ? 0 : inbox.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((sent == null) ? 0 : sent.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result
				+ ((userDescription == null) ? 0 : userDescription.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (bookmarks == null) {
			if (other.bookmarks != null)
				return false;
		} else if (!bookmarks.equals(other.bookmarks))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inbox == null) {
			if (other.inbox != null)
				return false;
		} else if (!inbox.equals(other.inbox))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (sent == null) {
			if (other.sent != null)
				return false;
		} else if (!sent.equals(other.sent))
			return false;
		if (sex != other.sex)
			return false;
		if (userDescription == null) {
			if (other.userDescription != null)
				return false;
		} else if (!userDescription.equals(other.userDescription))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
