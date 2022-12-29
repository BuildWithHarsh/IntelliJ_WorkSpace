public class Main {
    public static void main(String[] args) {

        //System.out.println(ThreadColor.ANSI_PURPLE+"Hello from main Thread! =====" + Thread.currentThread().getName());
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another Thread");
        anotherThread.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN+"Hello from anonymous thread");
            }
        }.start();
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_CYAN + "Hello from anonymous class implementation of myRunnable");
                try{
                    anotherThread.join();
                    System.out.println("Another thread terminated or timed out");
                }catch(InterruptedException e){
                    System.out.println("I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        anotherThread.interrupt();
        System.out.println(ThreadColor.ANSI_PURPLE+"Hello again from the main thread");
    }
}