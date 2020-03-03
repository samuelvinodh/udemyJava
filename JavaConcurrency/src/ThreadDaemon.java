public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingThread());
        thread.start();
        thread.interrupt();
    }
}

class BlockingThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Exiting blocking thread");
        }
    }
}
