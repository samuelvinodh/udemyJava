import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Vault{
    private int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int guess){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password == guess;
    }
}

abstract class HackerThread extends Thread{
    protected Vault vault;
    public HackerThread(Vault vault){
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void start(){
        System.out.println("Starting thread: "+this.getName());
        super.start();
    }
}

class AscendingHackerThread extends HackerThread{

    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run(){
        for(int guess=0; guess < 9999; guess++){
            if(vault.isCorrectPassword(guess)){
                System.out.println(this.getName()+ " guessed the password "+guess);
                System.exit(0);
            }
        }
    }
}

class DescendingHackerThread extends HackerThread{

    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run(){
        for(int guess =9999; guess >=0;guess--){
            if(vault.isCorrectPassword(guess)){
                System.out.println(this.getName()+" guessed the password "+guess);
                System.exit(0);
            }
        }
    }
}

class PoliceThread extends Thread{
    @Override
    public void run(){
        for(int i=10; i>0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Game over for hackers");
        System.exit(0);
    }
}

public class BankPassword {
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(9999));
        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());
        for(Thread t : threadList){
            t.start();
        }
    }
}
