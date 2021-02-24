import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Long> innerPointCounts = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int pointsCount = 1000000000;
        int threads = 9;
        Thread[] threadsTab = new Thread[threads];
        long timeStart = System.currentTimeMillis();

        for(int i = 0; i < threadsTab.length; i++) {
            threadsTab[i] = new Thread(new InnerPointsCounterThread(pointsCount/threads));
            threadsTab[i].start();
        }

        for (int i = 0; i < threadsTab.length; i++) {
            threadsTab[i].join();
        }

        long innerPoints = Main.innerPointCounts.stream().reduce(0L, (x, y) -> x + y);

        double PI = (4.0 * ((double) innerPoints)) / ((double) pointsCount);
        long timeEnd = System.currentTimeMillis();

        System.out.println(PI);
        System.out.println("Czas: " + (timeEnd - timeStart));
    }
}
