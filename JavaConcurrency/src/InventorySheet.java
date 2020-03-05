public class InventorySheet {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);
        incrementingThread.start();
        //System.out.println("We currently have "+inventoryCounter.getItems()+" items.");
        decrementingThread.start();
        incrementingThread.join();
        decrementingThread.join();
        System.out.println("We currently have "+inventoryCounter.getItems()+" items.");
    }

    private static class IncrementingThread extends Thread{
        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run(){
            for(int i=0; i<10000; i++){
                inventoryCounter.increment();
            }
        }
    }

    private static class DecrementingThread extends Thread{
        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run(){
            for(int i=0; i<10000; i++){
                inventoryCounter.decrement();
            }
        }
    }

    private static class InventoryCounter{
        private int items = 0;
        Object lock = new Object();
        //public synchronized int getItems() {
        public int getItems(){
            synchronized (lock) {
                return items;
            }
        }

        //public synchronized void increment(){
        public void increment(){
            synchronized (lock) {
                items++;
            }
        }
        //public synchronized void decrement(){
        public void decrement(){
            synchronized (lock) {
                items--;
            }
        }
    }
}
