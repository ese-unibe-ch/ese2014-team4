package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

public interface UserService {

	public Profile getProfileByUsername(String username) throws ProfileException;
	public User getUserByUsername(String username);
	public User getUser(Long id);
	public boolean doesEmailAddressAlreadyExist(String email);
	public boolean doesUserAlreadyExists(String username);

	public boolean isBookmarked(User user, long adId);
	public boolean isPasswordCorrect(String oldPassword, User user);
}
