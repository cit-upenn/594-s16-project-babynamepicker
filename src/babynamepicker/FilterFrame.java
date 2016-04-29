/**
 * This class represents the JFrame that displays all possible baby names
 * and options to filter the list according to selected crteria.
 */
package babynamepicker;

/**
 * This class represents the JFrame that displays all possible baby names
 * and options to filter the list according to selected crteria.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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

	private JFrame frame;
	
	private JPanel contentPanel;
	
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
	private ArrayList<String> secondTestNames = new ArrayList<String>();
	private FileReader fr;
	
	public FilterFrame () {
//		frame = new JFrame("Welcome to Baby Name Picker!");
//		frame.setLayout(new GridBagLayout()); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridBagLayout());
//		contentPanel = new JPanel(new GridBagLayout());
		
		leftPanel = new JPanel(new GridBagLayout());
		rightPanel = new JPanel(new BorderLayout());
		
		genderText = new JTextArea("Gender of the Baby: ");
		popularText = new JTextArea("Sort by Commonality: ");
		startsWithText = new JTextArea("Starts with letter: ");
		popularWithinText = new JTextArea("Popular Within the Last _ Years:");
		numSuggestionsText = new JTextArea("Number of Suggestions: ");
		
		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		unisexButton = new JRadioButton("Both");
		maleOrFemaleGroup = new ButtonGroup();
		maleOrFemaleGroup.add(maleButton);
		maleOrFemaleGroup.add(femaleButton);
		maleOrFemaleGroup.add(unisexButton);
		leastPopularButton = new JRadioButton("Least to Most");
		mostPopularButton = new JRadioButton("Most to Least");
		alphaButton = new JButton("Return to Alphabetical Ordering");
		alphaButton.setEnabled(false);
		popularityGroup = new ButtonGroup();
		popularityGroup.add(leastPopularButton);
		popularityGroup.add(mostPopularButton);
		letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		startWithMenu = new JComboBox<String>(letters);
		popularYears = new String[] {"10", "20", "30", "40", "50", "All Time"};
		popularWithinMenu = new JComboBox<String>(popularYears);
		readyToRankButton = new JButton("I'm ready to rank!");
		numSuggestions = new String[] {"10", "20", "30","40", "50"};
		numSuggestionsMenu = new JComboBox<String>(numSuggestions);
		
		fr = new FileReader("names/", 1879);
		dataset = fr.parseData();
		listModel = new DefaultListModel();
		for (int i = 0; i < dataset.getDataList().size(); i++) {
			listModel.addElement(dataset.getDataList().get(i).getName());
		}
		namesList = new JList(listModel);
//		namesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		namesList.setLayoutOrientation(JList.VERTICAL);
		namesList.setVisibleRowCount(10);
		listScroller = new JScrollPane(namesList);
		listScroller.setPreferredSize(new Dimension(150, 400));
		
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
//		frame.add(leftPanel, c);
//		contentPanel.add(leftPanel, c);
		this.add(leftPanel, c);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.9;
		c.anchor = GridBagConstraints.CENTER;
//		frame.add(rightPanel, c);
		rightPanel.add(listScroller, BorderLayout.CENTER);
//		contentPanel.add(rightPanel, c);
		this.add(rightPanel, c);
		
		attachListenersToComponents();
		
//		frame.pack();
//		frame.setSize(700, 700);
//		frame.setVisible(true);
//		contentPanel.setSize(700, 700);
//		contentPanel.setVisible(false);
		this.setSize(700, 700);
		this.setVisible(false);
		
	}
	
	public void changeVisibility(boolean toVisible) {
		if (toVisible == true) {
			contentPanel.setVisible(true);
		} else if (toVisible == false) {
			contentPanel.setVisible(false);
		}
	}
	
	public JButton getReadyToRankButton() {
		return readyToRankButton;
	}
	
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
    	//The Unisex button tells the Model to list both male and female names 
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
				listModel.removeAllElements();
				JComboBox c = (JComboBox) e.getSource();
				String selectedItem = (String) c.getSelectedItem();
				char letter = selectedItem.charAt(0);
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
//    	Ready to Rank button tells Model to show next Pane.
    	readyToRankButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("Button pressed");
//				frame.setVisible(false);
				
			}
    		
    	});
    
	}
	
//	public static void main(String[] args) {
//		FilterFrame f = new FilterFrame();
//	}
	

}

