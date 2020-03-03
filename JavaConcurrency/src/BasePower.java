import java.math.BigInteger;

public class BasePower {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000"),new BigInteger("1000000")));
        thread.start();
        //thread.wait(1000);
        thread.interrupt();
    }
}

class LongComputationTask implements Runnable{
    private BigInteger base;
    private BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        System.out.println(base+"^"+power+" = "+power(base,power));
    }

    private BigInteger power(BigInteger base, BigInteger power){
        BigInteger result = BigInteger.ONE;
        for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Prematurely interrupted computation");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        return result;
    }
}