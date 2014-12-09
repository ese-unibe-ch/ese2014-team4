package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.List;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.Visit;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public interface AdService {
	
	//AdDao
	public void setAdDao(AdDao mockDao);
	
	//AdForm
	public AdForm saveAdForm(AdForm adForm, User owner) throws InvalidUserException, Exception;
	public AdForm getAdFormForExistingAd(long adId);
	
	//Get ads
	public Ad getAd(Long id);
	public ArrayList<Ad> getNewestAds();
	public List<Ad> getAdByBrutto(int brutto);
	public List<Ad> getAdByTitle(String title);
	
	//Ordered ads
	public ArrayList<Ad> getAdByCity(String city, String orderBy);
	public ArrayList<Ad> getAdByZip(int zipCode, String orderBy);
	public ArrayList<Ad> getAllAds(String orderBy);
	
	//Bookmark
	public void bookMarkAdforUser(long adId, User user);
	public List<Ad> getBookmarkList(User user);
	public List<Ad> getBookmarkedAds(List<Long> bookmarks);
	public List<Ad> getAdsOfUserByUser(User user);

	//Visit
	public List<Visit> getVisitList(long adId);		
	public void registerUserForVisit(Long visitId, User user);
	public List<Visit> getVisitsUserRegistered(User user);

	
	public void deleteAd(Long adId);



}
