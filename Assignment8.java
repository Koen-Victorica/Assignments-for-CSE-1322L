import java.util.Random;

public class Assignment8 {
    public static void main(String[] args){
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++){
            threads[i] = new Thread(new Guesser());
        }
        for (int i = 0; i < 100; i++){
            threads[i].start();
        }
    }
}
class Guesser implements Runnable{
    public int threadID, guess = 0, guesses = 0;
    public static int nextThreadID = 0;
    Random ran = new Random();
    Guesser(){
        threadID = nextThreadID++;
    }
    @Override
    public void run() {
        do{
           guess = ran.nextInt(1000000);
           guesses++;
        } while (guess != 123456);
        System.out.println("I’m thread " + threadID + ", I just found the number on guess " + guesses);
    }
}