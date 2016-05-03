package babynamepicker;


import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * This class represents the View of the Baby Name Picker.
 * It updates the panel to be displayed on the window when notified.
 * @author gracelee
 *
 */
public class View extends JPanel implements Observer {

	private Model model;
    private CardLayout displayCardLayout;

    public View (Model model) {
        this.model = model;
        model.addObserver(this);
        init();
    }

    /**
     * Initializes the panels to include in CardLayout
     */
    private void init() {
        displayCardLayout = new CardLayout();
        this.setLayout(displayCardLayout);
        //Add all the panels
        this.add(model.getPanel(0), "0"); //Start Panel
        this.add(model.getPanel(1), "1"); // Filter Panel 1
        this.add(model.getPanel(2), "2"); // Ranking Panel 1
        this.add(model.getPanel(3), "3"); // Filter Panel 2
        this.add(model.getPanel(4), "4"); // Ranking Panel 2
        this.add(model.getPanel(5), "5"); //Final Panel
        displayCardLayout.show(this, "0");
    }

    /**
     * Updates the panel being displayed when notified
     */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String updated = Integer.toString(model.getCurrent());
		displayCardLayout.show(this, updated);
	}

    
}
