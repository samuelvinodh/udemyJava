public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in thread: "+Thread.currentThread().getName());
                System.out.println("Current thread priority: "+Thread.currentThread().getPriority());
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in thread: "+Thread.currentThread().getName());
                throw new RuntimeException("Intentional Exception");
            }
        });
        thread.setName("New worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" before starting");
        thread.start();
        System.out.println("We are in thread: "+Thread.currentThread().getName()+" after starting");
        //Thread.sleep(1000);
        thread1.setName("Misbehaving thread");
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened '"+t.getName()+"' with error '"+e.getMessage()+"'");
            }
        });
        thread1.start();
    }
}
