import java.util.Random;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Message message =  new Message();
        new Thread(new writer(message)).start();
        new Thread(new reader(message)).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read (){
        while (empty){
                try {
                    wait();
                }catch (InterruptedException e){

                }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write (String message){
        while(!empty){
            try {
                wait();
            }catch (InterruptedException e){

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class writer implements Runnable {
    private Message message1;

    public writer(Message message) {
        this.message1= message;
    }

    @Override
    public void run() {

        String message [] = {
                "Hello ",
                "World ",
                "JDK",
        };

        Random random =  new Random();

        for (int i= 0 ; i < message.length;i++){
            message1.write(message[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch  (InterruptedException e) {

            }
        }

       message1.write("Finished");
    }
}


class reader implements Runnable{
    private Message message;

    public reader (Message message){
        this.message = message;
    }

    public void run () {
        Random random =  new Random();
        for (String lastmessage  =  message.read();!lastmessage.equals("Finished");
                lastmessage = message.read()){
            System.out.println(lastmessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }

    }
}


