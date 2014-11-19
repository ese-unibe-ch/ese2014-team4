package ch.unibe.ese2014.team4.controller.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ch.unibe.ese2014.team4.model.Zip;

public class PlzParseService {

	private ArrayList<Zip> plzArray = new ArrayList<Zip>();

	public ArrayList<Zip> getPlzArray() {
		getData();
		return plzArray;
	}

	private void getData() {
		String[] tmpArray = new String[2];
		String tmpString = "";
		String csvFile = "src/main/webapp/files/plz.csv";
		BufferedReader br = null;
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((br.readLine()) != null) {
				Zip tmpZip = new Zip();
				tmpString = br.readLine();
				 tmpArray = tmpString.split(cvsSplitBy);
				tmpZip.setZip(tmpArray[0]);
				tmpZip.setCity( tmpArray[1]);
				plzArray.add(tmpZip);
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
}
