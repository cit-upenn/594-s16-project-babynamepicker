package babynamepicker;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class represents the Controller. The Controller sets up the GUI panel and holds
 * the buttons that switch the currently displayed panel.
 * @author gracelee
 *
 */
public class Controller extends JPanel {

	private Model model;
	private View view;
	static protected JButton clickToContinue;
	
	/**
	 * Constructor of the class
	 * @param model Model
	 * @param view View
	 */
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		clickToContinue = new JButton("Click To Continue");
		clickToContinue.setFont(new Font("Chalkboard", Font.PLAIN, 14));
		init();
	}
	
	/**
	 * Initializes components and sets features of the panel
	 */
	private void init() {
		this.setBackground(Color.WHITE);
		this.add(clickToContinue);
		clickToContinue.setEnabled(true);
		setVisible(true);
		attachListenersToComponents();
	}
	
	/**
	 * Attaches listeners to the components, mainly the Click To Continue Button
	 */
	private void attachListenersToComponents() {
		//Click to Continue tells Model that panel to display on GUI has changed
		//Depending on what panel user has just finished, filtered and ranked lists are saved for future panels' use
		clickToContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clickToContinue.setEnabled(false);
				
				int screenClicked = model.getCurrent();
				
				if (screenClicked == 1) { //Done Filtering for User 1, save user 1's filtered list
					model.getDataset().setUserNameList(1, model.getDataset().convertNameToBabyNameList(model.getDataset().getFilteredList()));
					model.getRankingPanel(0).setWorkingList(model.getDataset().getUserNameList(1), 1);
					System.out.println(model.getDataset().getUserNameList(1).get(0).getName());
					
				} else if (screenClicked == 2) { //Done Ranking for User 1, save user 1's ranked list
					model.getFinalFrame().setRankedList(1, model.getRankingPanel(0).getFinalizedList());
					
				} else if (screenClicked == 3) { //Done Filtering for User 2, save user 2's filtered list
					model.getDataset().setUserNameList(2, model.getDataset().convertNameToBabyNameList(model.getDataset().getFilteredList()));
					model.getRankingPanel(1).setWorkingList(model.getDataset().getUserNameList(2), 2);
					System.out.println(model.getDataset().getUserNameList(2).get(0).getName());
					
				} else if (screenClicked == 4) { //Done Ranking for User 2, save user 2's ranking list & combined list, display all
					clickToContinue.setVisible(false);
					model.getFinalFrame().setRankedList(2, model.getRankingPanel(1).getFinalizedList());
					model.getFinalFrame().setRankedList(3, null);
					model.getFinalFrame().displayFinalLists();
				} 
				
				//Go to next panel
				screenClicked++;
				model.setCurrent(screenClicked);
			}
			
		});
	}

}
