package babynamepicker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Controller {

	private JFrame frame;
	private JPanel mainPanel;
	private JButton clickToContinue;
	
	private Model model;
	private View view;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Controller b = new Controller();
                b.init();
                b.display();
            }
        });
	}
	
	private void init() {
		model = new Model("names/", 1888);
		view = new View(model);
		model.addObserver(view);
		
		frame = new JFrame("Welcome to Baby Name Picker!");
		frame.setSize(900, 900);
		
		mainPanel = new JPanel(new BorderLayout());
		
		clickToContinue = new JButton("Click To Continue");
		mainPanel.add(clickToContinue, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	private void display() {
		
	}


}
