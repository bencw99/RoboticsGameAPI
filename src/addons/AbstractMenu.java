package addons;

import physics.Position;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;

public class AbstractMenu extends Container implements SpritelessElement {

	private static final long serialVersionUID = 1L;

	private Position p;

    public AbstractMenu() {
    	this(0, 0);
    }
    
    public AbstractMenu(double xPos, double yPos) {
    	super();
    	this.setLayout(new GridLayout(3, 0, 0, 0));
    	p = new Position(xPos, yPos);
    }

    public void addSpritelessElement(SpritelessElement menuElement) {
        changeToMenuPosition(menuElement);
        add((Component) menuElement);
        menuElement.init();
    }

    public void changeToMenuPosition(SpritelessElement menuElement) {
        menuElement.setPosition(this.getXPosition() + menuElement.getXPosition(), this.getYPosition() + menuElement.getYPosition());
    }

    public void update() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.update();
        }
    }

    public void init() {
    }

    public void disable() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.disable();
        }
    }

    public void show() {
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.show();
        }
    }

    public void hide() {
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.hide();
        }
    }
    
    public double getXPosition() {
        return this.p.getX();
    }

    public double getYPosition() {
        return this.p.getY();
    }

    public Position getPosition() {
        return p;
    }

    public void setPosition(double xPos, double yPos) {
        double xDifference = xPos - this.p.getX();
        this.p.setX(xPos);

        double yDifference = yPos = this.p.getY();
        this.p.setY(yPos);

        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.setPosition(element.getXPosition() + xDifference, element.getYPosition() + yDifference);
        }
    }

    public void setPosition(Position pos) {
        double xDifference = pos.getX() - this.p.getX();
        double yDifference = pos.getY() - this.p.getY();
        p = pos;
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(this.getComponent(x));
            element.setPosition(element.getXPosition() + xDifference, element.getYPosition() + yDifference);
        }
    }

}
