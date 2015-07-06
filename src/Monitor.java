import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class Monitor {
    public int numTaxis, numPassenger, taxiWaiting, passengerWaiting;
    public Taxi[] taxiList;


    public Monitor(int numTaxis, int numPassenger, Taxi[] taxiList){
        this.numTaxis = numTaxis;
        this.numPassenger = numPassenger;
        this.taxiWaiting = 0;
        this.passengerWaiting = 0;
        this.taxiList = taxiList;

    }

    public synchronized int chooseTaxi(int passengerID, int[] passengerInitialPosition)
    {
        int index, shortestPath, x, y, pathSum;
        index = 0;
        shortestPath = 10000000;
       //TESTA SE HÁ TAXI DISPONIVEL
        try {
            while (numTaxis <= 0) {
                System.out.println("Passageiro " + passengerID + " esta esperando");
                this.passengerWaiting++;
                System.out.println("Existem " + this.passengerWaiting + " passageiros esperando");
                wait();
                this.passengerWaiting--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //CASO HAJA BUSCA O DE MENOR CAMINHO
        for( Taxi taxi : taxiList)
        {
            x = Math.abs(passengerInitialPosition[0] - taxi.position[0]);
            y = Math.abs(passengerInitialPosition[1] - taxi.position[1]);
            pathSum = x+y;
            if(pathSum < shortestPath){
                shortestPath = pathSum;
                index = taxi.id;
            }
        }
        return index;

    }
    public synchronized void getTaxi(int passengerID, int taxiID, int[] passengerInitialPosition)
    {
        //TODO Colocar uma condicao que bloqueie alguem tentando pegar um taxi ocupado
        numTaxis--;
        System.out.println("Taxi " + taxiID + " na posicao "+ "( " + this.taxiList[taxiID].position[0] +", " + this.taxiList[taxiID].position[1] + " )");

        this.taxiList[taxiID].position = passengerInitialPosition;
        System.out.println("Passageiro " + passengerID + " pegou o taxi " + taxiID + " na posicao "+ "( " + this.taxiList[taxiID].position[0] +", " + this.taxiList[taxiID].position[1] + " )");
        System.out.println("Existem " + this.numTaxis + " taxis disponiveis");



    }
    public synchronized void leaveTaxi(int passengerID, int taxiID, int[] passengerDestinationPosition)
    {
        this.taxiList[taxiID].position = passengerDestinationPosition;
        System.out.println("Passageiro " + passengerID + " deixou o taxi " + taxiID +" na posicao : " + "( " + this.taxiList[taxiID].position[0] +", " + this.taxiList[taxiID].position[1] + " )" );
        numTaxis++;
        notifyAll();;
        System.out.println("Existem " + this.numTaxis + " disponiveis");

    }

}

