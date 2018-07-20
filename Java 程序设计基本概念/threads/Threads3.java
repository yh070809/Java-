import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Main {

    public static final String EOF =  "EOF";
    public static void main(String[] args) {
        List<String> buffer =  new ArrayList<String>();
        MyProducer producer1 = new MyProducer(buffer,ThreadColor.ANSI_GREEN);
        MyConsumer consumer1 =  new MyConsumer(buffer,ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer,ThreadColor.ANSI_BLUE);

        new Thread(producer1).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String [] nums = {"1","2","3","4","5"};

        for (String num : nums) {
            try {
                System.out.println(color+" Add ..." + num);
                synchronized (buffer){
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("Producer intertuputed");
            }
        }
        System.out.println(color + " Adding EOF and exiting....");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer){
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(Main.EOF)) {
                    System.out.println(color + " Exiting.....");
                    break;
                } else {
                    System.out.println(color + " Removed " + buffer.remove(0));
                }
            }
        }
    }
}
/**
 *
 */
public class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

}
