package gui;
import input.InputListener;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

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
		setName("GUI");
		setVisible(true);
		game = g;
	}
	
	public void paintComponent(Graphics g){
		// This line of code has cost me
		super.paintComponent(g);
		// More than 3 hours
		
		// Draws the game World
		game.getWorld().draw(g);
	}
	
	public void update(ArrayList<AbstractButton> buttons){
		for(AbstractButton button : buttons){
			ArrayList<Component> components = new ArrayList<Component>(Arrays.asList(getComponents()));
			if(!components.contains(button.getButton())){
				add(button.getButton());
			}
		}
		repaint();
	}
}
