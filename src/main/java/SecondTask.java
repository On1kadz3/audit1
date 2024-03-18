import java.util.concurrent.CopyOnWriteArrayList;



public class SecondTask {
    public static void main(String[] args) {

        // Задание 2
        CopyOnWriteArrayList<Integer> lON = new CopyOnWriteArrayList<>();

        FirstClass firstClass = new FirstClass(lON);
        SecondClass secondClass = new SecondClass(lON);
        Thread secondThread = new Thread(secondClass);
        Thread firstThread = new Thread(firstClass);

        secondThread.start();
        firstThread.start();
    }
}
