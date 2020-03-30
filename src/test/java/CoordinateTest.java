import org.junit.Assert;
import org.junit.Test;

/**
 * Test Coordinate methods.
 *
 * @author Clément Bousquet
 */

public class CoordinateTest {

    @Test
    public void to_String(){
        Coordinate coord = new Coordinate(1,1);
        Assert.assertEquals("[1,1]",coord.toString());
    }

    @Test
    public void equals(){
        Coordinate coord = new Coordinate(1,1);
        Coordinate coord2 = new Coordinate(1,1);
        Coordinate coord3 = new Coordinate(2,2);
        Assert.assertEquals(coord,coord2);
        Assert.assertNotSame(coord,coord3);
    }


}
