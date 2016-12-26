/**
 * Created by Dell on 17/12/2016.
 */
public class Program {
    public static void main(String[] args){
        Pilot pilot = new Pilot();
        Thread thread = new Thread(pilot);
        thread.start();
    }
}
