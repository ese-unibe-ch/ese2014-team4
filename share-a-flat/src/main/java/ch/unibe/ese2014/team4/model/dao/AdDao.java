package ch.unibe.ese2014.team4.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;

public interface AdDao extends CrudRepository<Ad,Long> {

	public User findByOwner(String owner);
	public Ad findById(Long id);
	public List<Ad> findAllByPrice(int price);
	public List<Ad> findAllByTitle(String title);
	public Ad findByAddressId(Long addressId);
	
	
}
