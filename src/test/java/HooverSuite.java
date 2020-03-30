import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Hoover suite.
 * Run all tests
 *
 * @author Clément Bousquet
 */


@RunWith(Suite.class)
@SuiteClasses({
        MatrixFileReaderTest.class,
        CoordinateTest.class,
        EnvironmentTest.class,
        HooverTest.class
})

public class HooverSuite {

}