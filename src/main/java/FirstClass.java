import java.util.concurrent.CopyOnWriteArrayList;

class FirstClass implements Runnable{
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public FirstClass(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Чтение: " + listOfNumbers);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}