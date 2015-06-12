package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
	private Gui thisGui;
	Button(Gui gui){
		addActionListener(this);
		thisGui = gui;
	}
	public void actionPerformed(ActionEvent e) {
		thisGui.buttonClicked(this);
	}

}
