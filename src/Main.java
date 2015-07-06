import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class Main {

    static final int P = 1;
    static final int T = 1;
    public static void main(String[] args)
    {
        int i;
        Passenger[] passengers = new Passenger[P];
        Taxi[] taxis = new Taxi[T];

        //SAO NECESSARIAS SOH POR AGORA
      /*  int[] matrixSize = new int[2];
        matrixSize[0] = 5; matrixSize[1] = 8;

        World matrixWorld = new World(matrixSize, p, t);
        matrixWorld.printMatrix();*/


        //COLOQUEI ISSO DAQUI SOH PARA PODER CONSTRUIR OS TAXISTAS
        int[] initialTaxiPositionTemp = new int[2];
        int[] destinationPositionTemp = new int[2];
        int[] initialPositionTemp = new int[2];



        for (i = 0; i < T; i++) {
            initialTaxiPositionTemp[0] = 3;
            initialTaxiPositionTemp[1] = 5;
            taxis[i] = new Taxi(i, initialPositionTemp);
        }

        Monitor monitor = new Monitor(T, P, taxis);


       /* for (i = 0; i < T; i++) {
           taxis[i].start();
        }*/
        for (i = 0; i < P; i++)
        {
            initialPositionTemp[0] = 1;
            initialPositionTemp[1] = 2;
            destinationPositionTemp[0] = 4;
            destinationPositionTemp[1] = 3;
            passengers[i] = new Passenger(i, monitor, initialPositionTemp, initialPositionTemp);
            passengers[i].start();

        }
    }
}
