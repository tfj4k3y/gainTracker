package com.example.gaintracker;

import java.util.Calendar;

public class DateHelper {

    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

    String[] dayOfWeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String dayName = dayOfWeekNames[dayOfWeek - 1];

}
