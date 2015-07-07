import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class Monitor {

    private Passenger[] passengerWaitingList, passengerArrivedList;
    private Taxi[] taxiList;
    private int passengerCount;

    public Monitor(int passengerListSize, Taxi[] taxiList){
        this.passengerWaitingList = new Passenger[passengerListSize];
        this.passengerArrivedList = new Passenger[passengerListSize];
        this.passengerCount = passengerListSize;
        this.taxiList = taxiList;
    }


    public Passenger[] getArrivedPassengerList() {
        return passengerArrivedList;
    }

    public Passenger[] getPassengerList() {
        return passengerWaitingList;
    }

    public Taxi[] getTaxiList() {
        return taxiList;
    }

    public synchronized Passenger getNearestPassenger(Taxi taxi)
    {
        int line = taxi.getX();
        int column = taxi.getY();
        int shortestPath = 100000;
        Passenger nearest = null;
        for (Passenger passenger : passengerWaitingList)
        {
            int sum;
            if(passenger != null)
            {
                sum = Math.abs(line - passenger.getInitialX()) + Math.abs(column - passenger.getInitialY());
                if (sum < shortestPath && !passenger.getBusy())
                {
                    shortestPath = sum;
                    nearest = passenger;
                    nearest.setBusy(true);
                    nearest.setDelay(sum*1000);
                }
            }
        }
        return nearest;
    }
    public synchronized void transportNearestPassenger(Taxi taxi, Passenger passenger)
    {
        System.out.println("Taxi " + taxi.getID() + " transportando o passageiro "+ passenger.getID());
        System.out.println("Taxi " + taxi.getID() + " ocupado");
        taxi.setPosition(passenger.getDestinationX(), passenger.getDestinationY());
        passenger.setPosition(passenger.getDestinationX(), passenger.getDestinationY());
    }

    public synchronized void leavePassenger(Taxi taxi, Passenger passenger)
    {
        System.out.println("Taxi " + taxi.getID() + " deixando o passageiro "+ passenger.getID());
        System.out.println("Taxi " + taxi.getID() + " livre e esperando nova chamada");
        passenger.setBusy(false);
        passengerArrivedList[passenger.getID()] = passenger;
        passengerWaitingList[passenger.getID()] =  null;
        passengerCount--;
    }

    public synchronized void enterPassenger(Passenger passenger) {
        passengerWaitingList[passenger.getID()] = passenger;
        passenger.start();
    }

    public synchronized boolean hasPassengerLeft() {
        return (passengerCount > 0);
    }

    public void output()
    {
        try{
            for(Taxi taxi: taxiList)
            {
                taxi.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Posicoes finais dos taxistas:");
        System.out.println();

        for(Taxi taxi: taxiList)
        {
            System.out.println(taxi.getX() + " " + taxi.getY());
        }
    }
}

