package spriteless;

import physics.Dimension;
import physics.Position;

public interface SpritelessElement{
	void init();
	void update();
	void disable();
	void setPosition(Position p);
	void setPosition(double xPos, double yPos);
    void setDimension(Dimension dim);
    void setDimension(double width, double height);
    Dimension getDimension();
	Position getPosition();
	double getXPosition();
	double getYPosition();
	void show();
	void hide();
}
