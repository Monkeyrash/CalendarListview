package com.andexert.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.andexert.calendarlistview.library.DayPickerView;


public class MainActivity extends Activity implements com.andexert.calendarlistview.library.DatePickerController {

    private DayPickerView dayPickerView;
    Calendar calendar;
    int minYear= 2013; //Setup Ranges
    int maxYear=2020;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         calendar = Calendar.getInstance();
        dayPickerView = (DayPickerView) findViewById(R.id.pickerView);
        dayPickerView.setmController(this);
        //Get difference of current Year and Min year
          int difference = calendar.get(calendar.YEAR)-minYear;
         dayPickerView.setSelection(difference*12);
         //Scroll to it
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

    @Override
    public int getMaxYear()
    {
        return maxYear;
          //maxYear being the year you defined as a variable
    }

    @Override
    public int getMinYear()
    {
        return minYear;
        //minYear being the year you defined as a variable.
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day)
    {
        Log.e("Day Slected", day + " / " + month + " / " + year);
    }
}
