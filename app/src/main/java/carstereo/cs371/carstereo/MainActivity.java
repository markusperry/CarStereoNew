package carstereo.cs371.carstereo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements View.OnClickListener {

    protected ToggleButton onOff;
    protected TextClock clock;
    protected TextView track;
    protected TextView TrackNumber;
    protected SeekBar volumeBar;
    protected SeekBar tunerBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onOff = (ToggleButton)findViewById(R.id.onoffSwitch);
        onOff.setOnClickListener(this);
        clock = (TextClock)findViewById(R.id.digClock);
        track = (TextView)findViewById(R.id.trackDisplay);
        TrackNumber = (TextView)findViewById(R.id.trackNumber);
        volumeBar = (SeekBar)findViewById(R.id.volumeControl);
        tunerBar = (SeekBar)findViewById(R.id.tunerControl);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onClick(View v)
    {
        this.powerButton(v);
    }

    public void powerButton(View v)
    {
        CharSequence currentState = this.onOff.getText();
        Log.i("sdfhshf", (String) currentState);
        if (currentState.equals(this.onOff.getTextOff())) {
            this.clock.setTextColor(Color.BLACK);
            this.track.setTextColor(Color.BLACK);
            this.TrackNumber.setTextColor(Color.BLACK);
            this.tunerBar.setProgress(0);
            this.volumeBar.setProgress(0);
        }
        else
        {
            this.clock.setTextColor(Color.GREEN);
            this.track.setTextColor(Color.GREEN);
            this.TrackNumber.setTextColor(Color.GREEN);

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
