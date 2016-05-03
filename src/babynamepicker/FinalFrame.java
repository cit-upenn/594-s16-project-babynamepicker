/**
 * This class represents the final panel that displays the top
 * ranked names for both parents combined.
 */
package babynamepicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FinalFrame extends JPanel {

	/**
	 * Instance Variables
	 */
	private JPanel bottomPanel;
	private JTextArea suggestedText;
	private JTextArea topName;
	private JList parent1JList;
	private JList parent2JList;
	private JList combinedJList;
	private JScrollPane parent1Scroll;
	private JScrollPane parent2Scroll;
	private JScrollPane combinedScroll;
	private DefaultListModel parentListModel1;
	private DefaultListModel parentListModel2;
	private DefaultListModel combinedListModel;
	private ArrayList<BabyName> parent1List;
	private ArrayList<BabyName> parent2List;
	private ArrayList<BabyName> combinedList;
	
	/**
	 * Constructor of this class
	 */
	public FinalFrame() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		parent1List = new ArrayList<BabyName>();
		parent2List = new ArrayList<BabyName>();
		combinedList = new ArrayList<BabyName>();
		
		//Sets up lists to display on this panel
		parentListModel1 = new DefaultListModel();
		parent1JList = new JList(parentListModel1);
		parentListModel2 = new DefaultListModel();
		parent2JList = new JList(parentListModel2);
		combinedListModel = new DefaultListModel();
		combinedJList = new JList(combinedListModel);
		
		parent1JList.setSelectionMode(JList.VERTICAL);
		parent1JList.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		parent2JList.setSelectionMode(JList.VERTICAL);
		parent2JList.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		combinedJList.setSelectionMode(JList.VERTICAL);
		combinedJList.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		
		parent1Scroll = new JScrollPane(parent1JList);
		parent1Scroll.setPreferredSize(new Dimension(150, 400));
		parent2Scroll = new JScrollPane(parent2JList);
		parent2Scroll.setPreferredSize(new Dimension(150, 400));
		combinedScroll = new JScrollPane(combinedJList);
		combinedScroll.setPreferredSize(new Dimension(150, 400));
		
		//Sets up text areas for bottom of this panel
		bottomPanel = new JPanel(new BorderLayout());
		suggestedText  = new JTextArea("The final suggested name of your child is:");
		suggestedText.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		topName = new JTextArea("DISPLAY NAME HERE");
		topName.setFont(new Font("Chalkboard", Font.PLAIN, 15));
		bottomPanel.add(suggestedText, BorderLayout.NORTH);
		bottomPanel.add(topName, BorderLayout.CENTER);
		
		//Add componenets to this panel
		this.add(parent1Scroll, BorderLayout.WEST);
		this.add(parent2Scroll, BorderLayout.EAST);
		this.add(combinedScroll, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		this.setSize(700, 700);
		this.setVisible(false);
		
	}
	
	/**
	 * Construct the list of BabyNames both users picked and ranked
	 * Also remove simiar BabyNames from each user's respective list
	 * @return
	 */
	public ArrayList<BabyName> calculateCombinedList() {
		for (BabyName a : parent1List) {
			for (BabyName b : parent2List) {
				if (a.getName().equals(b.getName())) {
					a.setRating(2, b.getRating(2));
					System.out.println(a.getName());
					System.out.println("User1 Rating: " + a.getRating(1));
					System.out.println("User2 Rating: " + a.getRating(2));
					a.setFinalRating(a.getAvgRating());
					System.out.println("Average Rating:" + a.getFinalRating());
					System.out.println("***************");
					combinedList.add(a);
				}
			}
		}
		for (BabyName c : combinedList) {
			c.getRankedName();
		}
		parent1List.removeAll(combinedList);
		parent2List.removeAll(combinedList);
		combinedList.sort(new finalRatingComparator());
		return combinedList;
	}
	
	/**
	 * Comparator that sorts list of BabyNames by final ratings in descending order
	 * @author gracelee
	 *
	 */
	public class finalRatingComparator implements Comparator<BabyName> {

		@Override
		public int compare(BabyName o1, BabyName o2) {
			// TODO Auto-generated method stub
			double finalComp = 0;
			finalComp = o2.getFinalRating() - o1.getFinalRating();
			if (finalComp > 0) {
				return 1;
			} else if (finalComp < 0) {
				return -1;
			} 
			return 0;
		}
		
	}
	
	/**
	 * Comparator that sorts list of BabyNames by user 1's ratings in descending order
	 * @author gracelee
	 *
	 */
	public class user1RatingComparator implements Comparator<BabyName> {

		@Override
		public int compare(BabyName o1, BabyName o2) {
			// TODO Auto-generated method stub
			double finalComp = o2.getRating(1) - o1.getRating(1);
			if (finalComp > 0) {
				return 1;
			} else if (finalComp < 0) {
				return -1;
			} 
			return 0;
		}
		
	}
	
	/**
	 * Comparator that sorts the list of BabyNames by user 2's ratings in descending order
	 * @author gracelee
	 *
	 */
	public class user2RatingComparator implements Comparator<BabyName> {

		@Override
		public int compare(BabyName o1, BabyName o2) {
			// TODO Auto-generated method stub
			double finalComp = o2.getRating(2) - o1.getRating(2);
			if (finalComp > 0) {
				return 1;
			} else if (finalComp < 0) {
				return -1;
			} 
			return 0;
		}
		
	}
	
	/**
	 * Sets user 1's ranked list, user 2's ranked list, or calls to construct combined ranked list depending on input
	 * @param listType type of list to set the parameter to
	 * @param inputList list that is to be assigned to either user1, user2 or user to calculate combined list
	 */
	public void setRankedList(int listType, ArrayList<BabyName> inputList) {
		if (listType == 1) { //parent1
			parent1List = inputList;
		} else if (listType == 2) { //parent2
			parent2List = inputList;
		} else if (listType == 3) { //combined
			calculateCombinedList();
		}
	}
	
	/**
	 * Displays all three lists on the GUI in sorted order
	 * Names and their respective rankings are displayed
	 */
	public void displayFinalLists() {
		if (parent1List != null) {
			parent1List.sort(new user1RatingComparator());
			for (BabyName b : parent1List) {
				String rating = Integer.toString(b.getRating(1));
				String nameWithRating = b.getName().concat(" (" + rating + ")");
				parentListModel1.addElement(nameWithRating);
			}	
		}
		if (parent2List != null ) {
			parent2List.sort(new user2RatingComparator());
			for (BabyName b : parent2List) {
				String rating = Integer.toString(b.getRating(2));
				String nameWithRating = b.getName().concat(" (" + rating + ")");
				parentListModel2.addElement(nameWithRating);
			}	
		}
		if (combinedList != null) {
			for (BabyName b : combinedList) {
				combinedListModel.addElement(b.getName());
				System.out.println(b.getName());
				System.out.println(b.getFinalRating());
			}
		}
		if (combinedList.size() != 0) {
			setSuggestedName(combinedList.get(0).getName().substring(0, combinedList.get(0).getName().indexOf(' ')));
		} else {
			setSuggestedName(null);
		}
		
	}
	
	/**
	 * Sets the suggested name to either the first element in combined List or 
	 * to either/or the top name of each user's final ranked list
	 * @param s
	 */
	public void setSuggestedName(String s) {
		if (s != null) {
			topName.setText(s);	
		} else {
			String bothNames = "";
			String choice1 = parent1List.get(0).getName();
			System.out.println("Parent 1 Choice: " + choice1);
			String choice2 = parent2List.get(0).getName();
			System.out.println("Parent 2 Choice: " + choice2);
			topName.setText(bothNames.concat(choice1 + " or " + choice2));
			
		}
		
	}
}
