package babynamepicker;
/**
 * This class represents the JFrame that displays the parent's filtered list
 * and allows the parent to rank each name on the displayed list.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class RankingFrame extends JPanel {

	/**
	 * Instance Variables
	 */
	private JList namesList;
	private JScrollPane listScroller;
	private DefaultListModel listModel;
	private JTextArea currentName;
	private JLabel ratingLegend1;
	private JLabel ratingLegend2;
	private JRadioButton rate1;
	private JRadioButton rate2;
	private JRadioButton rate3;
	private JRadioButton rate4;
	private JRadioButton rate5;
	private ButtonGroup ratingGroup;
	private JPanel buttonPanel;
	private JPanel rightPanel;
	private JPanel legendPanel;
	private JButton nextName;
	private String nextNameText;
	private GridBagConstraints c;
	private Dataset dataset;
	private ArrayList<BabyName> workingList;
	private int listIndex; 
	private int userID;
	
	
	/**
	 * Constructor of this class
	 */
	@SuppressWarnings("unchecked")
	public RankingFrame() {
		
		workingList = new ArrayList<BabyName>();
		listIndex = 0;
		userID = 0;
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		//Set up list to display on GUI
		listModel = new DefaultListModel();
		
		namesList = new JList(listModel);
		namesList.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		namesList.setCellRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof String) {
					c.setBackground(Color.LIGHT_GRAY);
				}
				return c;
			}
		});
		namesList.setBackground(Color.LIGHT_GRAY);
		namesList.setSelectionMode(JList.VERTICAL);
		namesList.setVisibleRowCount(10);
		listScroller = new JScrollPane(namesList);
		listScroller.setPreferredSize(new Dimension(150, 400));
		
		//Set up text areas
		nextNameText = "";
		currentName = new JTextArea(nextNameText);
		currentName.setFont(new Font("Chalkboard", Font.PLAIN, 22));
		ratingLegend1 = new JLabel("1 - Hate It, 2 - Dislike It, 3 - Meh", SwingConstants.CENTER);
		ratingLegend2 = new JLabel("4 - Like It, 5 - Love It!", SwingConstants.CENTER);
		ratingLegend1.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		ratingLegend2.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		
		//Set up rating buttons
		rate1 = new JRadioButton("1");
		rate1.setVerticalTextPosition(JRadioButton.BOTTOM);
		rate1.setHorizontalTextPosition(JRadioButton.CENTER);
		rate1.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		rate2 = new JRadioButton("2");
		rate2.setVerticalTextPosition(JRadioButton.BOTTOM);
		rate2.setHorizontalTextPosition(JRadioButton.CENTER);
		rate2.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		rate3 = new JRadioButton("3");
		rate3.setVerticalTextPosition(JRadioButton.BOTTOM);
		rate3.setHorizontalTextPosition(JRadioButton.CENTER);
		rate3.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		rate4 = new JRadioButton("4");
		rate4.setVerticalTextPosition(JRadioButton.BOTTOM);
		rate4.setHorizontalTextPosition(JRadioButton.CENTER);
		rate4.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		rate5 = new JRadioButton("5");
		rate5.setVerticalTextPosition(JRadioButton.BOTTOM);
		rate5.setHorizontalTextPosition(JRadioButton.CENTER);
		rate5.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		
		ratingGroup = new ButtonGroup();
		ratingGroup.add(rate1);
		ratingGroup.add(rate2);
		ratingGroup.add(rate3);
		ratingGroup.add(rate4);
		ratingGroup.add(rate5);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(rate1);
		buttonPanel.add(rate2);
		buttonPanel.add(rate3);
		buttonPanel.add(rate4);
		buttonPanel.add(rate5);
		
		//Set up Next Button
		nextName = new JButton("Next");
		nextName.setFont(new Font("Chalkboard", Font.PLAIN, 12));
		nextName.setEnabled(false);
		
		//Add components to right panel
		rightPanel = new JPanel(new BorderLayout());
		rightPanel.add(buttonPanel, BorderLayout.CENTER);
		rightPanel.add(currentName, BorderLayout.NORTH);
		rightPanel.add(nextName, BorderLayout.SOUTH);
		
		//Add legend to Legend Panel
		legendPanel = new JPanel();
		legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.PAGE_AXIS));
		legendPanel.setBackground(Color.WHITE);
		legendPanel.add(ratingLegend1);
		legendPanel.add(ratingLegend2);
		
		//Add panels and list to this panel
		c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		this.add(listScroller, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		this.add(rightPanel, c);
		
		c.gridy = 3;
		this.add(legendPanel, c);
		
		attachListenersToComponents();
		
		
		this.setSize(700, 700);	
		this.setVisible(false);
	}
	
	/**
	 * Set the list to rank & display on this panel
	 * @param inputList list to rank on this panel
	 * @param user user who list belongs to
	 */
	public void setWorkingList(ArrayList<BabyName> inputList, int user) {
		workingList = inputList;
		
//		if (workingList == null) {
//			System.out.println("Working List wasn't set.");
//			return;
//		}
		
		for (BabyName b : workingList) {
			listModel.addElement(b.getName());
		}
		
		currentName.setText((String) listModel.getElementAt(0));
		namesList.setSelectedIndex(listIndex);
		userID = user;
	}
	
	/**
	 * Get the list when all of its objects have been ranked
	 * @return finalized ranked list
	 */
	public ArrayList<BabyName> getFinalizedList() {
		boolean isFinalized = true;
		
		for (BabyName b : workingList) {
			if (b.getRating(userID) == -1) {
				isFinalized = false;
			}
		}
		if (isFinalized = true) {
			return workingList;
		}
		return null;
	}
	
	/**
	 * Attaches listeners to components
	 */
	private void attachListenersToComponents() {
		// Next Name button tells panel to display the next name to rank on the list
		// If entire list has been ranked, pressing Next Button will disable buttons on this panel
		// and enable Click to Continue button on Controller
		nextName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listIndex++;
				if (listIndex == workingList.size()) {
					ratingGroup.clearSelection();
					rate1.setEnabled(false);
					rate2.setEnabled(false);
					rate3.setEnabled(false);
					rate4.setEnabled(false);
					rate5.setEnabled(false);
					nextName.setEnabled(false);
					Controller.clickToContinue.setEnabled(true);
				} else {
					namesList.setSelectedIndex(listIndex);
					currentName.setText(workingList.get(listIndex).getName());
				}	
				ratingGroup.clearSelection();
				nextName.setEnabled(false);
			}
			
		});
		// Rate 1 button adds rating of 1 to current name for this user and
		// enables next button
		rate1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentText = currentName.getText();
				for (BabyName b : workingList) {
					if (b.getName().equals(currentText)) {
						b.setRating(userID, 1);
						System.out.println(b.getName() + b.getRating(userID));
					}
				}
				nextName.setEnabled(true);
			}
			
		});
		// Rate 2 button adds rating of 2 to current name for this user and
		// enables next button
		rate2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentText = currentName.getText();
				for (BabyName b : workingList) {
					if (b.getName().equals(currentText)) {
						b.setRating(userID, 2);
						System.out.println(b.getName() + b.getRating(userID));
					}
				}
				nextName.setEnabled(true);
			}
			
		});
		// Rate 3 button adds rating of 3 to current name for this user and
		// enables next button
		rate3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentText = currentName.getText();
				for (BabyName b : workingList) {
					if (b.getName().equals(currentText)) {
						b.setRating(userID, 3);
						System.out.println(b.getName() + b.getRating(userID));
					}
				}
				nextName.setEnabled(true);
			}
			
		});
		// Rate 4 button adds rating of 4 to current name for this user and
		// enables next button
		rate4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentText = currentName.getText();
				for (BabyName b : workingList) {
					if (b.getName().equals(currentText)) {
						b.setRating(userID, 4);
						System.out.println(b.getName() + b.getRating(userID));
					}
				}
				nextName.setEnabled(true);
			}
			
		});
		// Rate 5 button adds rating of 5 to current name for this user and
		// enables next button
		rate5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String currentText = currentName.getText();
				for (BabyName b : workingList) {
					if (b.getName().equals(currentText)) {
						b.setRating(userID, 5);
						System.out.println(b.getName() + b.getRating(userID));
					}
				}
				nextName.setEnabled(true);
			}
			
		});
	}
	

}
