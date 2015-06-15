package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
	//private Gui thisGui;
	private Listener<Button> listener;
	Button(/*Gui gui,*/ Listener<Button> listen){
		addActionListener(this);
		listener = listen;
		//thisGui = gui;
	}
	public void actionPerformed(ActionEvent e) {
		listener.callMethod((Button)e.getSource());
	}

}
