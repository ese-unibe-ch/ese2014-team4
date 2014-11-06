package ch.unibe.ese2014.team4.controller.pojos;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;




public class UploadForm {
	private ArrayList<MultipartFile> files;

	public ArrayList<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<MultipartFile> files) {
		this.files = files;
	}


}
