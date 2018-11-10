package modele;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	    public static void main (String[] args) {
	        Date date = Calendar.getInstance().getTime();
	        System.out.println(date);
	        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	        System.out.println(df.format(new Date()));
	    }
}
