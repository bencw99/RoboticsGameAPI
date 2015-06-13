package gui;

import java.util.ArrayList;

import javax.swing.*;

public class Gui extends JFrame {
	private static ArrayList<Button> buttons = new ArrayList<Button>();
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public Gui() {
		super("Game");
	}
	
	public void addButton(Listener<Button> actionListener, int x, int y, int width, int height, String text){
		Button b = new Button(actionListener);
		b.setBounds(x, y, width, height);
		b.setText(text);
		buttons.add(b);
		add(b);
	}
	
	/**
	 * compares button to the list of buttons, to find index
	 * @param button
	 * -the button that was pressed
	 */
}
