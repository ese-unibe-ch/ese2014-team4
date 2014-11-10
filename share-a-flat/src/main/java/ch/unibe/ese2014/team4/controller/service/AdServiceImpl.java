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
import ch.unibe.ese2014.team4.controller.pojos.SearchForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;
import ch.unibe.ese2014.team4.model.dao.AddressDao;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	AdDao adDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	ImageService imageService;

	@Transactional
	public AdForm saveAdForm(AdForm adForm, User owner) throws Exception {

		Ad ad = new Ad();

		ad.setPrice(adForm.getPrice());
		ad.setNrOfRooms(adForm.getNrOfRooms());
		ad.setNrOfRoomMates(adForm.getNrOfRoomMates());
		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(owner);
		ad.setAdAddedDate(new Date());

		ad.setBytePictureList(imageService.getByteArrayFromMultipart(adForm
				.getUploadedAdPictures()));

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

		for (int i = length - 1; i > length - 5; i--) {
			ads.add(tmp.get(i));
		}

		return ads;
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

	public List<Ad> getAdByCity(String city) {
		List<Ad> ads = adDao.findAllByAddressCity(city);

		return ads;
	}

	public void setAdDao(AdDao mockDao) {
		adDao = mockDao;
	}

}
