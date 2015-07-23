package addons;

import java.util.Timer;
import physics.Position;

public interface NonEntityElements {
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
