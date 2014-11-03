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
    
 

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public MultipartFile getUploadedProfileImage() {
		return uploadedProfileImage;
	}

	public void setUploadedProfileImage(MultipartFile uploadedProfileImage) {
		this.uploadedProfileImage = uploadedProfileImage;
	}
}
