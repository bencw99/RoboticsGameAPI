package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;
public abstract class AbstractButton implements ActionListener {
	private Button jbutton;
	public abstract void actionPerformed(ActionEvent e);

}
