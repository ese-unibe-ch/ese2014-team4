package ch.unibe.ese2014.team4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.mapping.Map;

import ch.unibe.ese2014.team4.controller.pojos.AdType;

import java.util.Comparator;

@Entity
public class Ad {

	@Id
	@GeneratedValue
	private Long id;

	private Date creationDate = new Date();

	@ManyToOne
	// many Ads, one user
	@JoinColumn(name = "user_id")
	private User owner;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Address address;

	// Basic-Data
	private String title;
	private AdType type;
	private float nrOfRooms;
	private int size;
	private String availableDate;
	private String description;
	private int nrOfFlatMates;

	// Price
	private int netto;
	private int charges;
	private int brutto;

	// Pictures
	@Lob
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name = "LIST_INDEX")
	@CollectionTable(name = "adPictures", joinColumns = @JoinColumn(name = "ad_id"))
	private List<byte[]> bytePictureList = new ArrayList<byte[]>();

	// Flatmate-Names
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name = "LIST_INDEX")
	@CollectionTable(name = "flatmates", joinColumns = @JoinColumn(name = "ad_id"))
	@Column(name = "user_id", length = 50)
	private List<User> flatmateList = new ArrayList<User>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@IndexColumn(name = "LIST_INDEX")
	@CollectionTable(name = "flatmatesWithoutAccount", joinColumns = @JoinColumn(name = "ad_id"))
	@Column(name = "user_id", length = 50)
	private List<String> flatmateListWithoutAccount = new ArrayList<String>();
	
	// Visit-Dates
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Visit> visitList = new ArrayList<Visit>();

	/**
	 * 
	 * @return list of unvalidated usernames which will be the future roommates.
	 */
	public List<User> getFlatmateList() {
		return flatmateList;
	}

	public void setFlatmateList(List<User> flatmateList) {
		this.flatmateList = flatmateList;
	}

	public List<String> getFlatmateListWithoutAccount() {
		return flatmateListWithoutAccount;
	}

	public void setFlatmateListWithoutAccount(
			List<String> flatmateListWithoutAccount) {
		this.flatmateListWithoutAccount = flatmateListWithoutAccount;
	}

	public List<Visit> getVisitList() {
		return visitList;
	}

	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}

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

	public float getNrOfRooms() {
		return nrOfRooms;
	}

	public void setNrOfRooms(float nrOfRooms) {
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

	public int getNrOfFlatMates() {
		return nrOfFlatMates;
	}

	public void setNrOfFlatMates(int nrOfFlateMates) {
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

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
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
		this.brutto = netto + charges;
	}

	public static Comparator<Ad> bruttoSorter = new Comparator<Ad>() {
		public int compare(Ad ad1, Ad ad2) {
			int brutto1 = ad1.getBrutto();
			int brutto2 = ad2.getBrutto();

			return brutto1 - brutto2;
		}
	};

	public static Comparator<Ad> availableDateSorter = new Comparator<Ad>() {
		public int compare(Ad ad1, Ad ad2) {
			Date date1 = convertStringToDate(ad1.getAvailableDate());
			Date date2 = convertStringToDate(ad2.getAvailableDate());

			return date1.compareTo(date2);
		}
	};

	private static Date convertStringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;

		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((availableDate == null) ? 0 : availableDate.hashCode());
		result = prime * result + brutto;
		result = prime * result
				+ ((bytePictureList == null) ? 0 : bytePictureList.hashCode());
		result = prime * result + charges;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((flatmateList == null) ? 0 : flatmateList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + netto;
		result = prime * result + nrOfFlatMates;
		result = prime * result + Float.floatToIntBits(nrOfRooms);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + size;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((visitList == null) ? 0 : visitList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ad other = (Ad) obj;

		if (!id.equals(other.id))
			return false;
		else
			return true;
	}

}
