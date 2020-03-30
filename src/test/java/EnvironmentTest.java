import org.junit.Assert;
import org.junit.Test;

/**
 * Test Environment methods.
 *
 * @author Clément Bousquet
 */

public class EnvironmentTest {

    @Test
    public void environmentOperation(){
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover1.txt");
        Environment env = new Environment(maze);
        Assert.assertNotNull(env);
        Assert.assertNotNull(env.getGlobal());
        Assert.assertNotNull(env.getToClean());
        Assert.assertTrue(env.getGlobal().containsKey(new Coordinate(0,0)));
        Assert.assertTrue(env.getGlobal().containsKey(new Coordinate(1,1)));
        Assert.assertTrue(env.getGlobal().containsValue(" "));
        Assert.assertTrue(env.getGlobal().containsValue("M"));
        Assert.assertFalse(env.getToClean().containsKey(new Coordinate(0,0)));
        Assert.assertTrue(env.getToClean().containsKey(new Coordinate(1,1)));
        Assert.assertTrue(env.getToClean().containsValue(" "));
        Assert.assertFalse(env.getToClean().containsValue("M"));
    }

    @Test
    public void environmentOperationWithOnlyWalls(){
        MatrixFileReader matrixFileReader = new MatrixFileReader();
        String[][] maze = matrixFileReader.readFile("/hoover2.txt");
        Environment env = new Environment(maze);
        Assert.assertNotNull(env);
        Assert.assertNotNull(env.getGlobal());
        Assert.assertNotNull(env.getToClean());
        Assert.assertFalse(env.getGlobal().isEmpty());
        Assert.assertTrue(env.getToClean().isEmpty());
    }
}
