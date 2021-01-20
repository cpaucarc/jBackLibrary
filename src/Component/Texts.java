package Component;

import Others.numberToWord;
import java.text.DecimalFormat;

/**
 *
 * @author Frank Paucar
 */
public class Texts {
    static numberToWord numLit = new numberToWord();
    static DecimalFormat decimalFormat = new DecimalFormat("0.##");
    
    public static String literalUpper(String txt) {
        return numLit.turnIntoLiteral(decimalFormat.format(Double.parseDouble(txt)), true);
    }
    
    public static String literal(String txt) {
        return numLit.turnIntoLiteral(decimalFormat.format(Double.parseDouble(txt)), false);
    }
    
    public static String literalSoles(String txt) {
        return numLit.turnIntoLiteral(decimalFormat.format(Double.parseDouble(txt)), false) + " Soles.";
    }
    
    @Deprecated
    public static String concatLike(String sql, String search, String[] data){
        for (String parameter: data){
            sql += parameter+" LIKE '"+search+"%' OR ";
        }
        sql = sql.substring(0, sql.length()-4)+";";
        return sql;
    }
}
