package ch.unibe.ese2014.team4.controller.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import ch.unibe.ese2014.team4.model.Address;

/**
 * Used to transfer ad-information from form to controller.
 * If you add more fields: Need to be added in Ad.java and in corresponding forms in *.jps.
 */

public class AdForm {


    private Long id;
    
    @NotNull
    private String place;

    @NotNull
    private int price;

    @NotNull
    private String description;

    private String title;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//Address-Info, same field as Ad itself.
	private int streetNumber;
    private String city;
    private int zipCode;
    
    private String street;
    public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
    
    

    
}
