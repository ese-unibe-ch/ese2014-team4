package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.Profile;



public interface ProfileDao extends CrudRepository<Profile,Long> {


}
