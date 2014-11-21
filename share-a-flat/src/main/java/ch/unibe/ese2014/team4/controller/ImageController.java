package ch.unibe.ese2014.team4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ch.unibe.ese2014.team4.controller.service.ImageService;
import ch.unibe.ese2014.team4.controller.service.AdService;
 /**
  * Controls all pages / commands concerning ads.
  */

@Controller
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	AdService adService;

	@ResponseBody
	@RequestMapping(value = "/imageController/profile/{id}", method = RequestMethod.GET)
    public byte[] provideProfileImage(@PathVariable("id") long profileImageID){
		return imageService.getProfileImage(profileImageID);

	
    }
	
	@ResponseBody
	@RequestMapping(value = "/imageController/ad/{adId}/{imageNr}", method = RequestMethod.GET)
    public byte[] provideAdImage(@PathVariable("imageNr") int imageNr, @PathVariable("adId") long adId){


		byte[] im = adService.getAd(adId).getBytePictureList().get(imageNr);

		return im;
    }

}