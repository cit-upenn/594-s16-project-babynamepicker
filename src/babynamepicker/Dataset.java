package babynamepicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Dataset {
	/**
	 * instance variables
	 */
	private HashMap<String, BabyName> dataMap;
	private ArrayList<BabyName> dataList;
	private ArrayList<String> userList;
	private String gender;
	private boolean leastToMost;
	private char startsWith;
	private int popularYears;
	private int numSuggestions;
	
	/**
	 * constructor
	 */
	public Dataset() {
		dataMap = new HashMap<String, BabyName>();
		dataList = new ArrayList<BabyName>();
		userList = new ArrayList<String>();
		gender = null;
		leastToMost = false;
		startsWith = '0';
		popularYears = 0;
		numSuggestions = 0;
	}
	
	
	/**
	 * get baby name by the name string
	 * @param name
	 * @return the BabyName object
	 */
	public BabyName getBabyName(String name) {
		return dataMap.get(name);
	}
	
	
	/**
	 * @return the dataList
	 */
	public ArrayList<BabyName> getDataList() {
		return dataList;
	}


	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<BabyName> dataList) {
		this.dataList = dataList;
	}


	/**
	 * Add new name to the data HashMap
	 * @param name
	 * @param sex
	 * @param initial
	 * @param year
	 * @param pop, popularity of that name (frequency) in that year 
	 */
	public void addName(String name, String sex, char initial, int year, int pop) {
		//add new BabyName object if the name does not already exist in the map
		if(!dataMap.containsKey(name)) {
			dataMap.put(name, new BabyName(name, sex, initial));
		}
		//add year and popularity to the BabyName's popularity HashMap
		dataMap.get(name).addPop(year, pop);
	}
	
	
	/**
	 * After parsing all baby names from files, make the Final List
	 * (copy all baby names in HashMap into an ArrayList)
	 * Since the keySet of a HashMap cannot be sorted,
	 * an ArrayList version of the data is needed for various sorting purposes
	 */
	public void finalList() {
		for(String i : dataMap.keySet()) {
			for(int j = 1880; j < 2015; j++) {
				if(!dataMap.get(i).containsYear(j)) dataMap.get(i).addPop(j, 0);
			}
			dataMap.get(i).setPopTotal(50);
			dataList.add(dataMap.get(i));
		}
		Collections.sort(dataList, new nameComparator());
//		for(BabyName i : dataList) {
//			System.out.println(i.getName() + " " + i.getSex() + i.getPopTotal());
//		}
//		System.out.println(dataList.size());
	}
	
	 public class nameComparator implements Comparator<BabyName>{

			public int compare(BabyName b1, BabyName b2) {
				// TODO Auto-generated method stub
				String baby1 = b1.getName();
				String baby2 = b2.getName();
				
				return baby1.compareTo(baby2);
			}
	 
	}
	 
	 public void filterList() {
		 if (!userList.isEmpty()) {
			 userList.clear();
		 }
		 
		 if (gender == "male") {
			 for (BabyName b : dataList) {
				 if (b.getSex().equals("M")) {
					userList.add(b.getName()); 
				 } 
			 }
		 } else if (gender == "female") {
			 for (BabyName b: dataList) {
				 if (b.getSex().equals("F")) {
					 userList.add(b.getName());
				 }
			 }
		 } else if (gender == "both") {
			 for (BabyName b : dataList) {
				 userList.add(b.getName());
			 }
		 }
		 
		 if (leastToMost == false) {
			 //Comparator class 
		 } else if (leastToMost == true) {
			//Comparator class 
		 }
		 
		 if (startsWith != '0') {
			 for (String s : userList) {
				 if (s.charAt(0) != startsWith) {
					 userList.remove(s);
				 }
			 }
		 }
		 
		 //popularYears
		 
		 
		 //numSuggestions
	 }


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the leastToMost
	 */
	public boolean isLeastToMost() {
		return leastToMost;
	}


	/**
	 * @param leastToMost the leastToMost to set
	 */
	public void setLeastToMost(boolean leastToMost) {
		this.leastToMost = leastToMost;
	}


	/**
	 * @return the startsWith
	 */
	public char getStartsWith() {
		return startsWith;
	}


	/**
	 * @param startsWith the startsWith to set
	 */
	public void setStartsWith(char startsWith) {
		this.startsWith = startsWith;
	}


	/**
	 * @return the popularYears
	 */
	public int getPopularYears() {
		return popularYears;
	}


	/**
	 * @param popularYears the popularYears to set
	 */
	public void setPopularYears(int popularYears) {
		this.popularYears = popularYears;
	}


	/**
	 * @return the numSuggestions
	 */
	public int getNumSuggestions() {
		return numSuggestions;
	}


	/**
	 * @param numSuggestions the numSuggestions to set
	 */
	public void setNumSuggestions(int numSuggestions) {
		this.numSuggestions = numSuggestions;
	}


	/**
	 * @return the userList
	 */
	public ArrayList<String> getUserList() {
		return userList;
	}


	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}
}
