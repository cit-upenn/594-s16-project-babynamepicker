package babynamepicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.JPanel;
//import java.util.PriorityQueue;


public class Model extends Observable {
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
	
	
	
	
	
}
