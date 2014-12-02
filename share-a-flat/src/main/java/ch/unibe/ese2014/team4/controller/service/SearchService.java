package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.List;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.SearchForm;
import ch.unibe.ese2014.team4.model.User;

public interface SearchService {
	
	public ArrayList<Ad> getAdList(SearchForm sf) ;
	public void setAdService(AdService as);
	public void saveSearchForm(SearchForm searchForm);
	public List<SearchForm> getMySavedSearchForms(User user);

}
