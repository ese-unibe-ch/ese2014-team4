package ch.unibe.ese2014.team4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Address {
	  	@Id
	    @GeneratedValue
	    private Long id;

	  	private String street;
		private int streetNumber;
	    private String city;
	    private int zipCode;
	    
	    
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
			this.city = city;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}
	    
	    public String toString(){
	    	StringBuilder builder = new StringBuilder();
	    	builder.append(street + " " + streetNumber);
	    	builder.append("\n"+ zipCode + " " + city);
	    	return builder.toString();
	    }
	  
}
