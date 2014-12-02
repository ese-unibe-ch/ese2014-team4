package ch.unibe.ese2014.team4.controller.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
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
	
	@Autowired
	ImageService imageService;


	
	@Transactional
	public void updateProfileFrom(ProfileForm profileForm, User user){
		Profile profile = user.getProfile();
		profile.setUsername(profileForm.getUsername());
		profile.setEmail(profileForm.getEmail());
		profile.setPhoneNumber(profileForm.getPhoneNumber());
		profile.setAge(profileForm.getAge());
		profile.setSex(profileForm.getSex());
		profile.setUserDescription(profileForm.getUserDescription());
		user.setPassword(DigestUtils.shaHex(profileForm.getPassword()));
		
		try {
			MultipartFile imageFile = profileForm.getUploadedProfileImage();
			if(imageFile.getSize()!=0){	
				profile.setProfileImage(imageService.getByteArrayFromMultipart(imageFile));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profileDao.save(profile);
	}
}
