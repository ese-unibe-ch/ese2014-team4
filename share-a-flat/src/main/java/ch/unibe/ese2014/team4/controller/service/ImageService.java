package ch.unibe.ese2014.team4.controller.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;

public interface ImageService {

	byte[] getByteArrayFromMultipart(MultipartFile file);

	byte[] getProfileImage(long profileImageID);

}
