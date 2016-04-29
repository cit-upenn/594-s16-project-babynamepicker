package babynamepicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class View extends JPanel implements Observer {
	
	private Model model;
	
	public View(Model model) {
		this.model = model;
		init();
	}
	
	public void init() {
//		model.setCurrentDisplay(0);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int updated = model.getCurrentDisplay();
		for (int i = 0; i < model.getAllPanels().length; i++) {
			if (i == updated) {
				model.getAllPanels()[i].setVisible(true);
			} else {
				model.getAllPanels()[i].setVisible(false);
			}
		}
	}

}
