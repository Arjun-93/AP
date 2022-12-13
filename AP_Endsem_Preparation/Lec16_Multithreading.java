package AP_Endsem_Preparation;


/*
Threading is Used to maximize the CPU utilization.
There are two ways to create a thread in java
1. By extending Thread class
2. By implementing Runnable interface
 */
public class Lec16_Multithreading {
    public static void main(String[] args) throws InterruptedException {
        Runnable1 r1 = new Runnable1();
        Thread tr1 = new Thread(r1);

        Runnable r2 = new Runnable2();
        Thread tr2 = new Thread(r2);

        tr1.start();
        tr2.start();

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
        t1.join();
        t2.setPriority(1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t1.setName("MyCookingThread");
        t2.setName("MyChattingThread");
    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        int i =0;
        while (i<100){
            System.out.println("This Thread is Cooking");
            i++;
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run(){
        int i =0;
        while (i<100){
            System.out.println("This Thread is chatting with Her");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}

class Runnable1 implements  Runnable{
    public void run(){
        int i =0;
        while (i<100){
            System.out.println("This  is Runnable thread1 for cooking");
            i++;
        }
    }
}

class Runnable2 implements  Runnable{
    public void run(){
        int i =0;
        while (i<100){
            System.out.println("This  is Runnable thread1 for Chatting");
            i++;
        }
    }
}
