package ch.unibe.ese2014.team4.controller.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ch.unibe.ese2014.team4.controller.exceptions.BookmarkException;
import ch.unibe.ese2014.team4.controller.pojos.AdForm;
import ch.unibe.ese2014.team4.controller.pojos.AdType;
import ch.unibe.ese2014.team4.controller.pojos.ProfileForm;
import ch.unibe.ese2014.team4.model.Ad;
import ch.unibe.ese2014.team4.model.Address;
import ch.unibe.ese2014.team4.model.Profile;
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

		Ad ad = new Ad();

		// ad.setPrice(adForm.getPrice());
		ad.setNetto(adForm.getNetto());
		ad.setCharges(adForm.getCharges());
		ad.setBrutto();
		ad.setNrOfRooms(adForm.getNrOfRooms());

		if (adForm.getAdType() == AdType.ROOM) {
			ad.setType(AdType.ROOM);
			ad.setNrOfFlatMates(adForm.getNrOfFlatMates());
			
			ad.setFlatmateList(getUserListFromUsernameList(adForm.getFlatmateList()));
//			ad.setNrOfRooms(0);			//isn't it still important to know how many rooms the apartment has even it's an ad to look for a Flatmante??

		} else {
			ad.setType(AdType.FLAT);
			ad.setNrOfRooms(adForm.getNrOfRooms());
			ad.setNrOfFlatMates(0);

		}

		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(owner);
		
		if(adForm.getAvailableDate().equals(""))
			ad.setAvailableDate("--");
		else
			ad.setAvailableDate(adForm.getAvailableDate());
		
		ad.setAdAddedDate(new Date());
		
		
		ArrayList<MultipartFile> fileList = adForm.getUploadedAdPictures();
		
		if (!fileList.isEmpty()) {
			if (fileList.get(0).getSize() != 0) {
				ad.setBytePictureList(imageService
						.getByteArrayFromMultipart(fileList));
			} else {
				ad.setBytePictureList(imageService.getDefaultImage());
			}
		}

		Address address = new Address();
		address.setCity(adForm.getCity());
		address.setZipCode(adForm.getZipCode());
		address.setStreet(adForm.getStreet());
		address.setStreetNumber(adForm.getStreetNumber());
		addressDao.save(address);
		
		if (adForm.getVisitDate() != null){
			List<Visit> visitList = new ArrayList<Visit>();
			for (int i = 0; i < adForm.getVisitDate().size();i++){
				if (adForm.getVisitDate().get(i)!=null){
					Visit visit = new Visit();
					visit.setDate( adForm.getVisitDate().get(i));
					visit.setStartTime( adForm.getStartTime().get(i));
					visit.setEndTime( adForm.getEndTime().get(i));
					visitDao.save(visit);
					visitList.add(visit);
					ad.setVisitList(visitList);
				}
	
			}
		}

		
		ad.setAddress(address);
		ad = adDao.save(ad); // save object to DB

		adForm.setId(ad.getId());

		return adForm;
	}
	
	@Transactional
	public void updateAdFrom(long adId, AdForm adForm, User user) throws Exception {
		Ad ad = getAd(adId);
		ad.setNetto(adForm.getNetto());
		ad.setCharges(adForm.getCharges());
		ad.setBrutto();
		ad.setNrOfRooms(adForm.getNrOfRooms());

		if (adForm.getAdType() == AdType.ROOM) {
			ad.setType(AdType.ROOM);
			ad.setNrOfFlatMates(adForm.getNrOfFlatMates());
			
			ad.setFlatmateList(getUserListFromUsernameList(adForm.getFlatmateList()));
//			ad.setNrOfRooms(0);			//isn't it still important to know how many rooms the apartment has even it's an ad to look for a Flatmate??

		} else {
			ad.setType(AdType.FLAT);
			ad.setNrOfRooms(adForm.getNrOfRooms());
			ad.setNrOfFlatMates(0);

		}

		ad.setDescription(adForm.getDescription());
		ad.setTitle(adForm.getTitle());
		ad.setSize(adForm.getSize());
		ad.setOwner(ad.getOwner());
		
		if(adForm.getAvailableDate().equals(""))
			ad.setAvailableDate("--");
		else
			ad.setAvailableDate(adForm.getAvailableDate());
		
		ad.setAdAddedDate(new Date());
		
		
		ArrayList<MultipartFile> fileList = adForm.getUploadedAdPictures();
		
		if (!fileList.isEmpty()) {
			if (fileList.get(0).getSize() != 0) {
				ad.setBytePictureList(imageService
						.getByteArrayFromMultipart(fileList));
			} else {
				ad.setBytePictureList(imageService.getDefaultImage());
			}
		}

		Address address = ad.getAddress();
		address.setCity(adForm.getCity());
		address.setZipCode(adForm.getZipCode());
		address.setStreet(adForm.getStreet());
		address.setStreetNumber(adForm.getStreetNumber());
		
		addressDao.save(address);
		
		if (adForm.getVisitDate() != null){
			List<Visit> visitList = new ArrayList<Visit>();
			for (int i = 0; i < adForm.getVisitDate().size();i++){
				if (adForm.getVisitDate().get(i)!=null){
					Visit visit = new Visit();
					visit.setDate( adForm.getVisitDate().get(i));
					visit.setStartTime( adForm.getStartTime().get(i));
					visit.setEndTime( adForm.getEndTime().get(i));
					
					visitDao.save(visit);
					
					visitList.add(visit);
					ad.setVisitList(visitList);
				}
	
			}
		}

		
		ad.setAddress(address);
		
		ad = adDao.save(ad); // save object to DB

		adForm.setId(ad.getId());
	}	

	private List<User> getUserListFromUsernameList(List<String> nameList){
		ArrayList<User> list = new ArrayList<User>();
		for (String username : nameList){
			list.add(userDao.findByUsername(username));
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

	// public List<Ad> getAdByPrice(int price) {
	// List<Ad> ads = adDao.findAllByPrice(price);
	// assert (ads.size() != 0);
	// return ads;
	// }

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

		if (orderBy.equals("availableDate")){
			ads = adDao.findAllByAddressCityIgnoreCaseOrderByAvailableDateDesc(city);
			return ads;	
		}
		if (orderBy.equals("price")){
			ads = adDao.findAllByAddressCityOrderByBruttoAsc(city);
			return ads;	
		}
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

	public ArrayList<Ad> getAdByZip(int zipCode, String orderBy) {
		ArrayList<Ad> ads = new ArrayList<Ad>();
		
		if (orderBy.equals("availableDate")){
			ads = adDao.findAllByAddressZipCodeOrderByAvailableDateDesc(zipCode);
			return ads;	
		}
		if (orderBy.equals("price")){
			ads = adDao.findAllByAddressZipCodeOrderByBruttoAsc(zipCode);
			return ads;	
		}
		ads = adDao.findAllByAddressZipCode(zipCode);
		return ads;
	}

	public ArrayList<Ad> getAllAds(String orderBy) {
		ArrayList<Ad> ads = new ArrayList<Ad>();		
		ads = adDao.findAll();
		
		
		
		return ads;
	}

	public void setAdDao(AdDao mockDao) {
		adDao = mockDao;
	}



	
	public List<Ad> getBookmarkList(User user){
		return null;
	}
	public void bookMarkAdforUser(long adId, User user) {
		List<Long> list = user.getBookmarks();
		if(!list.contains(adId)){
			list.add(adId);
			user.setBookmarks(list);
			userDao.save(user);
			}

		else{
			throw new BookmarkException("Already bookmarked!");
			
		}
		
		
	}
	
	public void unBookMarkAdForUser(long adId, User user){
		List<Long> list = user.getBookmarks();
		if(list.contains(adId)){

			list.remove(adId);
			
			user.setBookmarks(list);
			userDao.save(user);}
		else{
			throw new BookmarkException("Already bookmarked!");
			
		}	
	}


	public List<Ad> getBookmarkedAds(List<Long> bookmarks) {
		List<Ad> list = new ArrayList<Ad>();
		for(Long id : bookmarks){
			Ad ad = adDao.findById(id);
			list.add(ad);
		}
		return list;
	}

	public List<Ad> getAdsOfUserByUser(User user) {
		return adDao.findAllByOwner(user);
	}


	public List<Visit> getVisitList(long adId) {

		return adDao.findById(adId).getVisitList();
	}



	public void registerUserForVisit(Long visitId, User user) {
		Visit visit = visitDao.findById(visitId);
		visit.getVisitorList().add(user);
		visitDao.save(visit);

	}

	public void registerUserForVisit(String userName, Long visitId) {
		// TODO Auto-generated method stub
		
	}

	public void addUserToVisitorsList(Long visitId, User user) {
		// TODO Auto-generated method stub
		
	}

}
