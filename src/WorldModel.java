import java.util.ArrayList;
import java.util.Timer;

public class WorldModel implements IObserver{

    private int width;
    private int height;
    private ArrayList <IObserver> observers;
    private int delay;
    private Timer timer;



}