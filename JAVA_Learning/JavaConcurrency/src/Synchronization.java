public class Synchronization {

    public static int counter = 0;
    public static void main(String[] args) {

        Counter c = new Counter();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                c.increment();

            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                c.decrement();
                c.value();

            }
        });

        A.start();
        B.start();



    }
}

class Counter {
    public int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public void value() {
        System.out.println(c);;
    }
}