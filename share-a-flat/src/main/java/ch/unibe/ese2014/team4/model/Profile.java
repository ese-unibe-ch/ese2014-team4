package ch.unibe.ese2014.team4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//TODO: add more profile stuff.
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    
   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    
}
