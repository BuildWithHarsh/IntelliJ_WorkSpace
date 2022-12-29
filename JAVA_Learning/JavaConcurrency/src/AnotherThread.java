public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE+"Hello from another thread======="+currentThread().getName());
        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            System.out.println("Another thread woke me up");
            return;
        }
        System.out.println("4 Seconds have been elapsed");
    }
}
