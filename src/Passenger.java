import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class Passenger extends Thread {
    public int id;
    public Monitor m;
    public int[] initialPosition, destinationPosition;
    public int taxiChosenID;
    public Passenger(int id, Monitor m, int[] initialPosition, int[] destinationPosition)
    {
        this.id = id;
        this.m = m;
        this.initialPosition = initialPosition;
        this.destinationPosition = destinationPosition;
    }

    public void run()
    {
        for(int i = 0; i < Main.P; i++)
        {
            double j=777777777.7;
            //PRIMEIRO ESCOLHO O ID DO TAXI E DEPOIS INICIALIZO A FUNCAO USANDO O ID QUE EU RETORNEI
            this.taxiChosenID = this.m.chooseTaxi(this.id, this.initialPosition);
            this.m.getTaxi(this.id, this.taxiChosenID, this.initialPosition);

            for (i = 0; i < 100000000; i++) {j=j/2;}// for pra ganhar tempo

            this.m.leaveTaxi(this.id, this.taxiChosenID, this.destinationPosition);

            //sleep bobao
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
