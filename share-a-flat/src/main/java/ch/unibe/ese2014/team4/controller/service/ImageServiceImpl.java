package ch.unibe.ese2014.team4.controller.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.model.dao.ProfileDao;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ProfileDao profileDao;
	
	@Autowired
	ApplicationContext appContext;
	
	public byte[] getByteArrayFromMultipart(MultipartFile file) throws Exception {
		byte[] fileByte = new byte[(int) file.getSize()];
			fileByte = file.getBytes();

		return fileByte;
	}
	
	public List<byte[]> getByteArrayFromMultipart(
			List<MultipartFile> files) throws Exception {
		List<byte[]> byteList = new ArrayList<byte[]>();
		for (MultipartFile mf : files){
			byteList.add(mf.getBytes());
		}
		return byteList;
	}

	
	public byte[] getProfileImage(long profileId) {
		return  profileDao.findById(profileId).getProfileImage();
	}

	public List<byte[]> getDefaultImage(){

		File file=null;
		try {
			file = appContext.getResource("classpath:img/defaultAdImage.png").getFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		byte[] byteImg=null;
		InputStream input=null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			byteImg= IOUtils.toByteArray(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<byte[]> list = new ArrayList<byte[]>();
		list.add(byteImg);
		return list;
	}



}
