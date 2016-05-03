package babynamepicker;


import java.util.HashMap;


/**
 * Defines the BabyName object and its attributes.
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
	private int popTotal; //total number of occurences of this name in the last n years given
	private int rating1, rating2; //rating from user1 and user2, respectively
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
	 * Concatenates the name of the baby with its final rating 
	 */
	public void getRankedName() {
		name = name.concat(" (" + Float.toString(finalrating) + ")");
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
	
	/**
	* check if popularity value has been assigned for the given year
	* @param year
	* @return popularity.containsKey(year)
	*/
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
	
	/**
	* get total popularity
	* @return popTotal
	*/
	public int getPopTotal() {
		return popTotal;
	}
	
	/**
	* set rating1 or rating2
	* @param user-- if 1 set rating1, else(if 2) set rating2
	* @param rating
	*/
	public void setRating(int user, int rating) {
		if(user == 1) {
			rating1 = rating;
		}
		else rating2 = rating;
	}
	
	/**
	 * get rating1 or rating2
	 * @param user
	 * @return the ratiing value
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
		return (float) (rating1 + rating2) / 2;
	}
	
	/**
	* set the final rating of this name
	* if both users rated this name, finalRating would be the average;
	* if not, the rating from just one user
	* @param _rating
	*/
	public void setFinalRating(float _rating) {
		finalrating = _rating;
	}
	
	/**
	* get the final rating of this name
	* @return finalrating
	*/
	public float getFinalRating() {
		return finalrating;
	}
	

	
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
