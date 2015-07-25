package addons;

import physics.Position;

import java.awt.Component;
import java.util.ArrayList;

/**
 *
 */
public class AbstractMenu extends Component implements SpritelessElement {

    private Position p;

    public ArrayList<SpritelessElement> list;

    public AbstractMenu() {
    	p = new Position(0, 0);
        list = new ArrayList<SpritelessElement>();
    }
    
    public AbstractMenu(double xPos, double yPos) {
    	p = new Position(xPos, yPos);
    	list = new ArrayList<SpritelessElement>();
    }

    public void addSpritelessElement(SpritelessElement menuElement) {
        changeToMenuPosition(menuElement);
        list.add(menuElement);
        menuElement.init();
    }

    public void changeToMenuPosition(SpritelessElement menuElement) {
        menuElement.setPosition(this.getXPosition() + menuElement.getXPosition(), this.getYPosition() + menuElement.getYPosition());
    }

    public void update() {
    	System.out.println(list.size());
        for(SpritelessElement menuElement : list) {
            menuElement.update();
        }
    }

    public void init() {
    }

    public void disable() {
        for(SpritelessElement menuElement : list) {
            menuElement.disable();
        }
    }

    public void show() {
        for(SpritelessElement menuElement : list) {
            menuElement.show();
        }
    }

    public void hide() {
        for(SpritelessElement menuElement : list) {
            menuElement.hide();
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

        for(SpritelessElement menuElement : list) {
            menuElement.setPosition(menuElement.getXPosition() + xDifference, menuElement.getYPosition() + yDifference);
        }
    }

    public void setPosition(Position pos) {
        double xDifference = pos.getX() - this.p.getX();
        double yDifference = pos.getY() - this.p.getY();

        p = pos;

        for(SpritelessElement menuElement : list) {
            menuElement.setPosition(menuElement.getXPosition() + xDifference, menuElement.getYPosition() + yDifference);
        }
    }

}
