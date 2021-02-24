import java.util.Random;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Point generatePoint() {
        Random random = new Random();
        double x = random.nextDouble() * 2.0 - 1.0;
        double y = random.nextDouble() * 2.0 - 1.0;

        return new Point(x, y);
    }

    public double distanceFromCenter() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }
}
