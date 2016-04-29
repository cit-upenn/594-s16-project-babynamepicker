package babynamepicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.JPanel;
//import java.util.PriorityQueue;


public class Model extends Observable {
<<<<<<< HEAD
	private FilterFrame[] filterFrames;
	private RankingFrame[] rankingFrames;
	private String frameType;
	private int user;
	
	private FileReader fr;
	private Dataset d;
	private ArrayList<String> userList;
	
	public Model(String path, int year) {
		fr = new FileReader("names/", 1888);
		d = fr.parseData();
		userList = new ArrayList<String>();
		
		filterFrames = new FilterFrame[2];
		filterFrames[0] = new FilterFrame();
		filterFrames[1] = new FilterFrame();
		
		rankingFrames = new RankingFrame[2];
		rankingFrames[0] = new RankingFrame();
		rankingFrames[1] = new RankingFrame();
		
		frameType = "filter";
		user = 0;
	}
	
	public void addFilterFrame(int userID) {
		filterFrames[userID] = new FilterFrame();
	}
	
	public void addRankingFrame(int userID) {
		rankingFrames[userID] = new RankingFrame();
	}
	
	public FilterFrame[] getFilterFrames() {
		return filterFrames;
	}
	
	public FilterFrame getFilterFrame (int user) {
		return filterFrames[user];
	}
	
	
	public RankingFrame[] getRankingFrames() {
		return rankingFrames;
	}
	
	public RankingFrame getRankingFrame(int user) {
		return rankingFrames[user];
	}
	
	public String getFrameType() {
		return frameType;
	}
	
	public int getUser() {
		return user;
	}
	
	public void setDisplayFrame(String frameType, int user) {
		this.frameType = frameType;
		this.user = user;
		setChanged();
		notifyObservers();
	}
	
=======
//	private FilterFrame[] filterFrames;
//	private RankingFrame[] rankingFrames;
//	private String frameType;
//	private int user;
	
	private JPanel[] allPanels;
	private int currentDisplayPanel;
	
	private FileReader fr;
	private Dataset d;
	private ArrayList<String> userList;
	
	public Model() {
//		fr = new FileReader("names/", 1888);
//		d = fr.parseData();
//		userList = new ArrayList<String>();
		
//		allPanels = new JPanel[5];
		allPanels = new JPanel[2];
		System.out.println("Make allPanels into array of JPanels.");
		initializePanels();
		System.out.println("Initailized all Panels.");
		currentDisplayPanel = 0;
	}
	
	public void initializePanels() {
		allPanels[0] = new FilterFrame();
		allPanels[1] = new RankingFrame();
//		allPanels[2] = new RankingFrame();
//		allPanels[3] = new RankingFrame();
//		allPanels[4] = new RankingFrame(); //Should be Final Frame
	}
	
	public JPanel[] getAllPanels() {
		return allPanels;
	}
	
	public JPanel getPanel(int index) {
		return allPanels[index];
	}
	
	public void setCurrentDisplay(int panel) {
		this.currentDisplayPanel = panel;
		setChanged();
		notifyObservers();
	}
	
	public int getCurrentDisplay() {
		return currentDisplayPanel;
	}
	
>>>>>>> f8ff3862136ec46f22cec9b40512513754cf5b62
	/**
	 * @return dataList
	 */
	public ArrayList<BabyName> getDataList() {
		return d.getDataList();
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
//		Collections.sort(list, BabyName.ratingComparator());
		BabyName[] array = list.toArray(new BabyName[0]);
		return array;
	}
	
	public void getNumSuggestedList(int numSuggested) {
		if (!userList.isEmpty()) {
			userList.clear();
		} //this won't work if we want to change the num displayed after other filters
		
		for (int i = 0; i < numSuggested; i++) {
			userList.add(getDataList().get(i).getName());
			setChanged();
			notifyObservers();
		}
	}
	
	
	
	
}
