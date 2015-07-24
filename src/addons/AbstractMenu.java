package addons;

import physics.Position;

import java.util.ArrayList;

/**
 *
 */
public class AbstractMenu implements NonEntityElement {

    private Position p;

    private double xPos;
    private double yPos;

    private ArrayList<NonEntityElement> list;

    public AbstractMenu() {
        list = new ArrayList<NonEntityElement>();
    }

    public void addNonEntityElement(NonEntityElement menuElement) {
        changeToMenuPosition(menuElement);
        list.add(menuElement);
        menuElement.init();
    }

    public void changeToMenuPosition(NonEntityElement menuElement) {
        menuElement.setPosition(this.getXPosition() + menuElement.getXPosition(), this.getYPosition() + menuElement.getYPosition());
    }

    public void update() {
        for(NonEntityElement menuElement : list) {
            menuElement.update();
        }
    }

    public void init() {
        list = new ArrayList<NonEntityElement>();
    }

    public void disable() {
        for(NonEntityElement menuElement : list) {
            menuElement.disable();
        }
    }

    public void show() {
        for(NonEntityElement menuElement : list) {
            menuElement.show();
        }
    }

    public void hide() {
        for(NonEntityElement menuElement : list) {
            menuElement.hide();
        }
    }

    public double getXPosition() {
        return xPos;
    }

    public double getYPosition() {
        return yPos;
    }

    public Position getPosition() {
        return p;
    }

    public void setPosition(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setPosition(Position pos) {
        p = pos;
    }

}
