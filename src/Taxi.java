/**
 * Created by danilo on 06/07/2015.
 */
public class Taxi extends Thread{

    public int id;
    public Monitor m;
    public int position[] = new int[2];


    public Taxi(int id, int[] initialPosition)
    {
        this.id = id;
        this.position = initialPosition;

    }



}
