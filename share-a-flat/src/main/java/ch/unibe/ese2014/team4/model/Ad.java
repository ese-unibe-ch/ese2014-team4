package ch.unibe.ese2014.team4.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.mapping.Map;

import ch.unibe.ese2014.team4.controller.pojos.AdType;

@Entity
public class Ad {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	// many Ads, one user
	@JoinColumn(name = "user_id")
	private User owner;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Address address;

	private AdType type;

	// @OneToMany(targetEntity=User.class)
	// private List<User> FlatMate;
	private int nrOfRooms;
	
	@Lob 
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name="LIST_INDEX")
	@CollectionTable(name = "adPictures", joinColumns = @JoinColumn(name = "ad_id"))
	private List<byte[]> bytePictureList = new ArrayList<byte[]>();

	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "visitList", joinColumns = @JoinColumn(name = "visit_id"))
	private List<Visit> visitList = new ArrayList<Visit>();
	
	private Date creationDate = new Date();

	public List<Visit> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}

	private String title;
	private int size;
//	private int price;
	private int netto;
	private int charges;
	private int brutto;
	private Date availableDate;
	private String description;

	private String nrOfFlatMates;


	public void setBytePictureList(List<byte[]> bytePictureList) {
		this.bytePictureList = bytePictureList;
	}

	public List<byte[]> getBytePictureList() {
		return bytePictureList;
	}

	public AdType getType() {
		return type;
	}

	public void setType(AdType type) {
		this.type = type;
	}

	public int getNrOfRooms() {
		return nrOfRooms;
	}

	public void setNrOfRooms(int nrOfRooms) {
		this.nrOfRooms = nrOfRooms;
	}

	public Date getAdAddedDate() {
		return creationDate;
	}

	public void setAdAddedDate(Date adAddedDate) {
		this.creationDate = adAddedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNrOfFlatMates() {
		return nrOfFlatMates;
	}

	public void setNrOfFlatMates(String nrOfFlateMates) {
		this.nrOfFlatMates = nrOfFlateMates;

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String toString() {
		return title;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

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

	public MapAddress getAddressForMap() {
		MapAddress tmpMapAddress = new MapAddress();
		String addressForMAp = address.getStreet()+ " " +address.getStreetNumber() +" "+ address.getZipCode()+" "+ address.getCity() + " Switzerland";
		tmpMapAddress.setAddressAsString(addressForMAp);
		tmpMapAddress.setId(id);
		return tmpMapAddress;
	}		
}
