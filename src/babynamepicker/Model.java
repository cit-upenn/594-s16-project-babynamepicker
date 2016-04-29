package babynamepicker;

import java.util.Observable;

import javax.swing.JPanel;

public class Model extends Observable {

	private JPanel[] allPanels;
	private int currentDisplayPanel;
	
	public Model() {
		allPanels = new JPanel[2];
		initializePanels();
		
		currentDisplayPanel = 0;
	}
	
	public void initializePanels() {
		allPanels[0] = new FilterFrame();
		allPanels[1] = new RankingFrame();
	}
	
	public JPanel[] getAllPanels() {
		return allPanels;
	}
	
	public JPanel getPanel(int panel) {
		return allPanels[panel];
	}
	
	public void setCurrent(int updated) {
		currentDisplayPanel = updated;
		setChanged();
		notifyObservers();
	}
	
	public int getCurrent() {
		return currentDisplayPanel;
	}
}