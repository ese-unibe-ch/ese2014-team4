package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;



public interface ProfileDao extends CrudRepository<Profile,Long> {


	Profile findById(long id);

}
