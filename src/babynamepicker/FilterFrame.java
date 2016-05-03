package babynamepicker;
/**
 * This class represents the JPanel that displays all possible baby names
 * and options to filter the list according to selected crteria.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observer;

import javax.swing.BorderFactory;
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

public class FilterFrame extends JPanel {

//	private JFrame frame;	
//	private JPanel contentPanel;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JTextArea genderText;
	private JRadioButton maleButton;
	private JRadioButton femaleButton; 
	private JRadioButton unisexButton;
	private ButtonGroup maleOrFemaleGroup;
	private JTextArea popularText;
	private JRadioButton leastPopularButton;
	private JRadioButton mostPopularButton;
	private JButton alphaButton;
	private ButtonGroup popularityGroup;
	private JTextArea startsWithText;
	private JComboBox<String> startWithMenu;
	private JTextArea popularWithinText;
	private JComboBox<String> popularWithinMenu;
	private String[] popularYears;
	private String[] letters;
	private JTextArea numSuggestionsText;
	private JComboBox<String> numSuggestionsMenu;
	private String[] numSuggestions;
	private JButton readyToRankButton;
	private JList namesList;
	private JScrollPane listScroller;
	private DefaultListModel listModel;
	private Dataset dataset;
	
	/**
	 * Constructor for class
	 * @param inputData baby name dataset
	 */
	public FilterFrame (Dataset inputData) {		
		dataset = inputData;
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		//Initialize panels 
		leftPanel = new JPanel(new GridBagLayout());
		leftPanel.setBackground(Color.WHITE);
		rightPanel = new JPanel(new BorderLayout());
		
		//Initialize texts
		genderText = new JTextArea("Gender of the Baby: ");
		genderText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		popularText = new JTextArea("Sort by Commonality: ");
		popularText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		startsWithText = new JTextArea("Starts with letter: ");
		startsWithText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		popularWithinText = new JTextArea("Popular Within the Last _ Years:");
		popularWithinText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		numSuggestionsText = new JTextArea("Number of Suggestions: ");
		numSuggestionsText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		
		//Initialize buttons & place in button groups
		maleButton = new JRadioButton("Male");
		maleButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		femaleButton = new JRadioButton("Female");
		femaleButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		unisexButton = new JRadioButton("Both");
		unisexButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		maleOrFemaleGroup = new ButtonGroup();
		maleOrFemaleGroup.add(maleButton);
		maleOrFemaleGroup.add(femaleButton);
		maleOrFemaleGroup.add(unisexButton);
		leastPopularButton = new JRadioButton("Least to Most");
		leastPopularButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		mostPopularButton = new JRadioButton("Most to Least");
		mostPopularButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		alphaButton = new JButton("Return to Alphabetical Ordering");
		alphaButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		alphaButton.setEnabled(false);
		popularityGroup = new ButtonGroup();
		popularityGroup.add(leastPopularButton);
		popularityGroup.add(mostPopularButton);
		
		//Initialize Menus
		letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z", "No Preference"};
		startWithMenu = new JComboBox<String>(letters);
		startWithMenu.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		popularYears = new String[] {"10", "20", "30", "40", "50", "All Time"};
		popularWithinMenu = new JComboBox<String>(popularYears);
		popularWithinMenu.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		readyToRankButton = new JButton("Click to save list!");
		readyToRankButton.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		numSuggestions = new String[] {"10", "20", "30","40", "50"};
		numSuggestionsMenu = new JComboBox<String>(numSuggestions);
		numSuggestionsMenu.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		
		//Initialize & fill list to be displayed on the GUI
		listModel = new DefaultListModel();
		dataset.clearList();
		dataset.finalList();
		for (int i = 0; i < dataset.getDataList().size(); i++) {
			listModel.addElement(dataset.getDataList().get(i).getName());
		}
		
		
		namesList = new JList(listModel);
		namesList.setLayoutOrientation(JList.VERTICAL);
		namesList.setVisibleRowCount(10);
		namesList.setFont(new Font("Chalkboard", Font.PLAIN, 13));
		listScroller = new JScrollPane(namesList);
		listScroller.setPreferredSize(new Dimension(150, 400));
		
		//Place components according to defined GridBagLayout constraints
		GridBagConstraints c = new GridBagConstraints();
		int i = 1;
		c.weightx = 0.1;
		c.weighty = 0;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = i;
		leftPanel.add(genderText, c);
		i++;
		c.gridy = i;
		leftPanel.add(maleButton, c);
		c.gridx = 1;
		leftPanel.add(femaleButton, c);
		c.gridx = 2;
		leftPanel.add(unisexButton, c);
		c.gridx = 0;
		i++;
		c.gridy = i;
		leftPanel.add(popularText, c);
		i++;
		c.gridy = i;
		leftPanel.add(leastPopularButton, c);
		c.gridx = 1;
		leftPanel.add(mostPopularButton, c);
		i++;
		c.gridy = i;
		c.gridx = 0;
		leftPanel.add(startsWithText, c);
		i++;
		c.gridy = i;
		leftPanel.add(startWithMenu, c);
		i++;
		c.gridy = i;
		leftPanel.add(popularWithinText, c);
		i++;
		c.gridy = i;
		leftPanel.add(popularWithinMenu, c);
		i++;
		c.gridy = i;
		leftPanel.add(numSuggestionsText, c);
		i++;
		c.gridy = i;
		leftPanel.add(numSuggestionsMenu, c);
		i++;
		c.gridy = i;
		leftPanel.add(alphaButton, c);
		i++;
		c.gridy = i;
		leftPanel.add(readyToRankButton, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(leftPanel, c);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.9;
		c.anchor = GridBagConstraints.CENTER;
		rightPanel.add(listScroller, BorderLayout.CENTER);
		this.add(rightPanel, c);
		
		attachListenersToComponents();

		this.setSize(700, 700);
		this.setVisible(false);
		
	}
	
	/**
	 * Attaches listeners to all components of this planel
	 */
	private void attachListenersToComponents() {
		//The Male button tells the Model to list Male names only
    	maleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				dataset.setCurrentGender("M");
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
			}
    		
    	});
    	//The Female button tells the Model to list Female names only
    	femaleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				dataset.setCurrentGender("F");
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
				
			}
    		
    	});
    	//The Unisex button tells the Model to list both male and female names (unisex)
    	unisexButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				dataset.setCurrentGender("U");
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
			}
    		
    	});
    	//The Least Popular Button tells the Model to list names from least common to most common.
    	leastPopularButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				alphaButton.setEnabled(true);
				dataset.setCurrentSort("p");
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
			}
    		
    	});
    	//The Most Popular Button tells the Model to list names from most common to least common.
    	mostPopularButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				alphaButton.setEnabled(true);
				dataset.setCurrentSort("P");
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
				
			}
    		
    	});
    	//Selection in Starts With Menu tells the Model to list names starting with selected letter.
    	startWithMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				char letter = 0;
				listModel.removeAllElements();
				JComboBox c = (JComboBox) e.getSource();
				String selectedItem = (String) c.getSelectedItem();
				if (selectedItem.equals("No Preference")) {
					letter = '0';
				} else {
					letter = selectedItem.charAt(0);
				}
				alphaButton.setEnabled(true);
				dataset.setCurrentInitial(letter);
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
			}
    		
    	});
    	//Selection in Popular Within Menu tells the Model to list names that were popular within last "selected" years.
    	popularWithinMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				int numYears = 0;
				JComboBox c = (JComboBox) e.getSource();
				String selectedItem = (String) c.getSelectedItem();
				if (!selectedItem.equals("All Time")) {
					numYears = Integer.parseInt(selectedItem);
				}
				alphaButton.setEnabled(true);
				dataset.setCurrentNYears(numYears);
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
			}
    		
    	});
    	//Selection in Num Suggestions Menu tells the Model to list selected number of names.
    	numSuggestionsMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				JComboBox c = (JComboBox) e.getSource();
				String selectedItem = (String) c.getSelectedItem();
				int numSuggestions = Integer.parseInt(selectedItem);
				System.out.println("filter" + numSuggestions);
				dataset.setCurrentNumSuggest(numSuggestions);
				dataset.filterList();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
				
				alphaButton.setEnabled(true);
				
				
			}
    		
    	});
    	//Alpha button tells Panel to sort list alphabetically.
    	alphaButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.removeAllElements();
				System.out.println("List will be ordered alphabetically.");
				dataset.setCurrentSort("A");
				dataset.filterList();
				Collections.sort(dataset.getFilteredList());
				alphaButton.setEnabled(false);
				popularityGroup.clearSelection();
				for (int j = 0; j < dataset.getFilteredList().size(); j++) {
					listModel.addElement(dataset.getFilteredList().get(j));
				}
				
			}
    		
    	});
//    	Ready to Rank button tells Model to save this user's filtered list.
    	readyToRankButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dataset.clearList();
				dataset.finalList();
				dataset.resetFilters();
				readyToRankButton.setEnabled(false);
				
				//Set all other buttons disabled too
				maleButton.setEnabled(false);
				femaleButton.setEnabled(false);
				unisexButton.setEnabled(false);
				leastPopularButton.setEnabled(false);
				mostPopularButton.setEnabled(false);
				alphaButton.setEnabled(false);
				startWithMenu.setEnabled(false);
				popularWithinMenu.setEnabled(false);
				numSuggestionsMenu.setEnabled(false);
				
				//Enable Click to Continue button Controller to move onto next panel
				Controller.clickToContinue.setEnabled(true);
			}
    		
    	});    
	}	

}

