package ch.unibe.ese2014.team4.controller.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.ProfileDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ProfileDao profileDao;
	
	public byte[] getByteArrayFromMultipart(MultipartFile file) {
		byte[] fileByte=null;
		try {
			fileByte = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileByte;
	}

	public byte[] getProfileImage(long profileId) {
		// TODO Auto-generated method stub
		return  profileDao.findById(profileId).getProfileImage();
	}

}
