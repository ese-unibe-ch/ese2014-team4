package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
