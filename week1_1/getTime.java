package week1_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getTime {
    private static final DateFormat sdf = new SimpleDateFormat("MM");

    public static String outMonth(){
        Calendar cal = Calendar.getInstance();
        String month = sdf.format(cal.getTime());
        return month;
    }

    public static String outTime(){
        DateFormat df = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
        Calendar cal2 = Calendar.getInstance();
        String time = df.format(cal2.getTime());
        return time;
    }
}