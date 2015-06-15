package gui;

import java.util.ArrayList;

import javax.swing.*;

public class Gui extends JPanel {
	private static ArrayList<Button> buttons = new ArrayList<Button>();
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public Gui() {
		super();
	}
	
	public void addButton(Listener<gui.Button> buttonClickedListenerInstance, int x, int y, int width, int height, String text){
		Button b = new Button(buttonClickedListenerInstance);
		b.setBounds(x, y, width, height);
		b.setText(text);
		buttons.add(b);
		add(b);
	}
	
}
