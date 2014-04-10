package instrumentationTests;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

import org.company.androidadderapp.MainActivity;
import org.company.androidadderapp.R;

/**
 * This class extends the ActivityInstrumentationTestCase2<T> and makes use of Robotium Solo.
 *
 * @author mlromramse
 * Created 2014-04-09.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    MainActivity mainActivity;
    Solo solo;

    public MainActivityTest() {
        /* This is important. */
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        /* This is also important */
        super.setUp();
        mainActivity = getActivity();
        /* Solo needs to know about both instrumentation and the activity. */
        solo = new Solo(getInstrumentation(), mainActivity);
    }

    public void testAdder() {
        Log.i(MainActivityTest.class.getSimpleName(), "Starting to enter values.");
        solo.enterText((EditText)mainActivity.findViewById(R.id.value1_et), "12.0");
        solo.enterText((EditText)mainActivity.findViewById(R.id.value2_et), "34.0");
        Log.i(MainActivityTest.class.getSimpleName(), "About to click on Add button.");
        solo.clickOnView(mainActivity.findViewById(R.id.add_button));

        Log.i(MainActivityTest.class.getSimpleName(), "Validates result.");
        /* Format the wanted result the same way the app does. */
        String resultFormat = mainActivity.getString(R.string.result_format);
        final String wanted = String.format(resultFormat, 12.0F, 34.0F, 46.0F);

        Log.i(MainActivityTest.class.getSimpleName(), "Wait for the app to calculate the sum and update the UI.");
        boolean endResult = solo.waitForCondition(new Condition() {
            @Override
            public boolean isSatisfied() {
                String actual = ((TextView)mainActivity.findViewById(R.id.sumText)).getText().toString();
                return (actual.equals(wanted));
            }
        }, 5000);

        Log.i(MainActivityTest.class.getSimpleName(), endResult ? "testAdder was successful." : "testAdder failed");

        /* Finally we use the jUnit assertTrue method. */
        assertTrue(endResult);
    }


}
