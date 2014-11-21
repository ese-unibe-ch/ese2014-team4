package ch.unibe.ese2014.team4.controller.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	byte[] getByteArrayFromMultipart(MultipartFile file) throws Exception;
	List<byte[]> getByteArrayFromMultipart(List<MultipartFile> files) throws Exception;
	byte[] getProfileImage(long profileImageID);
	List<byte[]> getDefaultImage();

}
