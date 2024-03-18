import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThirdTask implements Runnable{
    public static final int NUM_CATEGORIES = 3;
    public static final int NUM_CUSTOMERS = 1000;

    @Override
    public void run(){
        for (int i = 0; i < NUM_CUSTOMERS; i++) {

            int category = Third1Class.getRandomCategory();
            int window = Third1Class.getRandomWindow(category);

            if (window != -1) {
                Third1Class.windowCounters[window].incrementAndGet();
                Third1Class.categoryCounters[category].incrementAndGet();
            } else {
                Third1Class.abandonedCounters[category].incrementAndGet();
            }
        }

        for (int i = 0; i < NUM_CATEGORIES; i++) {
            int categoryCounter = Third1Class.categoryCounters[i].get();
            int abandonedCounter = Third1Class.abandonedCounters[i].get();
            double abandonmentRate = (double) abandonedCounter / (categoryCounter + abandonedCounter) * 100;
            System.out.printf("Категория %d: Процент ушедших клиентов: %.2f%%\n", i+1, abandonmentRate);
        }
    }
}