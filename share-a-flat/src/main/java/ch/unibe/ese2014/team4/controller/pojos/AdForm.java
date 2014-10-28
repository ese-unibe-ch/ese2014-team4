package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class AdForm {
//TODO: validate password = passwordRepeated

    private Long id;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a User Name")
    private String place;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
    private String address;
    
    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
    private int price;

    @NotNull
    @Pattern(regexp = "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Please enter a Password")
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
