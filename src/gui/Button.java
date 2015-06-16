package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton{
	public Button(ActionListener action){
		addActionListener(action);
	}

}
