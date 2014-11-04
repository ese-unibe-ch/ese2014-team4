package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.User;

public interface UserDao extends CrudRepository<User,Long> {

	User findByUsername(String username);

	User findByEmail(String email);

}
