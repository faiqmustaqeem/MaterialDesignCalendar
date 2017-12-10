package com.example.faiq.materialdesigncalendar;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnDateSelectedListener {
    Date startDate;
    Date endDate;
    MaterialCalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar=(MaterialCalendarView)findViewById(R.id.calendar);

        Calendar c=Calendar.getInstance();
        c.setTime(new Date());
        String startDateString = (c.get(Calendar.MONTH)+1)+"/"+c.getActualMinimum(Calendar.DATE)+"/"+c.get(Calendar.YEAR);

        Date date =new Date();
        c.setTime(date);
        c.add(Calendar.YEAR,1);
        date=c.getTime();

        String endDateString = (c.get(Calendar.MONTH)+1)+"/"+c.getActualMaximum(Calendar.DATE)+"/"+c.get(Calendar.YEAR);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            startDate = df.parse(startDateString);
            endDate=df.parse(endDateString);
         //   String newDateString = df.format(startDate);
          //  System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

Log.e("date start",startDate.toString());
        Log.e("date end",endDate.toString());

        calendar.state().edit()
               .setMinimumDate(startDate)
               .setMaximumDate(endDate)
               .commit();
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        Toast.makeText(this,date.toString(),Toast.LENGTH_SHORT).show();
    }
}
