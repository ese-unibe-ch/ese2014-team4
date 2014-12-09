package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.Visit;
import ch.unibe.ese2014.team4.model.dao.AdDao;
import ch.unibe.ese2014.team4.model.dao.AddressDao;
import ch.unibe.ese2014.team4.model.dao.UserDao;
import ch.unibe.ese2014.team4.model.dao.VisitDao;

/**
 * save ads to and get ads from data base
 * 
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

	@Autowired
	UserDao userDao;

	@Autowired
	VisitDao visitDao;

	/**
	 * creates an ad form and saves it to data base
	 */
	@Transactional
	public AdForm saveAdForm(AdForm adForm, User owner) throws Exception {
		Ad ad;
		Address address;
		ArrayList<MultipartFile> fileList = adForm.getUploadedAdPictures();

		//in this block, create- and modify-specific elements respectively.
		if (adForm.getId() == 0) {
			ad = new Ad();
			address = new Address();
			if (fileList.isEmpty()) {
				ad.setBytePictureList(imageService.getDefaultImage());
			} else {
				ad.setBytePictureList(imageService
						.getByteArrayFromMultipart(fileList));
			}
		} else {
			ad = adDao.findById(adForm.getId());
			address = ad.getAddress();


			for (MultipartFile mf : fileList) {
				ad.getBytePictureList().add(
						imageService.getByteArrayFromMultipart(mf));
			}
		}

		ad.setNetto(adForm.getNetto());
		ad.setCharges(adForm.getCharges());
		ad.setBrutto();
		ad.setNrOfRooms(adForm.getNrOfRooms());

		if (adForm.getAdType() == AdType.ROOM) {
			ad.setType(AdType.ROOM);
			ad.setNrOfFlatMates(adForm.getNrOfFlatMates());

			if(adForm.getFlatmateNames()!=null){
				List<User> userList = getUserListFromUsernameList(adForm.getFlatmateNames());
				ad.setFlatmateList(userList);
				List<String> userListWitoutAccount = getUserWithoutAccount(adForm.getFlatmateNames());
				ad.setFlatmateListWithoutAccount(userListWitoutAccount);
			}


			
		} else {
			ad.setType(AdType.FLAT);
			ad.setNrOfFlatMates(0);
		}

		ad.setNrOfRooms(adForm.getNrOfRooms());

		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(owner);

		ad.setAvailableDate(adForm.getAvailableDate());

		ad.setAdAddedDate(new Date());

		address.setCity(adForm.getCity());
		address.setZipCode(adForm.getZipCode());
		address.setStreet(adForm.getStreet());
		address.setStreetNumber(adForm.getStreetNumber());
		addressDao.save(address);

		ad.setAddress(address);
		ad = adDao.save(ad); // save object to DB

		if (adForm.getVisitDate() != null) {
			List<Visit> visitList = new ArrayList<Visit>();
			
			for (int i = 0; i < adForm.getVisitDate().size(); i++) {
				if (!adForm.getVisitDate().get(i).equals("")) {

					Visit visit = new Visit();
					visit.setDate(adForm.getVisitDate().get(i));
					visit.setStartTime(adForm.getStartTime().get(i));
					visit.setEndTime(adForm.getEndTime().get(i));
					visit.setAdId(ad.getId());
					visitDao.save(visit);
					visitList.add(visit);
				}
			}
			ad.setVisitList(visitList);
		}

		ad = adDao.save(ad);
		adForm.setId(ad.getId());

		return adForm;
	}
	/**
	 * flatmateList must not be null.
	 * @param flatmateList
	 * @return
	 */
	private List<String> getUserWithoutAccount(List<String> flatmateList) {
		ArrayList<String> list = new ArrayList<String>();
		
		for (String username : flatmateList) {
			User tempUser = userDao.findByUsername(username);

			if (tempUser == null) {
				list.add(username);
			}
		}
		return list;
	}
	/**
	 * flatmateList must not be null.
	 * @param nameList
	 * @return
	 */
	private List<User> getUserListFromUsernameList(List<String> nameList) {

		List<User> list = new ArrayList<User>();	
		for (String username : nameList) {
			User tempUser = userDao.findByUsername(username);

			if (tempUser != null) {
				list.add(tempUser);
			}
		}
		return list;
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

	public List<Ad> getAdByBrutto(int brutto) {
		List<Ad> ads = adDao.findAllByBrutto(brutto);
		assert (ads.size() != 0);
		return ads;
	}

	public List<Ad> getAdByTitle(String title) {
		List<Ad> ads = adDao.findAllByTitle(title);
		assert (ads.size() != 0);
		return ads;
	}

	public ArrayList<Ad> getAdByCity(String city, String orderBy) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAllByAddressCityIgnoreCase(city);
		Collections.reverse(ads);

		if (orderBy.equals("availableDate")) {
			Collections.sort(ads, Ad.availableDateSorter);
		}

		if (orderBy.equals("price")) {
			Collections.sort(ads, Ad.bruttoSorter);
		}
		return ads;
	}

	public ArrayList<Ad> getAdByZip(int zipCode, String orderBy) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAllByAddressZipCode(zipCode);
		Collections.reverse(ads);

		if (orderBy.equals("availableDate")) {
			Collections.sort(ads, Ad.availableDateSorter);
		}

		if (orderBy.equals("price")) {
			Collections.sort(ads, Ad.bruttoSorter);
		}

		return ads;
	}

	public ArrayList<Ad> getAllAds(String orderBy) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		ads = adDao.findAll();
		Collections.reverse(ads);

		if (orderBy.equals("availableDate")) {
			Collections.sort(ads, Ad.availableDateSorter);
		}

		if (orderBy.equals("price")) {
			Collections.sort(ads, Ad.bruttoSorter);
		}
		return ads;
	}

	public void setAdDao(AdDao mockDao) {
		adDao = mockDao;
	}

	public List<Ad> getBookmarkList(User user) {
		return null;
	}

	public void bookMarkAdforUser(long adId, User user) {
		List<Long> list = user.getBookmarks();
		if (!list.contains(adId)) {
			list.add(adId);
			user.setBookmarks(list);
			userDao.save(user);
		} else {
			list.remove(list.indexOf(adId));
			user.setBookmarks(list);
			userDao.save(user);
		}
	}

	public List<Ad> getBookmarkedAds(List<Long> bookmarks) {
		List<Ad> list = new ArrayList<Ad>();

		for (Long id : bookmarks) {
			Ad ad = adDao.findById(id);
			list.add(ad);
		}
		return list;
	}

	public List<Ad> getAdsOfUserByUser(User user) {
		return adDao.findAllByOwner(user);
	}

	public List<Visit> getVisitList(long adId) {
		return visitDao.findAllByAdId(adId);
	}

	public void registerUserForVisit(Long visitId, User user) {
		Visit visit = visitDao.findById(visitId);
		user.getVisitsRegistered().add(visit);
		userDao.save(user);
		visit.getVisitorList().add(user);
		visitDao.save(visit);
	}

	public AdForm getAdFormForExistingAd(long adId) {
		Ad ad = getAd(adId);
		AdForm adForm = new AdForm();
		adForm.setAdType(ad.getType());
		adForm.setAvailableDate(ad.getAvailableDate());
		adForm.setSize(ad.getSize());
		adForm.setCharges(ad.getCharges());
		adForm.setNetto(ad.getNetto());
		adForm.setCity(ad.getAddress().getCity());
		adForm.setZipCode(ad.getAddress().getZipCode());
		adForm.setStreetNumber(ad.getAddress().getStreetNumber());
		adForm.setStreet(ad.getAddress().getStreet());
		adForm.setId(adId);
		adForm.setTitle(ad.getTitle());
		adForm.setDescription(ad.getDescription());
		adForm.setNrOfFlatMates(ad.getNrOfFlatMates());
		adForm.setNrOfRooms(ad.getNrOfRooms());
		return adForm;
	}

	public void deleteAd(Long adId) {
		adDao.delete(adId);
	}

	public List<Visit> getVisitsUserRegistered(User user) {
		return user.getVisitsRegistered();
	}

}
