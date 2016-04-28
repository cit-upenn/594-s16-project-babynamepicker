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
		 
	 }
}
