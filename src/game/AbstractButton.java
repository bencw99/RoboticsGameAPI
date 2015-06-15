package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;
public abstract class AbstractButton implements ActionListener {
	private Button jbutton;
	private String name;
	public abstract void actionPerformed(ActionEvent e);
	public abstract void init();
	public Button getButton(){
		return jbutton;
	}
	public String getName(){
		return name;
	}
}
