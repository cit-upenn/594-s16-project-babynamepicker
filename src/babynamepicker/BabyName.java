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
	private float finalrating;
	
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
	 * set sex of baby
	 * @param _sex
	 */
	public void setSex(String _sex) {
		sex = _sex;
	}
	
	/**
	 * add popularity of the name and its year to the popularity HashMap
	 * @param year
	 * @param pop
	 */
	public void addPop(int year, int pop) {
		popularity.put(year, pop);
	}
	
	public boolean containsYear(int year) {
		return popularity.containsKey(year);
	}
	
	/**
	 * sum up total popularity in the last n years
	 * @param n
	 */
	public void setPopTotal(int n) {
		popTotal = 0; //***
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
	
	public void setFinalRating(float _rating) {
		finalrating = _rating;
	}
	
	public float getFinalRating() {
		return finalrating;
	}
	
<<<<<<< HEAD
=======
//	/**
//	 * sort names by rating
//	 */
//	public static Comparator<BabyName> ratingComparator() {
//		return new Comparator<BabyName>() {
//			
//			@Override
//			public int compare(BabyName o1, BabyName o2) {
//				double comp = 0;
//				comp = o2.getFinalRating() - o1.getFinalRating();
//				comp = o2.getPopTotal() - o1.getPopTotal();
//				
//		        if(comp > 0) return 1;
//		        else if(comp < 0) return -1;
//		        else return 0;
//			}	
//		};
//	}
//	
//	/**
//	 * sort names by popularity
//	 */
//	public static Comparator<BabyName> popComparator() {
//		return new Comparator<BabyName>() {
//			
//			@Override
//			public int compare(BabyName o1, BabyName o2) {
//				double comp = 0;
//				comp = o2.getPopTotal() - o1.getPopTotal();
//				
//		        if(comp > 0) return 1;
//		        else if(comp < 0) return -1;
//		        else return 0;
//			}	
//		};
//	}
//	
>>>>>>> f8ff3862136ec46f22cec9b40512513754cf5b62
	
	/**
	 * To check if two items are equal by ID
	 */
	 @Override
	 public boolean equals (Object object) {
	     boolean result = false;
	     if (object == null || object.getClass() != getClass()) {
	         result = false;
	     } else {
	         BabyName compare = (BabyName) object;
	         if (this.name.equals(compare.getName())) {
	             result = true;
	         }
	     }
	     return result;
	 }
	 
	 /**
	  * Hashcode to accompany the overriding above
	  */
	 @Override
	 public int hashCode() {
		 return this.getName().hashCode();
	 }
	 
	
}
