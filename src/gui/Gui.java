package gui;
<<<<<<< HEAD
import input.InputListener;
=======

import java.awt.BorderLayout;
>>>>>>> Changed game to a JFrame, basic image display now functional
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
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
<<<<<<< HEAD
		listener = new InputListener();
		addKeyListener(listener);
		addMouseListener(listener);
		addMouseMotionListener(listener);
		game = g;
	}
	public void paintComponent(Graphics g){
		game.getWorld().draw(g);
=======
		setName("GUI");
		setVisible(true);
>>>>>>> Changed game to a JFrame, basic image display now functional
	}
	public void update(ArrayList<AbstractButton> buttons){
		this.removeAll();
		for(AbstractButton button : buttons){
			add(button.getButton());
		}
		repaint();
	}
}
