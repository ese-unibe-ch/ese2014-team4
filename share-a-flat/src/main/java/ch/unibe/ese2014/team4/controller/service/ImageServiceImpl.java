package ch.unibe.ese2014.team4.controller.service;

import java.io.ByteArrayInputStream;
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

import ch.unibe.ese2014.team4.model.Profile;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.ProfileDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;

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
	
//adapted from http://www.digitalsanctuary.com/tech-blog/java/how-to-resize-uploaded-images-using-java-better-way.html
//    /**
//     * The JAI.create action name for handling a stream.
//     */
//    private static final String JAI_STREAM_ACTION = "stream";
// 
//    /**
//     * The JAI.create action name for handling a resizing using a subsample averaging technique.
//     */
//    private static final String JAI_SUBSAMPLE_AVERAGE_ACTION = "SubsampleAverage";
// 
//    /**
//     * The JAI.create encoding format name for JPEG.
//     */
//    private static final String JAI_ENCODE_FORMAT_JPEG = "JPEG";
// 
//    /**
//     * The JAI.create action name for encoding image data.
//     */
//    private static final String JAI_ENCODE_ACTION = "encode";
// 
//    /**
//     * The http content type/mime-type for JPEG images.
//     */
//    private static final String JPEG_CONTENT_TYPE = "image/jpeg";
// 
// 
//    private int mMaxWidth = 800;
// 
//    private int mMaxWidthThumbnail = 150;
// 
//.....
// 
// 
// 
//    /**
//     * This method takes in an image as a byte array (currently supports GIF, JPG, PNG and
//     * possibly other formats) and
//     * resizes it to have a width no greater than the pMaxWidth parameter in pixels.
//     * It converts the image to a standard
//     * quality JPG and returns the byte array of that JPG image.
//     *
//     * @param inputImage
//     *                the image data.
//     * @param maxWidth
//     *                the max width in pixels, 0 means do not scale.
//     * @return the resized JPG image.
//     * @throws IOException
//     *                 if the image could not be manipulated correctly.
//     */
//    
//
//
//
//public byte[] resizeImageAsJPG(byte[] inputImage, int maxWidth) throws IOException {
//    InputStream imageInputStream = new ByteArrayInputStream(inputImage);
//    SeekableStream seekableImageStream = SeekableStream.wrapInputStream(imageInputStream, true);
//    RenderedOp originalImage = JAI.create(JAI_STREAM_ACTION, seekableImageStream);
//    ((OpImage) originalImage.getRendering()).setTileCache(null);
//    int origImageWidth = originalImage.getWidth();
//    // now resize the image
//    double scale = 1.0;
//    if (maxWidth > 0 && origImageWidth > maxWidth) {
//        scale = (double) maxWidth / originalImage.getWidth();
//    }
//    ParameterBlock paramBlock = new ParameterBlock();
//    paramBlock.addSource(originalImage); // The source image
//    paramBlock.add(scale); // The xScale
//    paramBlock.add(scale); // The yScale
//    paramBlock.add(0.0); // The x translation
//    paramBlock.add(0.0); // The y translation
// 
//    RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_RENDERING,
//        RenderingHints.VALUE_RENDER_QUALITY);
// 
//    RenderedOp resizedImage = JAI.create(JAI_SUBSAMPLE_AVERAGE_ACTION, paramBlock, qualityHints);
// 
//    // lastly, write the newly-resized image to an output stream, in a specific encoding
//    ByteArrayOutputStream encoderOutputStream = new ByteArrayOutputStream();
//    JAI.create(JAI_ENCODE_ACTION, resizedImage, encoderOutputStream, JAI_ENCODE_FORMAT_JPEG, null);
//    // Export to Byte Array
//    byte[] resizedImageByteArray = encoderOutputStream.toByteArray();
//    return resizedImageByteArray;
//    }
//	
	
	public byte[] getProfileImage(long profileId) {
		// TODO Auto-generated method stub
		return  profileDao.findById(profileId).getProfileImage();
	}

	public List<byte[]> getDefaultImage(){

		File file=null;
		try {
			file = appContext.getResource("classpath:defaultAdImage.png").getFile();
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
