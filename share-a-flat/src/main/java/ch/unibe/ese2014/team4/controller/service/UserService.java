package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

public interface UserService {

	Profile getMyProfile();
	User getUserByUsername(String username);

}
