package ch.unibe.ese2014.team4.model.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;


public interface AddressDao  extends CrudRepository<Address,Long>{
	public List<Address> findAllByCity(String city);
}
 