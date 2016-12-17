/**
 * Created by Dell on 17/12/2016.
 */
public class Program {
    public static void main(String[] args){
        MonkeyPilot monkeyPilot = new MonkeyPilot();
        Thread thread = new Thread(monkeyPilot);
        thread.start();
    }
}
