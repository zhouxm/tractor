package view;

import java.awt.Point;

public class CardPosition {
    private double currX, currY, currDir;
    private boolean faceUp, selected;
    private int destX, destY;
    private double destDir;
    private double snapRatio;

    public CardPosition(Point point, boolean faceUp) {
        this.currX = destX = point.x;
        this.currY = destY = point.y;
        this.currDir = destDir = 0;
        this.faceUp = faceUp;
    }

    public int currX() {
        return (int) currX;
    }

    public int currY() {
        return (int) currY;
    }

    public double currDir() {
        return currDir;
    }

    public boolean faceUp() {
        return faceUp;
    }

    public boolean selected() {
        return selected;
    }

    public void setDest(Point dest, double dir, boolean faceUp, double snapRatio) {
        this.destX = dest.x;
        this.destY = dest.y;
        this.destDir = dir;
        this.faceUp = faceUp;
        this.snapRatio = snapRatio;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void snap() {
        currX = destX * snapRatio + currX * (1 - snapRatio);
        currY = destY * snapRatio + currY * (1 - snapRatio);

        if (Math.hypot(currX - destX, currY - destY) < 10) {
            currX = destX;
            currY = destY;
            currDir = destDir;
        }
    }
}
