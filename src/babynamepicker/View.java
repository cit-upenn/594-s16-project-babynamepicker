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
	private DefaultListModel listModel;
	private JList namesList;
	private JScrollPane listScroller;
	
	public View(Model model) {
		this.model = model;
		init();
	}
	
	public void init() {
		listModel = new DefaultListModel();
		for (int i = 0; i < model.getDataList().size(); i++) {
			listModel.addElement(model.getDataList().get(i).getName());
		}
		namesList = new JList(listModel);
		namesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		namesList.setLayoutOrientation(JList.VERTICAL);
		namesList.setVisibleRowCount(10);
		listScroller = new JScrollPane(namesList);
		listScroller.setPreferredSize(new Dimension(150, 400));
		add(listScroller);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listModel.size(); i++) {
			listModel.remove(i);
		}
		for (int j = 0; j < model.getUserList().size(); j++) {
			listModel.addElement(model.getUserList().get(j));
		}
	}

}
