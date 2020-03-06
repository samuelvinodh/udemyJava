import java.util.Random;

public class TrainIntersection {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));
        trainAThread.start();
        trainBThread.start();
    }

    private static class TrainA implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intersection.takeRoadA();
            }
        }
    }

    private static class TrainB implements Runnable{
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intersection.takeRoadB();
            }
        }
    }

    private static class Intersection{
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA(){
            synchronized (roadA){
                System.out.println("Road 'A' is blocked by thread: "+Thread.currentThread().getName());
                synchronized (roadB){
                    System.out.println("Train is passing through Road 'A'");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void takeRoadB(){
            synchronized (roadA){
                System.out.println("Road 'A' is blocked by thread: "+Thread.currentThread().getName());
                synchronized (roadB){
                    System.out.println("Train is passing through Road 'B'");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
