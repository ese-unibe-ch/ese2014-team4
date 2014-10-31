package ch.unibe.ese2014.team4.controller.service;

import java.util.Collection;
import java.util.List;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;

public interface AdService {

	public AdForm saveAdForm(AdForm adForm, User owner) throws InvalidUserException;
	public Ad getAd(Long id);
	public Collection<Ad> getNewestAds(int days);


}
