package babynamepicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 * This class is the Controller. It sets up the GUI and handles all the controls (buttons, menu items, etc.)
 * @author gracelee
 *
 */
public class BabyNamePicker {
	
	private FilterFrame filterFrame;
	private RankingFrame rankingFrame;
	
	/** The Model is the object that does all the computations. It is
     * completely independent of the Controller and View objects. */
	private Model model;
	
	/** The View object displays what is happening in the Model. */
	private View view;
	
	
	/**
	 * Runs the Baby Name Picker program
	 * @param args Ignored
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BabyNamePicker b = new BabyNamePicker();
                b.init();
                b.display();
            }
        });
	}
	
	/**
	 * Sets up communication between the components
	 */
	private void init() {
		filterFrame = new FilterFrame();
		rankingFrame = new RankingFrame();
		
		model = new Model("names/", 1888);
		view = new View(model);
		model.addObserver(view);
		
		model.addFilterFrame(0);
		model.addFilterFrame(1);
		model.addRankingFrame(0);
		model.addRankingFrame(1);
	}
	
	/**
     * Displays the GUI.
     */
	private void display() {
//		model.getFilterFrames()[0].changeVisibility();
		attachListenersToComponents();
	}
	
	/**
     * Arranges the various components in the GUI.
     */
	private void layOutComponents() {
		
	}
	
	/**
     * Attaches listeners to the components, and schedules a Timer.
     */
    private void attachListenersToComponents() {
    	
    }
	

}
