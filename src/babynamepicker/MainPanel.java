package babynamepicker;
import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * This class represents the main panel of the Baby Name Picker.
 * @author gracelee
 *
 */
public class MainPanel extends JPanel {
	
	public MainPanel() {
        super(new BorderLayout());
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        this.add(view, BorderLayout.CENTER);
        this.add(controller, BorderLayout.SOUTH); //Click to Continue button
    }

}
