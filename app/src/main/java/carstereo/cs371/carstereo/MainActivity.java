package carstereo.cs371.carstereo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.Vibrator;


public class MainActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener {

    protected ToggleButton onOff;
    protected TextClock clock;
    protected TextView track;
    protected TextView TrackNumber;
    protected SeekBar volumeBar;
    protected SeekBar tunerBar;
    protected TextView stationDisp;
    protected Switch AmFm;
    protected Button preset1;
    protected Button preset2;
    protected Button preset3;
    protected Button preset4;
    protected Button preset5;

    protected int userSet1;
    protected int userSet2;
    protected int userSet3;
    protected int userSet4;
    protected int userSet5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onOff = (ToggleButton) findViewById(R.id.onoffSwitch);
        onOff.setOnClickListener(this);

        clock = (TextClock) findViewById(R.id.digClock);

        track = (TextView) findViewById(R.id.trackDisplay);

        TrackNumber = (TextView) findViewById(R.id.trackNumber);

        volumeBar = (SeekBar) findViewById(R.id.volumeControl);

        tunerBar = (SeekBar) findViewById(R.id.tunerControl);
        tunerBar.setOnSeekBarChangeListener(this);

        stationDisp = (TextView) findViewById(R.id.stationView);

        AmFm = (Switch) findViewById(R.id.amfm);
        AmFm.setOnCheckedChangeListener(this);

        preset1 = (Button)findViewById(R.id.preset1);
        preset1.setOnClickListener(this);

        preset2 = (Button)findViewById(R.id.preset2);
        preset2.setOnClickListener(this);

        preset3 = (Button)findViewById(R.id.preset3);
        preset3.setOnClickListener(this);

        preset4 = (Button)findViewById(R.id.preset4);
        preset4.setOnClickListener(this);

        preset5 = (Button)findViewById(R.id.preset5);
        preset5.setOnClickListener(this);

        userSet1=0;
        userSet2=0;
        userSet3=0;
        userSet4=0;
        userSet5=0;



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.onoffSwitch) {
            this.powerButton(v);
        } else {
            changePresets(v);
        }
    }

    public void powerButton(View v) {
        CharSequence currentState = this.onOff.getText();
        if (currentState.equals(this.onOff.getTextOff())) {
            this.clock.setTextColor(Color.BLACK);
            this.track.setTextColor(Color.BLACK);
            this.TrackNumber.setTextColor(Color.BLACK);
            this.tunerBar.setProgress(0);
            this.volumeBar.setProgress(0);
            this.tunerBar.setEnabled(false);
            this.volumeBar.setEnabled(false);
            this.AmFm.setClickable(false);
            this.preset1.setClickable(false);
            this.preset2.setClickable(false);
            this.preset3.setClickable(false);
            this.preset4.setClickable(false);
            this.preset5.setClickable(false);


        } else {
            this.clock.setTextColor(Color.GREEN);
            this.track.setTextColor(Color.GREEN);
            this.TrackNumber.setTextColor(Color.GREEN);
            this.tunerBar.setEnabled(true);
            this.volumeBar.setEnabled(true);
            this.AmFm.setClickable(true);
            this.preset1.setClickable(true);
            this.preset2.setClickable(true);
            this.preset3.setClickable(true);
            this.preset4.setClickable(true);
            this.preset5.setClickable(true);

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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            if (!this.AmFm.isChecked()) {
                setRadioText(progress, 117);
            } else {
                setRadioText(progress,99);
            }
        }
    }

    public void setRadioText(int progress, int max){
        if (max==117)
        {
            this.tunerBar.setMax(max);
            int station = (progress*10)+530;
            String display = station+" kHZ AM";
            this.stationDisp.setText(display);
        }
        else
        {
            this.tunerBar.setMax(max);
            double station = ((progress * 2) + 881);
            double display = station / 10;
            String newStation = display + " MHz FM";
            this.stationDisp.setText(newStation);
        }
    }



    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            setRadioText(this.tunerBar.getProgress(), 99);
        }
        else
        {
            setRadioText(this.tunerBar.getProgress(),117);
        }
    }

    public void changePresets(View v)
    {
        if (!this.AmFm.isChecked()) {
            int am = 117;
            if (v.getId() == R.id.preset1) {
                setRadioText(2,am);
            }

            else if (v.getId()==R.id.preset2)
            {
                setRadioText(7, am);
            }

            else if (v.getId()==R.id.preset3)
            {
                setRadioText(12,am);
            }

            else if (v.getId()==R.id.preset4)
            {
                setRadioText(17, am);
            }

            else
            {
                setRadioText(22, am);
            }
        }

        else
        {
            int am = 99;
            if (v.getId() == R.id.preset1) {
                setRadioText(14,am);
            }

            else if (v.getId()==R.id.preset2)
            {
                setRadioText(24, am);
            }

            else if (v.getId()==R.id.preset3)
            {
                setRadioText(34,am);
            }

            else if (v.getId()==R.id.preset4)
            {
                setRadioText(44, am);
            }

            else
            {
                setRadioText(54, am);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}


