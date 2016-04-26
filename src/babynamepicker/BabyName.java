package babynamepicker;

import java.util.HashMap;

/**
 * 
 * @author victoriayi
 *
 */
public class BabyName {
	/**
	 * instance variables
	 */
	private String name;
	private String sex;
	private char initial;
	private HashMap<Integer, Integer> popularity;
	private int popTotal;
	private int rating1, rating2;
	
	/**
	 * constructor
	 * @param _name
	 * @param _sex
	 * @param _initial
	 */
	public BabyName(String _name, String _sex, char _initial) {
		name = _name;
		sex = _sex;
		initial = _initial;
		popularity = new HashMap<Integer, Integer>();
		popTotal = 0;
		rating1 = -1;
		rating2 = -1;
	}
	
	/**
	 * get name of baby
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get initial of baby
	 * @return initial
	 */
	public char getInitial() {
		return initial;
	}
	
	/**
	 * get sex of baby
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * add popularity of the name and its year to the popularity HashMap
	 * @param year
	 * @param pop
	 */
	public void addPop(int year, int pop) {
		popularity.put(year, pop);
	}
	
	/**
	 * sum up total popularity in the last n years
	 * @param n
	 */
	public void setPopTotal(int n) {
		for(int i = 2014; i > 2014 - n; i--) {
			popTotal += popularity.get(i);
		}
	}
	
	public void setRating(int user, int rating) {
		if(user == 1) {
			rating1 = rating;
			
		}
		else rating2 = rating;
	}
	
	public void setSortType() { //popularity
		
	}
	
	@Override
	public int compareTo(BabyName compare) {
		double comp = compare.getRating() - this.getRating();
        if(comp > 0) return 1;
        else if(comp < 0) return -1;
        else return 0;
	}
}
