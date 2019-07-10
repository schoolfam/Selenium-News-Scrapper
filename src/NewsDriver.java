import java.util.Timer;

public class NewsDriver {
    public static void main(String[] args) throws InterruptedException {
        Timer timer =  new Timer();
        while (true) {
            Thread.sleep(10000);
            timer.schedule(new MyTimerTask(), 3000);
        }
    }
}
