package ch.unibe.ese2014.team4.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;

public interface AdDao extends CrudRepository<Ad,Long> {

	public User findByOwner(String owner);
	public Ad findById(Long id);
	public List<Ad> findAllByOwner(User user);
	public List<Ad> findAllByBrutto(int brutto);
	public List<Ad> findAllByTitle(String title);
	public Ad findByAddressId(Long addressId);
	public ArrayList<Ad> findAllByAddressCityIgnoreCase(String city);
	public ArrayList<Ad> findAllByAddressCity(String city);
	public ArrayList<Ad> findAll();
	public ArrayList<Ad> findAllByAddressZipCode(int zipCode);
	public long count();
	public ArrayList<Ad> findAllByAddressCityIgnoreCaseOrderByAvailableDateAsc(
			String city);
	public ArrayList<Ad> findAllByAddressCityOrderByBruttoAsc(
			String city);
	public ArrayList<Ad> findAllByAddressZipCodeOrderByAvailableDateDesc(
			int zipCode);
	public ArrayList<Ad> findAllByAddressZipCodeOrderByBruttoAsc(int zipCode);
	
}
