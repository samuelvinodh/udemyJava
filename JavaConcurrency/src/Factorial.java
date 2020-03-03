import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputs = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L, 10000000L);
        List<FactorialThread> factorialThreads = new ArrayList<>(inputs.size());
        for(Long l: inputs){
            factorialThreads.add(new FactorialThread(l));
        }
        for(Thread t: factorialThreads){
            t.setDaemon(true);
            t.start();
        }
        for(Thread t:factorialThreads){
            t.join(2000); //Join waits until the thread completes
        }
        for(int i=0; i<inputs.size(); i++){
            FactorialThread factorialThread = factorialThreads.get(i);
            if(factorialThread.isFinished()){
                System.out.println("Factorial of '"+inputs.get(i)+"' is '"+factorialThread.getResult()+"'");
            } else {
                System.out.println("Calculation of '"+inputs.get(i)+"' is in progress");
            }
        }
    }
}
class FactorialThread extends Thread{
    private long input;
    private BigInteger result = BigInteger.ZERO;
    private boolean finished = false;

    public FactorialThread(long input){
        this.input = input;
    }

    @Override
    public void run(){
        this.result = calcFactorial(input);
        this.finished = true;
    }

    public BigInteger calcFactorial(long input){
        BigInteger tempResult = BigInteger.ONE;
        for(long i=input; i>0; i--){
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return finished;
    }
}