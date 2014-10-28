package ch.unibe.ese2014.team4.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Ad {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    private String place;
    private String address;
    private int price;
    private String description;
    
    
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
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


}
