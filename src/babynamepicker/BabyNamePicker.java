package babynamepicker;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * This class is the Controller. It sets up the GUI and handles all the controls (buttons, menu items, etc.)
 * @author gracelee
 *
 */
public class BabyNamePicker {

	private JFrame frame;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JTextArea genderText;
	private JRadioButton maleButton;
	private JRadioButton femaleButton; //if neither chosen, both male and female names listed
	private ButtonGroup maleOrFemaleGroup;
	private JTextArea popularText;
	private JRadioButton leastPopularButton;
	private JRadioButton mostPopularButton;
	private ButtonGroup popularityGroup;
	private JTextArea startsWithText;
	private JComboBox<String> startWithMenu;
	private JTextArea endsWithText;
	private JComboBox<String> endsWithMenu;
	private String[] letters;
	private JTextArea numSuggestionsText;
	private JComboBox<String> numSuggestionsMenu;
	private String[] numSuggestions;
	private JButton readyToRankButton;
	
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

//		FileReader fr = new FileReader("names/", 1888);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BabyNamePicker b = new BabyNamePicker();
                b.init();
                b.display();
            }
        });
//		BabyNamePicker b = new BabyNamePicker();
//		b.init();
//		b.display();
	}
	
	/**
	 * Sets up communication between the components
	 */
	private void init() {
		model = new Model();
		view = new View(model);
		model.addObserver(view);
	}
	
	/**
     * Displays the GUI.
     */
	private void display() {
		layOutComponents();
		attachListenersToComponents();
		frame.setSize(700, 700);
		frame.setVisible(true);
	}
	
	/**
     * Arranges the various components in the GUI.
     */
	private void layOutComponents() {
		frame = new JFrame("Baby Name Picker");
		
//		leftPanel = new JPanel(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel = new JPanel(new GridBagLayout());
		rightPanel = new JPanel(); //Choose layout
		
		genderText = new JTextArea("Gender of the Baby: ");
		popularText = new JTextArea("Sort by Commonality: ");
		startsWithText = new JTextArea("Starts with letter: ");
		endsWithText = new JTextArea("Ends with letter: ");
		numSuggestionsText = new JTextArea("Number of Suggestions: ");
		
		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		maleOrFemaleGroup = new ButtonGroup();
		maleOrFemaleGroup.add(maleButton);
		maleOrFemaleGroup.add(femaleButton);
		leastPopularButton = new JRadioButton("Least to Most");
		mostPopularButton = new JRadioButton("Most to Least");
		popularityGroup = new ButtonGroup();
		popularityGroup.add(leastPopularButton);
		popularityGroup.add(mostPopularButton);
		letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		startWithMenu = new JComboBox<String>(letters);
		endsWithMenu = new JComboBox<String>(letters);
		readyToRankButton = new JButton("I'm ready to rank!");
		numSuggestions = new String[] {"10", "20", "30","40", "50"};
		numSuggestionsMenu = new JComboBox<String>(numSuggestions);
		
		frame.setLayout(new GridBagLayout()); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		leftPanel.add(endsWithText, c);
		i++;
		c.gridy = i;
		leftPanel.add(endsWithMenu, c);
		i++;
		c.gridy = i;
		leftPanel.add(numSuggestionsText, c);
		i++;
		c.gridy = i;
		leftPanel.add(numSuggestionsMenu, c);
		i++;
		c.gridy = i;
		leftPanel.add(readyToRankButton, c);
		c.gridx = 0;
		c.gridy = 1;
		frame.add(leftPanel, c);
		view.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.9;
		c.anchor = GridBagConstraints.CENTER;
		frame.add(view, c);
		
		
	}
	
	/**
     * Attaches listeners to the components, and schedules a Timer.
     */
    private void attachListenersToComponents() {
    	//The Male button tells the Model to list Male names only
    	maleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	//The Female button tells the Model to list Female names only
    	femaleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	//The Least Popular Button tells the Model to list names from least common to most common.
    	leastPopularButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	//The Most Popular Button tells the Model to list names from most common to least common.
    	mostPopularButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
    		
    	});
    	//Selection in Starts With Menu tells the Model to list names starting with selected letter.
    	startWithMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox c = (JComboBox) e.getSource();
				String selectedItem = (String) c.getSelectedItem();
				
			}
    		
    	});
    	//Selection in Ends With Menu tells the Model to list names ending with selected letter.
    	endsWithMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	//Selection in Num Suggestions Menu tells the Model to list selected number of names.
    	numSuggestionsMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	//Ready to Rank button tells Model to show next Pane.
    	readyToRankButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Button pressed");
				
			}
    		
    	});
    }
	


}
