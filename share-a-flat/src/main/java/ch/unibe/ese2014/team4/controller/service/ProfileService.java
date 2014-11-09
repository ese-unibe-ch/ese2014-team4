package ch.unibe.ese2014.team4.controller.service;

import java.security.Principal;

import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.model.Profile;

public interface ProfileService {
	public Profile getMyProfile(Principal principal) throws ProfileException;
	public void updateProfileFrom(ProfileForm profileForm, Profile profile);
}
