/**
 * This class represents the JFrame that displays the parent's filtered list
 * and allows the parent to rank each name on the displayed list.
 */
package babynamepicker;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RankingFrame extends JPanel {

	private JFrame frame;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JList namesList;
	private JScrollPane listScroller;
	private DefaultListModel listMode;
	private JTextArea currentName;
	private JTextArea ratingLegend;
	private JRadioButton rate1;
	private JRadioButton rate2;
	private JRadioButton rate3;
	private JRadioButton rate4;
	private JRadioButton rate5;
	private ButtonGroup ratingGroup;
	
	
	public RankingFrame() {
//		frame = new JFrame("Let's Rank Your List!");
//		frame.setLayout(new GridBagLayout()); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridBagLayout());
		
		leftPanel = new JPanel(new GridBagLayout());
		rightPanel = new JPanel(new BorderLayout());
		
		currentName = new JTextArea("Rate This Name!");
		ratingLegend = new JTextArea("1 - Hate, 5 - Love");
		leftPanel.add(currentName);
		this.add(leftPanel);
//		frame.add(leftPanel);
		
//		frame.pack();
//		frame.setSize(700, 700);
//		frame.setVisible(false);
		this.setSize(700, 700);	
		this.setVisible(false);
	}
	
	public void changeVisibility(boolean toVisible) {
		if (toVisible == true) {
			frame.setVisible(true);
		} else if (toVisible == false) {
			frame.setVisible(false);
		}
	}

}
