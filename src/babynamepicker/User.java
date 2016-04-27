package babynamepicker;

import java.util.ArrayList;

/**
 * 
 * @author victoriayi
 *
 */
public class User {
	/**
	 * instance variables
	 */
	private ArrayList<BabyName> namelist;
	private int id;
	
	/**
	 * constructor
	 * @param _id
	 */
	public User(int _id) {
		id = _id;
		namelist = new ArrayList<BabyName>();
	}
	
	public void add(BabyName name) {
		namelist.add(name);
	}
	
	
}
