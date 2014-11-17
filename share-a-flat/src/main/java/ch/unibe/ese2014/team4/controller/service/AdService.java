package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public interface AdService {

	public AdForm saveAdForm(AdForm adForm, User owner) throws InvalidUserException, Exception;
	public Ad getAd(Long id);
	public ArrayList<Ad> getNewestAds();
//	public List<Ad> getAdByPrice(int price);
	public List<Ad> getAdByBrutto(int brutto);
	public List<Ad> getAdByTitle(String title);
	public ArrayList<Ad> getAdByCity(String city);
	public void setAdDao(AdDao mockDao);
	public List<String> getImageList(long adId);
	public ArrayList<Ad> getAdByZip(int zipCode);
	public ArrayList<Ad> getAllAds();
}
