public class PeriodicPrinter implements Runnable{
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(30000);
                System.out.println("I'm still alive!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}