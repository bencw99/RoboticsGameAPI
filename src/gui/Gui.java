package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import game.*;

public class Gui extends JPanel {
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public Gui() {
		super();
	}
	
	public void update(ArrayList<AbstractButton> buttons){
		this.removeAll();
		for(AbstractButton button : buttons){
			add(button.getButton());
		}
	}
	
}
