package gui;
import input.InputListener;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.*;

public class Gui extends JPanel {
	private InputListener  listener;
	
	private Game game;
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public Gui(Game g) {
		super();
		listener = new InputListener();
		addKeyListener(listener);
		addMouseListener(listener);
		addMouseMotionListener(listener);
		game = g;
	}
	public void paintComponent(Graphics g){
		game.getWorld().draw(g);
	}
	public void update(ArrayList<AbstractButton> buttons){
		this.removeAll();
		this.setVisible(true);
		for(AbstractButton button : buttons){
			add(button.getButton());
		}
		repaint();
	}
	
	@Override
	public void paintComponents(Graphics g) {
	    super.paintComponents(g);
		File testFile = new File("happy.jpg");
			try {
				Image testImage = ImageIO.read(testFile);
			    g.drawImage(testImage, 100, 100, null); // see javadoc for more info on the parameters            

			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
