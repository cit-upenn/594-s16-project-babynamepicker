package babynamepicker;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * This class represents the main panel of the Baby Name Picker.
 * It holds the Model, View, and Controller of this program.
 * @author gracelee
 *
 */
public class MainPanel extends JPanel {
	
	/**
	 * Constructor of this class
	 * @param inputData baby name dataset
	 */
	public MainPanel(Dataset inputData) {
		super(new BorderLayout());
        Model model = new Model(inputData);
        View view = new View(model);
        Controller controller = new Controller(model, view);
        this.add(view, BorderLayout.CENTER);
        this.add(controller, BorderLayout.SOUTH);
    }

}
