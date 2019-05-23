package dateAndTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateAndTimeApp {

    public void verifyDates(Boolean isJava1_8){
        if(isJava1_8){
            LocalDate date1 = LocalDate.of(1990,1,20);
            LocalDate date2 = LocalDate.now();
            System.out.println("is " + date1 + " after this moment?\n" + date1.isAfter(date2));
            System.out.println("is this moment after " + date1 + "\n" + date1.isBefore(date2));

            LocalTime time1 = LocalTime.of(23,59,50);
            LocalTime time2 = LocalTime.now();
            System.out.println("is " + time1 + " after this moment?\n" + time1.isAfter(time2));
            System.out.println("is this moment after " + time1 + "\n" + time1.isBefore(time2));

            LocalDateTime dateTime1 = LocalDateTime.of(1990,1,20,23,59,50);
            LocalDateTime dateTime2 = LocalDateTime.now();
            System.out.println("is " + dateTime1 + " after this moment?\n" + dateTime1.isAfter(dateTime2));
            System.out.println("is this moment after " + dateTime1 + "\n" + dateTime1.isBefore(dateTime2));
        }else{
            Calendar date1 = Calendar.getInstance();
            date1.set(1990,0,20);
            Calendar date2 = Calendar.getInstance();

            System.out.println("is 1990/01/20 after this moment?\n" + date1.after(date2));
        }
    }

    public void measureTime(Boolean isJava1_8) throws InterruptedException{
        if(isJava1_8){
            Instant start = Instant.now();
            Thread.sleep(1000);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).toMillis());
        }else{
            Long start = System.currentTimeMillis();
            Thread.sleep(1000);
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    public void periodBetweenDates(Boolean isJava1_8){
        if (isJava1_8){
            LocalDate start = LocalDate.of(1991,1,21);
            LocalDate end = LocalDate.of(2017,3,4);

            Period period = Period.between(start,end);
            System.out.println("There have passed " +period.getYears() + " years, " + period.getMonths() +
                    " month, " + period.getDays() + " days, from " + start + " to " + end);
        }else{
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();

            start.set(1991,0,21);
            end.set(2017,2,4);

            Integer yearsAmount = 0;

            while (start.before(end)){
                start.add(Calendar.YEAR, 1);
                if(start.before(end)) yearsAmount++;
            }

            System.out.println("From 1991/01/21 to 2017/03/04 have passed " + yearsAmount + " years");
        }
    }

    public void dateConverter(Boolean isJava1_8) throws ParseException {
        String dateNotFormatted = "21/01/1991";
        if(isJava1_8){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateFormatted = LocalDate.parse(dateNotFormatted, formatter);
            System.out.println("date not formated: " + dateNotFormatted + "\n" +
                    "formatted date (dd/MM/yyyy): " + dateFormatted);

            formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            System.out.println("formatted date (ddMMyyyy): " + formatter.format(dateFormatted));

        }else{
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFormatted = formatter.parse(dateNotFormatted);
            System.out.println("date not formated: " + dateNotFormatted + "\n" +
                    "formatted date (dd/MM/yyyy): " + dateFormatted);

            Date dateNotFormattedWithTime = Calendar.getInstance().getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String dateFormattedWithTime = formatter.format(dateNotFormattedWithTime);
            System.out.println("formatted date (dd/MM/yyyy:HH:mm:ss a): " + dateFormattedWithTime);
        }
    }

    public static void main(String[] args) throws InterruptedException, ParseException {
        DateAndTimeApp app = new DateAndTimeApp();

        // Date and Time with JDK 1.7
        //app.verifyDates(false);

        // Date and Time with JDK 1.8
        //app.verifyDates(true);

        // Measure Time with JDK 1.7
        //app.measureTime(false);

        // Measure Time with JDK 1.8
        //app.measureTime(true);

        // Period Between Dates with JDK 1.7
        //app.periodBetweenDates(false);

        // Period Between Dates with JDK 1.8
        //app.periodBetweenDates(true);

        // Format Dates with JDK 1.7
        //app.dateConverter(false);

        // Format Dates with JDK 1.8
        app.dateConverter(true);
    }
}
