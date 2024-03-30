package src.point;

import java.util.Objects;

public class MovablePoint implements Movable {

    private int x;
    private int y;
    private int speed;

    public MovablePoint(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void incrementSpeed(int speed) {
        this.speed += speed;
    }

    public void decrementSpeed(int speed) {
        this.speed -= speed;
    }

    @Override
    public void moveUp() {
        y += speed;
    }

    @Override
    public void moveDown() {
        y -= speed;
    }

    @Override
    public void moveLeft() {
        x -= speed;
    }

    @Override
    public void moveRight() {
        x += speed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        MovablePoint that = (MovablePoint) obj;

        return Objects.equals(this.x, that.x) &&
                Objects.equals(this.y, that.y) &&
                Objects.equals(this.speed, that.speed);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;

        hash *= prime + x;
        hash *= prime + y;
        hash *= prime + speed;

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "MovablePoint[x = " + x + ", y = " + y + ", speed = " + speed + "]";
    }
}
