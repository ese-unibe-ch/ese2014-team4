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
//    private int price;
    private int netto;
    private int charges;
    private int brutto;
    
	@NotNull
    private String description;   
    private int nrOfFlatMates;  
    
    private String availableDate;

	private AdType adType;
//	private List<User> FlatMates;
	private int nrOfRooms;
    private ArrayList<MultipartFile> uploadedAdPictures = new ArrayList<MultipartFile>();
    
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

	public int getNrOfFlatMates() {
		return nrOfFlatMates;
	}

	public void setNrOfFlatMates(int nrOfFlatMates) {
		this.nrOfFlatMates = nrOfFlatMates;
	}

//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
	
    public int getNetto() {
		return netto;
	}

	public void setNetto(int netto) {
		this.netto = netto;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public int getBrutto() {
		return brutto;
	}

	public void setBrutto() {
		this.brutto = netto+charges;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
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
		this.city = makeCapital(city);
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
		this.street = makeCapital(street);
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

//	public List<User> getFlatMates() {
//		return FlatMates;
//	}
//
//	public void setFlatMates(List<User> FlatMates) {
//		this.FlatMates = FlatMates;
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

	private String makeCapital(String str) {
		String tmp = str;
		String firstChar = tmp.substring(0, 1).toUpperCase();
		String rest = tmp.substring(1, tmp.length()).toLowerCase();
		tmp = firstChar.concat(rest);
		return tmp;
	}

    
}
