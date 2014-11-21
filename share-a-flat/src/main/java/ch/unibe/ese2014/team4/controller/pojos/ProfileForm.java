package ch.unibe.ese2014.team4.controller.pojos;

import org.springframework.web.multipart.MultipartFile;



public class ProfileForm {
//TODO: add profile stuff.


    
    private int age;
    private String description;
    private Sex sex;
    private String phoneNumber;
    private MultipartFile uploadedProfileImage;
    
 

	/**
	 * @return int age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param int age
	 */
	public void setAge(int age) {
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
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param String description
	 */
	public void setDescription(String description) {
		this.description = description;
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
}
