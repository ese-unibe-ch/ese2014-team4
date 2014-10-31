package ch.unibe.ese2014.team4.controller.service;

import java.security.Principal;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.exceptions.ProfileException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.ProfileDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;


@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ProfileDao profileDao;

	@Transactional
	public Profile getMyProfile(Principal principal) throws ProfileException{
		
		Profile profile = profileDao.findByOwner(userDao.findByUsername(principal.getName()));
		if (profile == null) throw new ProfileException("Profile not found");
		return profile;
	}
	
	@Transactional
	public void updateProfileFrom(ProfileForm profileForm, Profile profile){
		profile.setAge(profileForm.getAge());
		profile.setSex(profileForm.getSex());
		profile.setDescription(profileForm.getDescription());
		System.out.println(profileForm.getAge());
		System.out.println(profile.getOwner().getUsername());
		profileDao.save(profile);
	}
}
