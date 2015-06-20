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
		
		//Write code here
		for(int i = 1; i <= 256; i++) {
			super.addEntity(new CrazyEntity(game.getWorld()));
		}
		super.addEntity(new Rafi(game.getWorld()));
		addButton(new Button1());
		//Ignore
		run();
	}
	public class Button1 extends AbstractButton{
		public void init(){
			getButton().setBounds(0,0,150,150);
			getButton().setText("Trigger 0");
			getButton().setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			if(((Button) e.getSource()).getText().equals("Trigger 1")){
				((Button) e.getSource()).setText("Trigger 0");
			}
			else if(((Button) e.getSource()).getText().equals("Trigger 0")){
				((Button) e.getSource()).setText("Trigger 1");
			}
		}
	}
}

