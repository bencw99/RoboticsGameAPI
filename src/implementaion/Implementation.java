package implementaion;
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
		super.main();
		
		//Write code here
		
		
		
		//Ignore
		begin();
	}
	public void buttonPressed(AbstractButton button){
		String buttonName = button.getName();
		if(buttonName.equals("Button1")){
			//do Button1's implementation
		}
		else if(buttonName.equals("Button2")){
			//do Button2's implementation
		}
		//etc
	}
}
