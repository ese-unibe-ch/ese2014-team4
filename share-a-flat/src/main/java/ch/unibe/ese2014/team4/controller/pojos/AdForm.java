package ch.unibe.ese2014.team4.controller.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;

/**
 * Used to transfer ad-information from form to controller.
 * If you add more fields: Need to be added in Ad.java and in corresponding forms in *.jps.
 */

public class AdForm {

	private Long id;
	
	private String title;
	private int size;
    @NotNull
    private int price;
    @NotNull
    private String description;   
    private int nrOfRoomMates;  
    
//    private Date fromDate;
//    private Date toDate;
    
	private AdType adType;
//	private List<User> roomMates;
	private int nrOfRooms;
    private ArrayList<MultipartFile> uploadedAdPictures;
    
  //Address-Info, same field as Ad itself.
    private String street;
    private int streetNumber;
    private String city;
    private int zipCode;


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

//	public Date getFromDate() {
//		return fromDate;
//	}
//
//	public void setFromDate(Date fromDate) {
//		this.fromDate = fromDate;
//	}
//
//	public Date getToDate() {
//		return toDate;
//	}
//
//	public void setToDate(Date toDate) {
//		this.toDate = toDate;
//	}

	public int getNrOfRoomMates() {
		return nrOfRoomMates;
	}

	public void setNrOfRoomMates(int nrOfRoomMates) {
		this.nrOfRoomMates = nrOfRoomMates;
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
		this.city = city.toLowerCase();
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdType getAdType() {
		return adType;
	}

	public void setAdType(AdType type) {
		this.adType = type;
	}

//	public List<User> getRoomMates() {
//		return roomMates;
//	}
//
//	public void setRoomMates(List<User> roomMates) {
//		this.roomMates = roomMates;
//	}

	public int getNrOfRooms() {
		return nrOfRooms;
	}

	public void setNrOfRooms(int nrOfRooms) {
		this.nrOfRooms = nrOfRooms;
	}

	public ArrayList<MultipartFile> getUploadedAdPictures() {
		return uploadedAdPictures;
	}

	public void setUploadedAdPictures(ArrayList<MultipartFile> uploadedAdPictures) {
		this.uploadedAdPictures = uploadedAdPictures;
	}


    

    
}
