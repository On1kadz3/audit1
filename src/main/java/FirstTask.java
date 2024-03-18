
public class FirstTask {
    public static void main(String[] args) {
        // Задание 1
        OwnRunnable runnable1 = new OwnRunnable();
        OwnRunnable runnable2 = new OwnRunnable();
        OwnRunnable runnable3 = new OwnRunnable();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
