package bowlinggame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Kai Hempel
 */
public class GameTest {

    private Game g;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        g = new Game();
    }

    @After
    public void tearDown() {
    }

    /**
     * Roll test method
     */
    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            g.roll(pins);
        }
    }

    /**
     * Rolls a spare, all pins down with two rolls
     */
    private void rollSpare() {
        g.roll(5);
        g.roll(5); // This is the spare
    }

    /**
     * Rolls a spare, all pins down with two rolls
     */
    private void rollStrike() {
        g.roll(10);
    }

    /**
     * Test all rolls with zero pins
     */
    @Test
    public void testGutterGame() {

        rollMany(20, 0);

        assertEquals(0, g.score());
    }

    /**
     * Test all rolls with one pin
     */
    @Test
    public void testAllOne() {

        rollMany(20, 1);

        assertEquals(20, g.score());
    }

    /**
     * Test spare roll
     */
    @Test
    public void testOneSpare() {
        rollSpare();
        g.roll(3); // Bonus roll
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    /**
     * Test strike roll
     */
    @Test
    public void testOneStrike() {
        rollStrike();
        g.roll(3); // Bonus roll
        g.roll(4); // Bonus roll
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    /**
     * Test all strikes
     */
    @Test
    public void testPerfectGame() {
        rollMany(20, 10);
        assertEquals(300, g.score());
    }
}
