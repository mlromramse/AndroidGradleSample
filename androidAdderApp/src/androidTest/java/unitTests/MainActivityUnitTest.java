package unitTests;

import android.util.Log;

import junit.framework.TestCase;

import org.company.androidadderapp.MainActivity;

/**
 * This class is a plain jUnit test class that runs on the device.
 *
 * @author mlromramse
 * 2014-04-09.
 */
public class MainActivityUnitTest extends TestCase {
    MainActivity mainActivity;

    public void setUp() throws Exception {
        super.setUp();
        mainActivity = new MainActivity();
    }

    public void testAddFloats() {
        Log.i(MainActivityUnitTest.class.getSimpleName(), "Start of testAddFloats.");
        Float value1 = 12.0F;
        Float value2 = 34.0F;
        Float sum = mainActivity.sumFloats(value1, value2);
        Float wantedSum = 46.0F;
        assertEquals(wantedSum, sum);
    }

}
