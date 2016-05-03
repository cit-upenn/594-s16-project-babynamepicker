/**
 * This class represents the Model of the Baby Name Picker program.
 * It is an Observable, which means it notifies Observers that something 
 * in the model has changed, in particular the panel that is to be displayed on the 
 * main window frame, and Observers should take appropriate actions.
 */
package babynamepicker;

import java.util.Observable;

import javax.swing.JPanel;

public class Model extends Observable {

	/**
	 * Instance Variables
	 */
	private Dataset dataset;
	private FilterFrame[] filterFramePanels;
	private RankingFrame[] rankingFramePanels;
	private StartFrame startFrame;
	private FinalFrame finalFrame;
	private int currentDisplayPanel;
	
	/**
	 * Constructor for this class
	 * @param inputData dataset of baby names
	 */
	public Model(Dataset inputData) {
		dataset = inputData;
		filterFramePanels = new FilterFrame[2];
		rankingFramePanels = new RankingFrame[2];
		
		initializeFilterPanels();
		initializeRankingPanels();
		initializeStartPanel();
		initializeFinalPanel();
		
		currentDisplayPanel = 0;
	}
	
	/**
	 * Initializes the two Filter Panels of this program
	 */
	public void initializeFilterPanels() {
		filterFramePanels[0] = new FilterFrame(dataset);
		filterFramePanels[1] = new FilterFrame(dataset);
	}
	
	/**
	 * Initializes the two Ranking Panels of this program
	 */
	public void initializeRankingPanels() {
		rankingFramePanels[0] = new RankingFrame();
		rankingFramePanels[1] = new RankingFrame();
	}
	
	/**
	 * Initializes the Start Panel of this program
	 */
	public void initializeStartPanel() {
		startFrame = new StartFrame();
	}
	
	/**
	 * Initializes the Final Panel of this program
	 */
	public void initializeFinalPanel() {
		finalFrame = new FinalFrame();
	}
	
	/**
	 * Get the specified Ranking Panel
	 * @param panel value of the ranking panel we want to return
	 * @return specified ranking panel
	 */
	public RankingFrame getRankingPanel(int panel) {
		return rankingFramePanels[panel];
	}
	
	/**
	 * Get the Final Panel
	 * @return the Final Panel
	 */
	public FinalFrame getFinalFrame() {
		return finalFrame;
	}
	
	/**
	 * Get the specified panel
	 * @param panel value of the specified panel
	 * @return specified panel
	 */
	public JPanel getPanel(int panel) {
		if (panel == 0){ //0 - Start Panel
			return startFrame;
		} else if (panel == 1) { //1 - Filter Panel 1
			return filterFramePanels[0];
		} else if (panel == 2) { // 2 = Ranking Panel 1
			return rankingFramePanels[0];
		} else if (panel == 3) { // 3 - Filter Panel 2
			return  filterFramePanels[1];
		} else if (panel == 4) { //4 - Ranking Panel 2
			return rankingFramePanels[1];
		} else if (panel == 5) { //5 - Final Panel
			return finalFrame;
		}
		return null;
	}
	
	/**
	 * Sets the value of the current displayed Panel
	 * Notifies Observers that model has changed
	 * @param updated
	 */
	public void setCurrent(int updated) {
		currentDisplayPanel = updated;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get the value of the current displayed Value
	 * @return
	 */
	public int getCurrent() {
		return currentDisplayPanel;
	}
	
	/** 
	 * Get the dataset of this model
	 * @return dataset of this model
	 */
	public Dataset getDataset() {
		return dataset;
	}
	
}