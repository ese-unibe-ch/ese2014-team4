package ch.unibe.ese2014.team4.controller.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidAdException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.dao.AdDao;


@Service
public class NewAdServiceImpl implements NewAdService {

	@Autowired
	AdDao adDao;

	@Transactional
	public AdForm saveAdForm(AdForm adForm) throws InvalidAdException {

		Ad ad = new Ad();

		ad.setPrice(adForm.getPrice());
		ad.setPlace(adForm.getPlace());
		ad.setDescription(adForm.getDescription());

		Address address = new Address();
		address.setCity(adForm.getCity());
		address.setZipCode(adForm.getZipCode());
		address.setStreet(adForm.getStreet());
		address.setStreetNumber(adForm.getStreetNumber());
		ad.setAddress(address);
		ad = adDao.save(ad); // save object to DB

		adForm.setId(ad.getId());

		return adForm;
	}
	
	@Transactional
	public Ad getAd(Long id) {
		Ad ad = adDao.findOne(id);
		return ad;
	}

}
