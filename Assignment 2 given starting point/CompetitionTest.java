import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The starting point for a test class.
 * Currently, it simply provides a fixture
 * to help with development.
 *
 * @author  David J. Barnes
 * @version 2018.11.07
 */
public class CompetitionTest
{
    // The competition object.
    private Competition competition;
    // A sample of three personalities details.
    private Personality personal1;
    private Personality personal2;
    private Personality personal3;

    /**
     * Default constructor for test class PersonalityListTest
     */
    public CompetitionTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     * Create a new Competition and Personalities to go in it.
     * The Personalities are not added to the list.
     */
    @Before
    public void setUp()
    {
        competition = new Competition();
        personal1 = new Personality("Moeen Ali", "Cricket");
        personal2 = new Personality("Lewis Hamilton", "F1");
        personal3 = new Personality("Sarah Hunter", "Rugby");
        personal2.increaseVotes(100);
        personal3.increaseVotes(98);
        personal1.increaseVotes(50);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

}






