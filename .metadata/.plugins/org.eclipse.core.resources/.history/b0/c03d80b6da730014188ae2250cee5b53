package ch.unibe.ese2014.team4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.apache.commons.lang.BitField;

import ch.unibe.ese2014.team4.controller.pojos.Sex;

//TODO: add more profile stuff.
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private Long id;


    private String age;
    private String userDescription;
    private Sex sex; 
    private String phoneNumber;
	private String username;
	private String email;
    /**
     * password is saved as a sha-digested hex-string.
     */
	private String password;
    
    @Lob //big data format
    @Column(name="profileImage",  columnDefinition="mediumblob")
    private byte[] profileImage;


	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
	public String toString(){
		return "Profile Id " + this.id;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	
	public String getEmail(){
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
