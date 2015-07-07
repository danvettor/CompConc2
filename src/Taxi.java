/**
 * Created by danilo on 06/07/2015.
 */
public class Taxi extends Thread{

    private int id, passengerChosenID;
    private Monitor monitor;
    private int position[] = new int[2];
    private boolean isBusy;



    public Taxi(int id, Monitor m, int[] initialPosition)
    {
        this.id = id;
        this.position = initialPosition;
        isBusy = false;
        this.monitor = m;

    }
    public void run()
    {
        while(monitor.hasPassengerLeft())
        {
            Passenger passenger = monitor.getNearestPassenger(this);
            if(passenger != null){
                monitor.transportNearestPassenger(this, passenger);
                try {
                    sleep(passenger.getDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                monitor.leavePassenger(this, passenger);
            }
        }
    }

    public int getX()
    {
        return position[0];
    }

    public int getY()
    {
        return position[1];
    }

    public void setPosition(int x, int y)
    {
        this.position[0] = x;
        this.position[1] = y;
    }

    public int getID()
    {
        return id;
    }


}
