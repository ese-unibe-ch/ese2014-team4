package ch.unibe.ese2014.team4.controller.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ZipCityServiceImpl implements ZipCityService {

	
	private final String SWISS_ZIP_FILE = "src/main/resources/files/plzSwiss.csv";
	private List<ZipCity> zipCityArray = new ArrayList<ZipCity>();
	
	public ZipCityServiceImpl() {
		parseFile(SWISS_ZIP_FILE);
	}

	private void parseFile(String zipFile) {
		
		String[] tmpArray = new String[2];
		String tmpString = "";
		BufferedReader br = null;
		String cvsSplitBy = ",";
		ZipCity tmpZipCity;

		try {
			br = new BufferedReader(new FileReader(zipFile));

			while ((tmpString = br.readLine()) != null) {
				tmpZipCity = new ZipCity();
			//	tmpString = br.readLine();
				tmpArray = tmpString.split(cvsSplitBy);
				tmpZipCity.setZip(tmpArray[0].trim());
				tmpZipCity.setCity(tmpArray[1]);
				zipCityArray.add(tmpZipCity);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see ch.unibe.ese2014.team4.controller.service.ZipCityService#getZipCityAsArrayList()
	 */
	public List<ZipCity> getZipCityAsList() {
		return zipCityArray;
	}

	
	
	public class ZipCity {	

		private String zip;
		private String city;

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		@Override
		public String toString() {
			return zip + " " + city;
		}
	}

}
