package week2_2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {

    private int year;
    private int month;
    private int day;
    private static String[] strMonths = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] strDays = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static int[] commonDaysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] leapDaysInMonths = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    MyDate(int year, int month, int day){
        setDate(year, month, day);
    }
    public static boolean isLeapYear(int year){
        if (year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }else return false;
            }else return true;
        }else return false;
    }

    public static boolean isValidDate(int year, int month, int day){
        if(year >= 1 && year <= 9999){
            if(month >= 1 && month <= 12){
                if(month != 2){
                    if(day >= 1 && day <= commonDaysInMonths[month-1]){
                        return true;
                    }else return false;
                }else {
                    if(!isLeapYear(year)){
                        if(day >= 1 && day <= commonDaysInMonths[month-1]){
                            return true;
                        }else return false;
                    }else {
                        if (day >= 1 && day <= leapDaysInMonths[month-1]){
                            return true;
                        }else return false;
                    }
                }
            }else return false;
        }else return false;
    }

    public static int getDayOfWeek(int year, int month, int day){
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int y = year;
        int q = day;
        int m = month;
        int h = (q + (int)((26 * (m + 1)) / 10.0) + y + (int)(y / 4.0) + 6 * (int)(y / 100.0) + (int)(y / 400.0)) % 7;
        return h;
    }

    public void setDate(int year, int month, int day){
        if(isValidDate(year, month, day)){
            setYear(year);
            setMonth(month);
            setDay(day);
        }else System.out.println("Invalid year, month, or day!");
    }

    public void setYear(int year){
        if(year >= 1 && year <= 9999){
            this.year = year;
        }else System.out.println("Invalid year!");
    }

    public void setMonth(int month){
        if(month >= 1 && month <= 12){
            this.month = month;
        }else System.out.println("Invalid month!");
    }

    public void setDay(int day){
        if(month != 2){
            if(day >= 1 && day <= commonDaysInMonths[month-1]){
                this.day = day;
            }else System.out.println("Invalid day!");
        }else {
            if(!isLeapYear(year)){
                if(day >= 1 && day <= commonDaysInMonths[month-1]){
                    this.day = day;
                }else System.out.println("Invalid day!");
            }else {
                if (day >= 1 && day <= leapDaysInMonths[month-1]){
                    this.day = day;
                }else System.out.println("Invalid day!");
            }
        }
    }

    public int getYear(){
        return year;
    }
    public int getMonth(){
        if(month > 12){
            month -= 12;
            year += 1;
            return month;
        }else if (month < 1){
            month += 12;
            year -= 1;
            return month;
        }else return month;
    }
    public int getDay(){
        if(isLeapYear(getYear())){
            if(day > leapDaysInMonths[getMonth()-1]){
                day = day - leapDaysInMonths[getMonth()-1];
                month += 1;
                return day;
            }else if(day < 1){
                month -= 1;
                day = leapDaysInMonths[getMonth()-1] + day;
                return day;
            }else return day;
        }else if(day > commonDaysInMonths[getMonth()-1]){
            day = day - commonDaysInMonths[getMonth()-1];
            month += 1;
            return day;
        }else if(day < 1){
            month -= 1;
            day = commonDaysInMonths[getMonth()-1] + day;
            return day;
        }else return day;
    }

    public String toString(){
        int d = getDay();
        int m = getMonth();
        int y = getYear();
        return strDays[getDayOfWeek(y, m, d)] + " " + d + " " + strMonths[m-1] + " "  + y;
    }

    public String nextDay(){
        day = day + 1;
        return toString();

    }
    public String nextMonth(){
        month = month + 1;
        return toString();

    }
    public String nextYear(){
        year = year + 1;
        return toString();

    }
    public String previousDay(){
        day = day - 1;
        return toString();
    }
    public String previousMonth(){
        int m = month;
        month = month - 1;
        String str = toString();
        if(m == month){
            return previousDay();
        }else return str;
    }
    public String previousYear(){
        int m = month;
        year = year - 1;
        String str = toString();
        if(m != month){
            return previousDay();
        }else return str;
    }
}
