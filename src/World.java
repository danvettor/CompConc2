import java.util.ArrayList;

/**
 * Created by danilo on 06/07/2015.
 */
public class World {
    private int[][] matrix;
    private int line, collumn;
    private Passenger[] passengers;
    private Taxi[] taxis;
    public World(int matrixSize[], Passenger[] passengers , Taxi[] taxis)
    {
        this.line = matrixSize[0];
        this.collumn = matrixSize[1];
        this.passengers = passengers;
        this.taxis = taxis;
        matrix = new int[this.line][this.collumn];
        populateMatrix();
    }

    public void populateMatrix()
    {
        for (int i = 0; i < this.line; i++) {
            for (int j = 0; j < this.collumn; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }
    public void printMatrix()
    {
        System.out.println("Printando a matriz com zeros");
        for (int i = 0; i < this.line; i++) {
            for (int j = 0; j < this.collumn; j++) {
              System.out.print(this.matrix[i][j]);
            }
            System.out.println();

        }

    }



}
