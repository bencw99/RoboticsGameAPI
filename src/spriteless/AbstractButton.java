package spriteless;

import physics.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractButton extends JButton implements SpritelessElement, ActionListener {

	private static final long serialVersionUID = 1L;

    private Dimension dim;

	private Position p;

	public AbstractButton() {
		p = new Position(0, 0);
        dim = new Dimension(10, 10);
        setPreferredSize(dim);
		addActionListener(this);
	}

	public abstract void update();
	public abstract void actionPerformed(ActionEvent e);

    public final void show() {
        setVisible(true);
    }

  	public final void hide() {
        setVisible(false);
    }

	public void setButtonText(String text) {
		setText(text);
	}
	
	public String getButtonText() {
		return getText();
	}
	
	public void init() {
		setEnabled(true);
	}
	
	public void disable() {
		setEnabled(false);
	}

    public void setDimension(Dimension dim) {
        this.dim = dim;
    }

    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
        setPreferredSize(dim);
    }

    public Dimension getDimension() {
        return this.dim;
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
