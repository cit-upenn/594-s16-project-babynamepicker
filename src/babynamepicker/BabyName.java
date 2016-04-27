package babynamepicker;

import java.util.HashMap;

/**
 * 
 * @author victoriayi
 *
 */
public class BabyName implements Comparable<BabyName> {
	/**
	 * instance variables
	 */
	private String name;
	private String sex;
	private char initial;
	private HashMap<Integer, Integer> popularity;
	private int popTotal;
	private int rating1, rating2;
	private String sortType;
	
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
	
	public int getPopTotal() {
		return popTotal;
	}
	
	public void setRating(int user, int rating) {
		if(user == 1) {
			rating1 = rating;
		}
		else rating2 = rating;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int getRating(int user) {
		if(user == 1) return rating1;
		else return rating2;
	}
	
	/**
	 * calculate and get the average rating from the ratings of user1 and user2
	 * @return average rating
	 */
	public float getAvgRating() {
		return (rating1 + rating2) / 2;
	}
	
	/**
	 * set the type that the baby names will get sorted by; either by rating or popularity
	 * @param sort
	 */
	public void setSortType(String sort) { //popularity
		sortType = sort; 
	}
	
	/**
	 * to sort names by rating or popularity
	 */
	@Override
	public int compareTo(BabyName compare) {
		double comp = 0;
		
		if(sortType.equals("rating")) comp = compare.getAvgRating() - this.getAvgRating();
		else if(sortType.equals("pop")) comp = compare.getPopTotal() - this.getPopTotal();
		
        if(comp > 0) return 1;
        else if(comp < 0) return -1;
        else return 0;
	}
}
