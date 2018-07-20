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

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 =  new CountdownThread(countdown);
        t1.setName("Thread 1 ");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2 ");

        t1.start();
        t2.start();
    }
}

class Countdown {
    public void do_countdown(){
        String  color ;
        int i;
        switch (Thread.currentThread().getName()){
            case "Thread 1 ":
               color = ThreadColor.ANSI_CYAN;
               break;
            case "Thread 2 " :
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        synchronized(this){
        for (i = 0; i< 10; i++ ){
            System.out.println(color + Thread.currentThread().getName() +" i:" + i);
          }
        }
    }
}


class CountdownThread  extends Thread{
    private Countdown threadcountdown ;

    public CountdownThread (Countdown countdown){
        threadcountdown = countdown;
    }
    public void run (){
        threadcountdown.do_countdown();
    }
}

