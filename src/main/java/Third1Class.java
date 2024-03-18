import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Third1Class{
    private static final int NUM_WINDOWS = 3;

    public static AtomicInteger[] windowCounters;
    public static AtomicInteger[] categoryCounters;
    public static AtomicInteger[] abandonedCounters;

    public static void main(String[] args) {
        windowCounters = new AtomicInteger[NUM_WINDOWS];
        categoryCounters = new AtomicInteger[ThirdTask.NUM_CATEGORIES];
        abandonedCounters = new AtomicInteger[ThirdTask.NUM_CATEGORIES];

        for (int i = 0; i < NUM_WINDOWS; i++) {
            windowCounters[i] = new AtomicInteger(0);
        }

        for (int i = 0; i < ThirdTask.NUM_CATEGORIES; i++) {
            categoryCounters[i] = new AtomicInteger(0);
            abandonedCounters[i] = new AtomicInteger(0);
        }
        ThirdTask thirdClass = new ThirdTask();
        Thread thirdThread = new Thread(thirdClass);
        thirdThread.start();
    }
    public static int getRandomCategory() {
        Random random = new Random();
        return random.nextInt(ThirdTask.NUM_CATEGORIES);
    }

    public static int getRandomWindow(int category) {
        Random random = new Random();
        int window = random.nextInt(NUM_WINDOWS);

        if (window == 0 || (window == 1 && category == 1) || (window == 2 && category == 2)) {
            if (windowCounters[window].get() < ThirdTask.NUM_CUSTOMERS / NUM_WINDOWS) {
                return window;
            }
        }

        return -1;
    }
}