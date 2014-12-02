package ch.unibe.ese2014.team4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import ch.unibe.ese2014.team4.controller.pojos.AdType;

/**
 * Used to transfer ad-information from form to controller.
 * If you add more fields: Need to be added in Ad.java and in corresponding forms in *.jps.
 */

@Entity
public class SearchForm {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;
	
    
    private int minPrice; 
    private int maxPrice;

    private int minNrOfFlatMates;
    private int maxNrOfFlatMates;
    private float minNrOfRooms;
    private float maxNrOfRooms;
    private AdType adType;
    
    private String availableDate;
    
    private String orderBy;
   

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

    
  //Address-Info, same field as Ad itself.
    private String cityOrZip;
    
    public float getMinNrOfRooms() {
		return minNrOfRooms;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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



	public String getCityOrZip() {
		return cityOrZip;
	}

	public void setCityOrZip(String cityOrZip) {
		this.cityOrZip = cityOrZip;
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
