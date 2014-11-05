package ch.unibe.ese2014.team4.controller.pojos;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;




public class UploadForm {
	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}


}
