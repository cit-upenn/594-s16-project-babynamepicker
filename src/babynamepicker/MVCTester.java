/**
 * This class has the main method that runs the program.
 */
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
            	FileReader fr = new FileReader("names/", 1879);
            	Dataset data = fr.parseData();
                new MVCTester().create(data);
            }
        });
        
    }
	
	/**
	 * Creates & makes settings for the JFrame for the program
	 * @param inputData
	 */
	private void create(Dataset inputData) {
        JFrame f = new JFrame("BabyName Picker");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MainPanel(inputData));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
