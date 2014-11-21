package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

public interface UserService {

	public Profile getProfileByUsername(String username);
	public User getUserByUsername(String username);
	public User getUser(Long id);
	public boolean doesEmailAddressAlreadyExist(String email);
	public boolean doesUserAlreadyExists(String username);
}
