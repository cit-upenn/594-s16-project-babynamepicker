package babynamepicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
//import java.util.PriorityQueue;


public class Model extends Observable {
	
	public void rateName() {
		
	}
	
	public void fillUserList(User u, BabyName[] array) {
		for(int i = 0; i < array.length; i++) {
			//by default, assume both user1 and user2 have rated this name
			//and set the average rating as the final rating
			array[i].setFinalRating(array[i].getAvgRating());
			u.add(array[i]);
		}
	}
	
	public BabyName[] combineLists(ArrayList<BabyName> user1, ArrayList<BabyName> user2) {
//		PriorityQueue<BabyName> q = new PriorityQueue<BabyName>();
		ArrayList<BabyName> list = new ArrayList<BabyName>();
		for(BabyName i : user1) {
			list.add(i);
		}
		for(BabyName i : user2) {
			if(!list.contains(i)) {
				i.setFinalRating(i.getRating(2));
				list.add(i);
			}
		}
		Collections.sort(list, BabyName.ratingComparator());
		BabyName[] array = list.toArray(new BabyName[0]);
		return array;
	}
}
