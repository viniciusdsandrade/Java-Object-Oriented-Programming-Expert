package src.point;

import java.util.Objects;

public class MovableRectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1,
                            int x2, int y2,
                            int speed) {
        topLeft = new MovablePoint(x1, y1, speed);
        bottomRight = new MovablePoint(x2, y2, speed);
    }

    public MovablePoint getTopLeft() {
        return topLeft;
    }

    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        MovableRectangle other = (MovableRectangle) obj;

        return Objects.equals(this.topLeft, other.topLeft) &&
                Objects.equals(this.bottomRight, other.bottomRight);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + topLeft.hashCode();
        hash *= prime + bottomRight.hashCode();

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "MovablePoint[x1 = " + topLeft.getX() + ", y1 = " + topLeft.getY() + ", x2 = " + bottomRight.getX() + ", y2 = " + bottomRight.getY() + ", speed = " + topLeft.getSpeed() + "]";
    }
}
