package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;
public abstract class AbstractButton implements ActionListener{
	private Button jbutton = new Button(this);
	private String name;
	public abstract void init();
	public abstract void actionPerformed(ActionEvent e);
	public Button getButton(){
		return jbutton;
	}
	public String getName(){
		return name;
	}
}
