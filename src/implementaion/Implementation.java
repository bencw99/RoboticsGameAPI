package implementaion;
import java.awt.event.ActionEvent;

import constants.*;
import entity.*;
import game.*;
import graphics.*;
import gui.*;
import input.*;
import physics.*;
import world.*;
public class Implementation extends Implementor{
	/**
	 * Called when game starts
	 */
	public void main() {
		//Ignore
		init();
		
		
		
		//Ignore
		run();
	}
	public class Button1 extends AbstractButton{
		public void init(){
			getButton().setBounds(0,0,50,50);
			getButton().setText("Button1");
			getButton().setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}

