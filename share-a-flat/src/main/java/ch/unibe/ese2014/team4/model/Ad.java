package ch.unibe.ese2014.team4.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ch.unibe.ese2014.team4.controller.pojos.AdType;



@Entity
public class Ad {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne		//many Ads, one user
    @JoinColumn(name="user_id")
    private User owner;
    
	@OneToOne(cascade = CascadeType.REMOVE)
    private Address address;  
	


	private AdType type;
	
//	@OneToMany(targetEntity=User.class)
//	private List<User> roomMates;
	private int nrOfRooms;
	
	@Lob
	@Column(name="bytePictureList",  columnDefinition="mediumblob")
	private ArrayList<byte[]> bytePictureList;
	private String title;
	private int size;
    private int price;
//    private Date fromDate;
//    private Date toDate;	
	private String description;
    private int nrOfRoomMates;
    private Date adAddedDate;
	
    public AdType getType() {
		return type;
	}

	public void setType(AdType type) {
		this.type = type;
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
	public Date getAdAddedDate() {
		return adAddedDate;
	}

	public void setAdAddedDate(Date adAddedDate) {
		this.adAddedDate = adAddedDate;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public int getNrOfRoomMates() {
		return nrOfRoomMates;
	}

	public void setNrOfRoomMates(int nrOfRoomMates) {
		this.nrOfRoomMates = nrOfRoomMates;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
    public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String toString(){
		return title;
	}

	 public int getSize() {
			return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<byte[]> getBytePictureList() {
		return bytePictureList;
	}

	public void setBytePictureList(ArrayList<byte[]> bytePictureList) {
		this.bytePictureList = bytePictureList;
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
}
