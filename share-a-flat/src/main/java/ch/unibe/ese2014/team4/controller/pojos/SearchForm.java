package ch.unibe.ese2014.team4.controller.pojos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private int maxPrice;
    
	@NotNull
    private String description;
    private String title;
    private int minNrOfFlatMates;
    private int maxNrOfFlatMates;
    private float minNrOfRooms;
    private float maxNrOfRooms;
    private AdType adType;
    
    private String availableDate;
   

	private Long id;
    
  //Address-Info, same field as Ad itself.
  	private int streetNumber;
    private String cityOrZip;
    private String street;
    
    public float getMinNrOfRooms() {
		return minNrOfRooms;
	}

	public void setMinNrOfRooms(float minNrOfRooms) {
		this.minNrOfRooms = minNrOfRooms;
	}
	
	public float getMaxNrOfRooms() {
		return maxNrOfRooms;
	}

	public void setMaxNrOfRooms(float maxNrOfRooms) {
		this.maxNrOfRooms = maxNrOfRooms;
	}
	
    
    public int getMinNrOfFlatMates() {
		return minNrOfFlatMates;
	}

	public void setMinNrOfFlatMates(int minNrOfFlatMates) {
		this.minNrOfFlatMates = minNrOfFlatMates;
	}

	public int getMaxNrOfFlatMates() {
		return maxNrOfFlatMates;
	}

	public void setMaxNrOfFlatMates(int maxNrOfFlatMates) {
		this.maxNrOfFlatMates = maxNrOfFlatMates;
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

	public AdType getAdType() {
		return adType;
	}

	public void setAdType(AdType adType) {
		this.adType = adType;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {		
		this.availableDate = availableDate;
	}

	
	 
}
