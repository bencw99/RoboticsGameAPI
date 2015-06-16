package game;

import gui.*;

public class ButtonClickedListener<AbstractButton> extends Listener<AbstractButton> {
	private Game game;
	ButtonClickedListener(Game g){
		game = g;
	}
	public void callMethod(AbstractButton button) {
		game.buttonClicked((game.AbstractButton) button);
		
	}

}
