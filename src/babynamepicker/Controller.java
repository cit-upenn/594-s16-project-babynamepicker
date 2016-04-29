package babynamepicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Controller implements MouseListener {

	private JFrame frame;
	private JButton readyToRank;
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
		
//		frame = new JFrame()
//		model.addFilterFrame(0);
//		model.addFilterFrame(1);
//		model.addRankingFrame(0);
//		model.addRankingFrame(1);
	}
	
	private void display() {
		//have first filter frame displayed
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object source = e.getSource();
//		if (source instanceof JButton) {
//			System.out.println("GOt the action.");
//			model.setDisplayFrame("ranking", 0);
//		}
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source instanceof JButton) {
			System.out.println("Got the action.");
			model.setDisplayFrame("ranking", 0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
