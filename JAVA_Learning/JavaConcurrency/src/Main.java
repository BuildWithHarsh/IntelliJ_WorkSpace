public class Main {
    public static void main(String[] args) {

        //System.out.println(ThreadColor.ANSI_PURPLE+"Hello from main Thread! =====" + Thread.currentThread().getName());
//        Thread anotherThread = new AnotherThread();
//        anotherThread.setName("Another Thread");
//        anotherThread.start();
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println(ThreadColor.ANSI_GREEN + "Hello from anonymous thread");
//            }
//        }.start();
//        Thread myRunnableThread = new Thread(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println(ThreadColor.ANSI_CYAN + "Hello from anonymous class implementation of myRunnable");
//                try {
//                    anotherThread.join();
//                    System.out.println("Another thread terminated or timed out");
//                } catch (InterruptedException e) {
//                    System.out.println("I was interrupted");
//                }
//            }
//        });
//        myRunnableThread.start();
//        myRunnableThread.isInterrupted();
//        myRunnableThread.interrupted();
//
//        anotherThread.interrupt();
//        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( ThreadColor.ANSI_RED + "I am the thread other than t2 thread");
                try {
                    Thread.sleep(10000);
                }catch(InterruptedException e){
                    System.out.println("I was sleep and I was interrupted because of slepp method overloading");
                    return;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    t1.join();
                    System.out.println("I am the t2 thread");
                }catch (InterruptedException e){
                    System.out.println("Thread was interrupted");
                }

            }
        });
        t1.start();
        t2.start();




    }
}