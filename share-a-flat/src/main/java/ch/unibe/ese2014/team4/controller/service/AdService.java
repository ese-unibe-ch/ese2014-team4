package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;

public interface AdService {

	public AdForm saveAdForm(AdForm adForm, User owner, ArrayList<MultipartFile> fileList) throws InvalidUserException;
	public Ad getAd(Long id);
	public Collection<Ad> getNewestAds(int days);
	public List<Ad> getAdByPrice(int price);
	public List<Ad> getAdByTitle(String title);
	public List<Ad> getAdByCity(String city);



}
