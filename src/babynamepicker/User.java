package babynamepicker;


import java.util.ArrayList;

/**
 * This class represents a User in the Baby Name Picker program.
 * It holds the user's filtered/ranked list of baby names.
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
	 * @param _id, 1 or 2
	 */
	public User(int _id) {
		id = _id;
		namelist = new ArrayList<BabyName>();
	}
	
	/**
	 * Add BabyName to user's list
	 * @param name BabyName to add to list
	 */
	public void add(BabyName name) {
		namelist.add(name);
	}
	
	/**
	 * Sets the user's list of BabyNames
	 * @param inputList list of BabyNames to set to the user's list
	 */
	public void setNameList(ArrayList<BabyName> inputList) {
		namelist = inputList;
	}
	
	/**
	 * Get the user's list of BabyNames
	 * @return user's list of BabyNames
	 */
	public ArrayList<BabyName> getNameList() {
		return namelist;
	}
	
	
}
