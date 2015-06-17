package gui;

import input.InputListener;

import java.util.ArrayList;

import javax.swing.JPanel;

import game.*;

public class Gui extends JPanel {
	private InputListener  listener;
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public Gui() {
		super();
		listener = new InputListener();
		addKeyListener(listener);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void update(ArrayList<AbstractButton> buttons){
		this.removeAll();
		for(AbstractButton button : buttons){
			add(button.getButton());
		}
	}
	
}
