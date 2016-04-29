package babynamepicker;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
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
	private CardLayout mainCard;
	private Model model;
	private View view;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Controller b = new Controller();
                b.init();
                b.display();
            }
        });
	}
	
//	private void init() {
//		model = new Model("names/", 1888);
//		view = new View(model);
//		model.addObserver(view);
//		
//		frame = new JFrame("Welcome to Baby Name Picker!");
//		frame.setSize(900, 900);
//		
//		mainPanel = new JPanel(new BorderLayout());
//		
//		clickToContinue = new JButton("Click To Continue");
//		mainPanel.add(clickToContinue, BorderLayout.SOUTH);
//		
//		frame.add(mainPanel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
////		SwingUtilities.invokeLater(new Runnable() {
////            public void run() {
////            	Controller b = new Controller();
////                b.init();
////                b.display();
////            }
////        });
//		Controller c = new Controller();
//		c.init();
//		c.display();
//	}
	
	private void init() {
		System.out.println("Start.");
//		model = new Model();
		System.out.println("Made Model.");
		view = new View(model);
		System.out.println("Made View.");
		model.addObserver(view);
		System.out.println("Attached observer.");
		
		System.out.println("Reached point 1.");
		
		frame = new JFrame("Welcome to Baby Name Picker!");
//		frame.setLayout(new GridBagLayout());
		
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
//		mainPanel = new JPanel(new BorderLayout());
//		mainPanel = new FilterFrame();
//		mainPanel.setVisible(true);
		
//		clickToContinue = new JButton("Click To Continue");
//		mainPanel.add(clickToContinue, BorderLayout.SOUTH);
//		mainPanel.add(model.getPanel(0), "0");
//		mainPanel.add(model.getPanel(1), "1");
		
		
		System.out.println("reached point 2.");
		
		frame.add(mainPanel);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println("Reached point 3.");
	}
	
	private void display() {
		attachListenersToComponents();
	}
	
	private void attachListenersToComponents() {
		clickToContinue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				int n = model.getCurrentDisplay();
//				n++;
//				model.setCurrentDisplay(n);
			}
			
		});
	}


}
