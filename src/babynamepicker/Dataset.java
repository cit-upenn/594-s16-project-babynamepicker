package babynamepicker;

import java.util.ArrayList;
import java.util.HashMap;

public class Dataset {
	/**
	 * instance variables
	 */
	private HashMap<String, BabyName> dataMap;
	private ArrayList<BabyName> dataList;
	
	/**
	 * constructor
	 */
	public Dataset() {
		dataMap = new HashMap<String, BabyName>();
		dataList = new ArrayList<BabyName>();
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
//			dataMap.get(i).setPopTotal(50);
			dataList.add(dataMap.get(i));
		}
		for(BabyName i : dataList) {
			System.out.println(i.getName() + " " + i.getSex() + i.getPopTotal());
		}
		System.out.println(dataList.size());
	}
}
