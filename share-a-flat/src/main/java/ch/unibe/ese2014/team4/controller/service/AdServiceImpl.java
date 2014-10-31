package ch.unibe.ese2014.team4.controller.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidAdException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
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

	@Transactional
	public AdForm saveAdForm(AdForm adForm, User owner) throws InvalidAdException {

		Ad ad = new Ad();

		ad.setPrice(adForm.getPrice());
		ad.setNrOfRoomMates(adForm.getNrOfRoomMates());
		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setOwner(owner);
		ad.setAdAddedDate(new Date());
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

}
