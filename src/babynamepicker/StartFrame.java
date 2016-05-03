/**
 * This class represents the panel that is displayed at the beginning
 * of the program.
 */
package babynamepicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class StartFrame extends JPanel {

	private JLabel topText;
	private JTextArea instruction;
	private BufferedImage image;
	
	/**
	 * Constructor of this class
	 */
	public StartFrame() {
		
		//Loads image to be displayed as background of this panel
		try {
			image = ImageIO.read(new File("baby.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		topText = new JLabel("Welcome to Baby Name Picker!", SwingConstants.CENTER);
		
		instruction = new JTextArea();
		
		topText.setFont(new Font("Chalkboard", Font.PLAIN, 50));
		
		instruction.append("We will help you & your loved one decide on a name for your new child!" + "\n");
		instruction.append("Both parents must be present for the duration of this program." + "\n");
		instruction.append("Each parent will take turns filtering and ranking a list of potential names." + "\n");
		instruction.append("At the end, we will present names that you both like for your child." + "\n");
		instruction.append("Let's get started!" + "\n");
		instruction.setLineWrap(true);
		instruction.setEditable(false);
		instruction.setFont(new Font("Chalkboard", Font.PLAIN, 24));
		instruction.setOpaque(false);
		
		this.add(topText, BorderLayout.NORTH);
		this.add(instruction, BorderLayout.CENTER);
		
		this.setSize(700, 700);
		
	}
	
	/**
	 * Paints the loaded image to be the background of this panel
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
}
