import java.util.stream.Stream;

public class InnerPointsCounterThread implements Runnable {
    public int pointsCount;

    public InnerPointsCounterThread(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    @Override
    public void run() {
        Main.innerPointCounts.add(
                Stream.generate(Point::generatePoint)
                        .limit(pointsCount)
                        .filter(x -> x.distanceFromCenter() <= 1.0)
                        .count()
        );
    }
}
