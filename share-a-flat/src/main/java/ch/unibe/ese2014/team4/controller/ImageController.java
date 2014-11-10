package ch.unibe.ese2014.team4.controller;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidUserException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.SignupForm;
import ch.unibe.ese2014.team4.controller.service.ImageService;
import ch.unibe.ese2014.team4.controller.service.LoginService;
import ch.unibe.ese2014.team4.controller.service.NewAccountService;
import ch.unibe.ese2014.team4.controller.service.AdService;
import ch.unibe.ese2014.team4.controller.service.UserService;
import ch.unibe.ese2014.team4.model.Ad;
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
		byte[] im = imageService.getProfileImage(profileImageID);

		return im;
    }
	
	@ResponseBody
	@RequestMapping(value = "/imageController/ad/{adId}/{imageNr}", method = RequestMethod.GET)
    public byte[] provideAdImage(@PathVariable("imageNr") int imageNr, @PathVariable("adId") long adId){


		byte[] im = adService.getAd(adId).getBytePictureList().get(imageNr);

		return im;
    }

}