package lb.edu.isae.mavenproject2;

/**
 * Pour faire du monitoring avec pause ou jconsole
 * @author Pascal Fares
 */
public class App {
    public static void main(String ...args) throws InterruptedException {
        while (true) {
            System.out.println(".");
            Thread.sleep(100);
        }
    }
}
