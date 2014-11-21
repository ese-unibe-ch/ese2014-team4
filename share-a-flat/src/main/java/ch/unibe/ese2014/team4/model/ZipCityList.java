package ch.unibe.ese2014.team4.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZipCityList {

	private ArrayList<ZipCity> zipCityArray = new ArrayList<ZipCity>();
	private String csvFile;

	public ZipCityList(String filePath) {
		csvFile = filePath;
		parseFile(csvFile);
	}

	private void parseFile(String csvFile) {
		String[] tmpArray = new String[2];
		String tmpString = "";
		BufferedReader br = null;
		String cvsSplitBy = ",";
		ZipCity tmpZipCity;

		try {
			br = new BufferedReader(new FileReader(csvFile));

			while ((tmpString = br.readLine()) != null) {
				tmpZipCity = new ZipCity();
			//	tmpString = br.readLine();
				tmpArray = tmpString.split(cvsSplitBy);
				tmpZipCity.setZip(tmpArray[0]);
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

	public ArrayList<ZipCity> getZipCityAsArrayList() {
		return zipCityArray;
	}

	public String getCityFromZip(String zipCode) {
		for (ZipCity zipCity : zipCityArray) {
			if (zipCity.equals(zipCode))
				return zipCity.getCity();
		}
		return null;
	}
}
