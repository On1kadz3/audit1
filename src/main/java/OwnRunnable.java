class OwnRunnable implements Runnable {
    @Override
    public void run(){
        long threadId = Thread.currentThread().getId();
        System.out.println("ID потока: " + threadId);
    }
}