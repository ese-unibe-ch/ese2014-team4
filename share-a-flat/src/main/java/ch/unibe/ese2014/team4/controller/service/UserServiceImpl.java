package ch.unibe.ese2014.team4.controller.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ImageService imageService;
	
	@Transactional
	public void updateUserFrom(ProfileForm profileForm, User user){
		System.out.println(profileForm.getPassword());
		if (profileForm.getPassword().length()!=0){
			user.setPassword(DigestUtils.shaHex(profileForm.getPassword()));
		}
		user.setPhoneNumber(profileForm.getPhoneNumber());
		user.setAge(profileForm.getAge());
		user.setSex(profileForm.getSex());
		user.setUserDescription(profileForm.getUserDescription());
		
		
		try {
			MultipartFile imageFile = profileForm.getUploadedProfileImage();
			if(imageFile.getSize()!=0){	
				user.setProfileImage(imageService.getByteArrayFromMultipart(imageFile));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userDao.save(user);
	}
	
	/**
	 * @exception InvalidUserException
	 */
	public User getUserByUsername(String username) {
		User user =  userDao.findByUsername(username);
		if (user==null) throw new InvalidUserException("user not found");
		return user;
	}
	
	public boolean doesEmailAddressAlreadyExist(String email) {
		// TODO Auto-generated method stub
		return !(userDao.findByEmail(email) == null);
	}
	public boolean doesUserAlreadyExists(String username) {
		return!(userDao.findByUsername(username) == null);
	}
	/**
	 * @exception InvalidUserException
	 */
	public User getUser(Long id) {
		User user = userDao.findOne(id);
		if (user == null) {
			throw new InvalidUserException("There is no such user...");
		}
		return user;
	}

	public boolean isBookmarked(User user, long adId) {
		
		return user.getBookmarks().contains(adId);
	}
	public boolean isPasswordCorrect(String oldPassword, User user) {
		
		return DigestUtils.shaHex(oldPassword).equals(user.getPassword());
	}

	public boolean isUserActivated(User user) {
		return user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
