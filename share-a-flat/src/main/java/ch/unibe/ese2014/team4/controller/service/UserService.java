package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.model.User;

public interface UserService {

	public void updateUserFrom(ProfileForm profileForm, User user);
	public User getUserByUsername(String username);
	public User getUser(Long id);
	public boolean doesEmailAddressAlreadyExist(String email);
	public boolean doesUserAlreadyExists(String username);

	public boolean isBookmarked(User user, long adId);
	public boolean isPasswordCorrect(String oldPassword, User user);
	public boolean isUserActivated(User user);
}
