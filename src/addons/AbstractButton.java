package addons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import physics.Position;

public abstract class AbstractButton extends JButton implements SpritelessElement, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Position p;

	public AbstractButton() {
		p = new Position(0, 0);
		addActionListener(this);
	}

	public abstract void show();
	public abstract void hide();
	public abstract void update();
	public abstract void actionPerformed(ActionEvent e);
	
	public void setButtonText(String text) {
		this.setText(text);
	}
	
	public String getButtonText() {
		return this.getText();
	}
	
	public void init() {
		this.setEnabled(true);
	}
	
	public void disable() {
		this.setEnabled(false);
	}
	
	public void setPosition(Position p) {
		this.p.setX(p.getX());
		this.p.setY(p.getY());
	}
	
	public void setPosition(double xPos, double yPos) {
		this.p.setX(xPos);
		this.p.setY(yPos);
	}
	
	public Position getPosition() {
		return p;
	}
	
	public double getXPosition() {
		return this.p.getX();
	}
	
	public double getYPosition() {
		return this.p.getY();
	}


}
