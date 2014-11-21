package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.BitField;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.model.User;



public class ProfileForm {
//TODO: add profile stuff.


    
    private int age;
    private String description;
    private Sex sex;
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
}
