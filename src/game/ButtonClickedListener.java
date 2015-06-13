package game;

import gui.*;

public class ButtonClickedListener<Button> extends Listener<Button> {
	private Game game;
	ButtonClickedListener(Game g){
		game = g;
	}
	public void callMethod(Button button) {
		game.buttonClicked((gui.Button) button);
		
	}

}
