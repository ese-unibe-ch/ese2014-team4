package ch.unibe.ese2014.team4.controller.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese2014.team4.controller.exceptions.InvalidAdException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.dao.AdDao;

public class NewAdServiceImpl {

	@Autowired
	AdDao adDao;

	@Transactional
	public AdForm saveAdFrom(AdForm adForm) throws InvalidAdException {

		
		Ad ad = new Ad();
		
		ad.setPrice(adForm.getPrice());
		ad.setPlace(adForm.getPlace());
		ad.setDescription(adForm.getDescription());
		ad.setAddress(adForm.getAddress());
		ad = adDao.save(ad); // save object to DB

		adForm.setId(ad.getId());

		return adForm;

	}
}
