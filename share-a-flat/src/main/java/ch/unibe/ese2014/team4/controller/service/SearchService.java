package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;

import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.model.Ad;

public interface SearchService {
	
	public ArrayList<Ad> getAdList(SearchForm sf);
	public void setAdService(AdService as);

}
