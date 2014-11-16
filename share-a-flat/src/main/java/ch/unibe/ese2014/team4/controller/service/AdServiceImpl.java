package ch.unibe.ese2014.team4.controller.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidAdException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;
import ch.unibe.ese2014.team4.model.dao.AddressDao;

/**
 * save ads to and get ads from data base
 * @author team4
 *
 */
@Service
public class AdServiceImpl implements AdService {

	@Autowired
	AdDao adDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	ImageService imageService;

	/**
	 * creates an ad form and saves it to data base
	 */
	@Transactional
	public AdForm saveAdForm(AdForm adForm, User owner) throws Exception {

		Ad ad = new Ad();

		ad.setPrice(adForm.getPrice());
		ad.setNrOfRooms(adForm.getNrOfRooms());
		
		if(adForm.getAdType() == AdType.ROOM){
			ad.setNrOfFlatMate(adForm.getNrOfFlatMates());
			ad.setNrOfRooms(0);
		}
		else{
			ad.setNrOfRooms(adForm.getNrOfRooms());
			ad.setNrOfFlatMate(0);
			
		}
		
		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(owner);
		ad.setAvailableDate(adForm.getAvailableDate());
		ad.setAdAddedDate(new Date());
		ArrayList<MultipartFile> fileList =adForm.getUploadedAdPictures();

		
		if (fileList.get(0).getSize()!=0){
			ad.setBytePictureList(imageService.getByteArrayFromMultipart(fileList));
		}
		else{
			ad.setBytePictureList(imageService.getDefaultImage());
		}

		Address address = new Address();
		address.setCity(adForm.getCity());
		address.setZipCode(adForm.getZipCode());
		address.setStreet(adForm.getStreet());
		address.setStreetNumber(adForm.getStreetNumber());
		addressDao.save(address);

		ad.setAddress(address);
		ad = adDao.save(ad); // save object to DB

		adForm.setId(ad.getId());

		return adForm;
	}

	@Transactional
	public Ad getAd(Long id) {
		Ad ad = adDao.findById(id);
		return ad;
	}

	public ArrayList<Ad> getNewestAds() {
		ArrayList<Ad> tmp = adDao.findAll();
		int length = tmp.size();

		ArrayList<Ad> ads = new ArrayList<Ad>();
		if (length > 6) {
			for (int i = length - 1; i > length - 5; i--) {
				ads.add(tmp.get(i));
			}
			return ads;
		} else
			return tmp;
	}

	public List<Ad> getAdByPrice(int price) {
		List<Ad> ads = adDao.findAllByPrice(price);
		assert (ads.size() != 0);
		return ads;
	}

	public List<Ad> getAdByTitle(String title) {
		List<Ad> ads = adDao.findAllByTitle(title);
		assert (ads.size() != 0);
		return ads;
	}

	public ArrayList<Ad> getAdByCity(String city) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAllByAddressCityIgnoreCase(city);
		return ads;
	}

	
	public List<String> getImageList(long adId) {
		Ad ad = adDao.findById(adId);
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < ad.getBytePictureList().size(); i++) {
			list.add(new Integer(i).toString());
		}
		return list;
	}

	public ArrayList<Ad> getAdByZip(int zipCode) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAllByAddressZipCode(zipCode);
		return ads;
	}

	public ArrayList<Ad> getAllAds() {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAll();
		return ads;
	}
	public void setAdDao(AdDao mockDao) {
		adDao = mockDao;
	}


}
