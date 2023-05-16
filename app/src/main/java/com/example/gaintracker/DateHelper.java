package com.example.gaintracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    static String getDayOfTheWeek(){

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String[] dayOfWeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        return dayOfWeekNames[dayOfWeek - 1];
    }

    static String getDate(){
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-RRRR", Locale.getDefault());

        return date.format(c);
    }



}
