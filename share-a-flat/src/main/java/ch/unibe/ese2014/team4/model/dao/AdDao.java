package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.User;

public interface AdDao extends CrudRepository<Ad,Long> {

	User findByUsername(String username);
}
