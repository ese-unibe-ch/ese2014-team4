package ch.unibe.ese2014.team4.controller.service;

import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

public interface ProfileService {
	public void updateProfileFrom(ProfileForm profileForm, User user);
}
