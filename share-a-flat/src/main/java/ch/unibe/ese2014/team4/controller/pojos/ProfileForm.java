package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;



public class ProfileForm {
//TODO: add profile stuff.

	private String phoneNumber;
    private String age;
    private Sex sex;
    private String userDescription;
    private MultipartFile uploadedProfileImage;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a User Name")
    private String username;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
    private String password;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please renter the Password")
    private String passwordRepeated;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please renter the Password")
    private String oldPassword;


    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
    message = "Must be valid email address")
    private String email;

	/**
	 * @return String age.
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param String age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return Sex sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * @param Sex sex
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}


	/**
	 * @return String userDescription
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * @param String userDescription
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}


	/**
	 * @return MultipartFile uploadedProfileImage
	 */
	public MultipartFile getUploadedProfileImage() {
		return uploadedProfileImage;
	}

	/**
	 * @param MultipartFile uploadedProfileImage, containing profile image.
	 */
	public void setUploadedProfileImage(MultipartFile uploadedProfileImage) {
		this.uploadedProfileImage = uploadedProfileImage;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordRepeated(){
		return passwordRepeated;
	}
	
	public void setPasswordRepeated(String passwordRepeated){
		this.passwordRepeated = passwordRepeated;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	

}
