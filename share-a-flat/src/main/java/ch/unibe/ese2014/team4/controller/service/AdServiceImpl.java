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
	public AdForm saveAdForm(AdForm adForm, User owner, ArrayList<MultipartFile> fileList) throws InvalidAdException {


		//überflüssig
		String title = adForm.getTitle();
		String description = adForm.getDescription();
		int Price = adForm.getPrice();
		int nrOfRoomMates = adForm.getNrOfRoomMates();
		int size = adForm.getSize();
		
		String city = adForm.getCity();
		String street = adForm.getStreet();
		int streetNr = adForm.getStreetNumber();
		int zipCode = adForm.getZipCode();
		
		// check if necessary data entered
//		if (StringUtils.isEmpty(title)) {
//			throw new InvalidAdException("Please enter a Title."); // throw exception
//		}
//		
//		if (StringUtils.isEmpty(description)) {
//			throw new InvalidAdException("Please describe the object briefly."); // throw exception
//		}
//				
//		if (StringUtils.isEmpty(street)) {
//			throw new InvalidAdException("Street must not be empty"); // throw exception
//		}
//		
//		if (StringUtils.isEmpty(city)) {
//			throw new InvalidAdException("City must not be empty"); // throw exception
//		}

		
		Ad ad = new Ad();

		ad.setPrice(adForm.getPrice());
		ad.setNrOfRoomMates(adForm.getNrOfRoomMates());
		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(owner);
		ad.setAdAddedDate(new Date());
		ArrayList<byte[]> byteList = new ArrayList<byte[]>();
		
		try {
			byteList.add(fileList.get(0).getBytes());
			byteList.add(fileList.get(1).getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*todo: save: @ElementCollection
		Map<Key, Value> collection;
		
		conversion from MultipartFile to byte[] method
		//ad.setBytePictureList(byteList);
*/		
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

	public Collection<Ad> getNewestAds(int days) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ad> getAdByPrice(int price) {
		List<Ad> ads = adDao.findAllByPrice(price);
		assert (ads.size()!=0);
		return ads;
	}

	public List<Ad> getAdByTitle(String title) {
		List<Ad> ads = adDao.findAllByTitle(title);
		assert (ads.size()!=0);
		return ads;
	}

	public List<Ad> getAdByCity(String city) {
		List<Address> addresses = addressDao.findAllByCity(city);
		ArrayList<Ad> ads = new ArrayList<Ad>();
		for (Address address: addresses){
			ads.add(adDao.findByAddressId(address.getId()));
		}
		return ads;
	}

}
