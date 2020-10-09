package Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Frank Paucar
 */
public class Dates {
    
    public static String getYearMonthDay(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        return formatDate.format(date);
    }
    
    public static String getDayMonthYear(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        return formatDate.format(date);
    }
    
    public static Date getDate (String fecha) throws ParseException {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-d");
            return formato.parse(fecha);
        } catch (ParseException ex) {
            throw new ParseException("Error while parsing date", 0);
        }
    }
}
