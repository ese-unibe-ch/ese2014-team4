package ch.unibe.ese2014.team4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ch.unibe.ese2014.team4.controller.pojos.Sex;

//TODO: add more profile stuff.
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User owner;
    private int age;
    private String description;
    private Sex sex;  
    
    
    public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

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


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return "Profile of " + owner.getUsername();
	}
}
