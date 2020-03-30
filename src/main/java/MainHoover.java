/**
 *
 * @author Clément Bousquet
 */

public class MainHoover {

    public static void main (String [] args) {
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover1.txt");
        Environment env = new Environment(maze);
        Hoover h = new Hoover(env);
        h.cleanEnvironement();
    }
}
