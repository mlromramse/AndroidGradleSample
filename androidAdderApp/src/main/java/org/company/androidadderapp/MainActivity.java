package org.company.androidadderapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Above was present after the project was created. */

        /* I get hold of the button to add a listener to it. */
        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Here I get the two, by the user, entered values */
                EditText value1 = (EditText) findViewById(R.id.value1_et);
                EditText value2 = (EditText) findViewById(R.id.value2_et);
                float float1 = Float.parseFloat(value1.getText().toString());
                float float2 = Float.parseFloat(value2.getText().toString());

                /* Sum the values together */
                float result = sumFloats(float1, float2);

                /* Place the result in the sumText widget */
                TextView resultTextView = (TextView) findViewById(R.id.sumText);
                resultTextView.setText(String.format(getString(R.string.result_format), float1, float2, result));
            }
        });
    }

    public float sumFloats(float value1, float value2) {
        return value1 + value2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
