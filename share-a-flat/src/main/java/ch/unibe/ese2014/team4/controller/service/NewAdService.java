package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;

public interface NewAdService {

	public AdForm saveAdForm(AdForm adForm) throws InvalidUserException;
	public Ad getAd(Long id);

}
