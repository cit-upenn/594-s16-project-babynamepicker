package babynamepicker;

import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * This class represents the View of the Baby Name Picker.
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

    private void init() {
        displayCardLayout = new CardLayout();
        this.setLayout(displayCardLayout);
        //add all the panels
        this.add(model.getPanel(0), "0");
        this.add(model.getPanel(1), "1");
        displayCardLayout.show(this, "0");
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String updated = Integer.toString(model.getCurrent());
		displayCardLayout.show(this, updated);
	}

    
}
