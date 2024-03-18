import java.util.concurrent.CopyOnWriteArrayList;

class SecondClass implements Runnable{
    private int counter = 0;
    private CopyOnWriteArrayList<Integer> listOfNumbers;
    public SecondClass(CopyOnWriteArrayList<Integer> listOfNumbers){
        this.listOfNumbers = listOfNumbers;
    }
    @Override
    public void run(){
        while (true){
            synchronized (listOfNumbers) {
                listOfNumbers.add(counter);
            }
            System.out.println("Запись: " + counter);
            counter++;
            try {
                Thread.sleep(750); // 500 мс
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}