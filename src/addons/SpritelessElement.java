package addons;

import physics.Position;

public interface SpritelessElement{
	void init();
	void update();
	void disable();
	void setPosition(Position p);
	void setPosition(double xPos, double yPos);
	Position getPosition();
	double getXPosition();
	double getYPosition();
	void show();
	void hide();
}
