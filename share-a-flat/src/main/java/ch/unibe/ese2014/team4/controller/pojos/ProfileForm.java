package ch.unibe.ese2014.team4.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import ch.unibe.ese2014.team4.model.User;



public class ProfileForm {
//TODO: add profile stuff.

    private Long id;
    
    private User owner;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
