/**
 * Created by danilo on 06/07/2015.
 */
public class Passenger extends Thread {

    private int id, delay;
    private Monitor monitor;
    private int[] currentPosition, destinationPosition;
    private boolean busy;

    public Passenger(int id, int[] currentPosition, int[] destinationPosition)
    {
        this.id = id;
        this.currentPosition = currentPosition;
        this.destinationPosition = destinationPosition;
        this.busy = false;
    }

    public int getInitialX()
    {
        return currentPosition[0];
    }

    public int getInitialY()
    {
        return currentPosition[1];
    }

    public int getDestinationY()
    {
        return destinationPosition[0];
    }

    public int getDestinationX()
    {
        return destinationPosition[0];
    }
    public int getID()
    {
        return this.id;
    }
    public void setPosition(int x, int y)
    {
        this.currentPosition[0] = x;
        this.currentPosition[1] = y;
    }

    public boolean getBusy(){
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
