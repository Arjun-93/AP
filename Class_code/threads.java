
public class threads{
    public static void main(String[] args) throws InterruptedException {
        // thread1 t1 = new thread1();
        // t1.start();

        // thread2 t2 = new thread2();
        // t2.start();

        // // Runnable class
        runnable1 r1 = new runnable1();
        runnable2 r2 = new runnable2();

        // Thread t1 = new Thread(r1);
        // Thread t2 = new Thread(r2);
        // t1.start();
        // t2.start();
        // Thread.getThread.getname()
        // thread3 t3  = new thread3(r1, "name");
        // t3.start();

        Thread th = new Thread(r1,"newThread");
        th.start();
        Thread t3 = new Thread(r1, "th11");
        Thread t4 = new Thread(r2, "th22");
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t3.start();
        t3.join();
        System.out.println("Hi");
        t4.start();

    }
}

class thread1 extends Thread{
    thread1(String name){
        super(name);
    }

    @Override
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println("11111");
            i++;
            
        }
    }
}

class thread2 extends Thread{

    thread2(String name){
        super(name);
    }
    @Override
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println("22222");
            i++;        }
    }
}

class runnable1 implements Runnable{
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println(Thread.currentThread().getName());
            i++;
        }
    }
}

class runnable2 implements Runnable{
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println(Thread.currentThread().getName());
            i++;
            // try{
            //     Thread.sleep(1000);
            // }
            // catch {
                
            // }
        }
    }
}