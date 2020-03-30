import org.junit.Assert;
import org.junit.Test;

/**
 * Test Hoover methods.
 *
 * @author Clément Bousquet
 */

public class HooverTest {

    @Test
    public void hooverOperation(){
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover1.txt");
        Environment env = new Environment(maze);
        Hoover hoover = new Hoover(env);

        Assert.assertNotNull(hoover);
        Assert.assertNotNull(hoover.getLocation());
        Assert.assertTrue(hoover.getEnv().getGlobal().containsKey(hoover.getLocation()));
        Assert.assertEquals(hoover.getEnv().getGlobal().get(hoover.getLocation())," ");
        hoover.goTo(new Coordinate(1,1));
        Assert.assertEquals(hoover.getLocation(),new Coordinate(1,1));
        Assert.assertEquals(hoover.down(),new Coordinate(2,1));
        Assert.assertEquals(hoover.top(),new Coordinate(0,1));
        Assert.assertEquals(hoover.right(),new Coordinate(1,2));
        Assert.assertEquals(hoover.left(),new Coordinate(1,0));
        Assert.assertEquals(hoover.checkUnvisited().size(),1);
        Assert.assertTrue(hoover.checkUnvisited().contains(new Coordinate(2,1)));
        Assert.assertEquals(hoover.checkAvailable().size(),1);
        Assert.assertTrue(hoover.checkAvailable().contains(new Coordinate(2,1)));
    }

    @Test
    public void hooverOperationOnlyWalls() {
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover2.txt");
        Environment env = new Environment(maze);
        Hoover hoover = new Hoover(env);
        hoover.cleanEnvironement();

        Assert.assertTrue(hoover.getEnv().getToClean().isEmpty());
    }

    @Test
    public void clean() {
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover1.txt");
        Environment env = new Environment(maze);
        Hoover hoover = new Hoover(env);
        hoover.cleanEnvironement();

        Assert.assertTrue(hoover.getEnv().getToClean().isEmpty());
    }

}
