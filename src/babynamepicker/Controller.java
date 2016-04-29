package babynamepicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class represents the Controller.
 * @author gracelee
 *
 */
public class Controller extends JPanel {

	private Model model;
	private View view;
	private JButton clickToContinue;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		clickToContinue = new JButton("Click To Continue.");
		init();
	}
	
	private void init() {
		this.add(clickToContinue);
		setVisible(true);
		attachListenersToComponents();
	}
	
	private void attachListenersToComponents() {
		clickToContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int screenClicked = model.getCurrent();
				screenClicked++;
				model.setCurrent(screenClicked);
			}
			
		});
	}



}
