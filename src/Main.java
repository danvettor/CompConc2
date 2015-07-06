import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class Main {

    static final int P = 5;
    static final int T = 3;
    public static void main(String[] args)
    {
        int i;
        Passenger[] passengers = new Passenger[P];
        Taxi[] taxis = new Taxi[T];


        int[][] initialTaxiPositionTemp = {
                { 0, 3},
                { 3, 1},
                { 4, 0}
        };

        int[][] initialPositionTemp = {
                {1, 2},
                {1, 2},
                {2, 3},
                {3, 1},
                {3, 0}
        };

        int[][] destinationPosition = {
                { 4, 1},
                {1 ,3},
                {2, 2},
                {3, 3},
                {0, 0}
        };

        for (i = 0; i < T; i++) {
            System.out.print("Posição do taxi " + i + " : ");
            for (int j = 0; j < 2; j++) {
                System.out.print(initialTaxiPositionTemp[i][j] + ", ");
            }
            System.out.println();

        }

        //PARA UM TESTE SIMPLES
   /*     int[] initialTaxiPositionTemp = new int[2];
        int[] destinationPositionTemp = new int[2];
        int[] initialPositionTemp = new int[2];*/



        for (i = 0; i < T; i++) {
            int[] temp = new int[2];
            for (int j = 0; j < 2; j++) {
                temp[j] = initialTaxiPositionTemp[i][j];
            }
            taxis[i] = new Taxi(i, temp);
        }

        Monitor monitor = new Monitor(T, P, taxis);


       /* for (i = 0; i < T; i++) {
           taxis[i].start();
        }/*/
        for (i = 0; i < P; i++)
        {
            int[] temp = new int[2];
            int[] tempDestination = new int[2];
            for (int j = 0; j < 2; j++) {
                temp[j] = initialPositionTemp[i][j];
                tempDestination[j] = destinationPosition[i][j];
            }
            passengers[i] = new Passenger(i, monitor, temp, tempDestination);
            passengers[i].start();

        }
    }
}
