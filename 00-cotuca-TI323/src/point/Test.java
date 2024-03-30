package src.point;

public class Test {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(0, 0, 1);
        System.out.println("movablePoint = " + movablePoint);

        movablePoint.moveUp();
        System.out.println("movablePoint.moveUp(): " + movablePoint);

        movablePoint.moveRight();
        System.out.println("movablePoint.moveRight():" + movablePoint);

        movablePoint.moveDown();
        System.out.println("movablePoint.moveDown(): " + movablePoint);

        movablePoint.moveLeft();
        System.out.println("movablePoint.moveLeft(): " + movablePoint);

        movablePoint.incrementSpeed(1);
        System.out.println("movablePoint.incrementSpeed(1): " + movablePoint);

        movablePoint.decrementSpeed(1);
        System.out.println("movablePoint.decrementSpeed(1): " + movablePoint);
    }
}
