package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.model.User;

public interface NewAccountService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

	public User getUser(Long id);

}
