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

public class SearchForm {

    @NotNull
    private int minPrice;
    @NotNull
    private int maxPrice = 0;
    
	@NotNull
    private String description;
    private String title;
    private int nrOfFlatMates;
    private int nrOfRooms;
    
    
   

	private Long id;
    
  //Address-Info, same field as Ad itself.
  	private int streetNumber;
    private String cityOrZip;
    private String street;
    
    public int getNrOfRooms() {
		return nrOfRooms;
	}

	public void setNrOfRooms(int nrOfRooms) {
		this.nrOfRooms = nrOfRooms;
	}
    
    public int getNrOfFlatMates() {
		return nrOfFlatMates;
	}

	public void setNrOfFlatMates(int nrOfFlatMates) {
		this.nrOfFlatMates = nrOfFlatMates;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
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

    public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCityOrZip() {
		return cityOrZip;
	}

	public void setCityOrZip(String cityOrZip) {
		this.cityOrZip = cityOrZip;
	}	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}    
}
