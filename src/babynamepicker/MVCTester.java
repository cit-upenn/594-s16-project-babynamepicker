package babynamepicker;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This class is the main method that runs the Baby Name Picker.
 * @author gracelee
 *
 */
public class MVCTester {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                new MVCTester().create();
            }
        });
        
    }
	
	private void create() {
        JFrame f = new JFrame("One Night Ultimate Baby");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
