package Component;

import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Frank Paucar
 */
public class TextField {
    
    public static void noSpace (KeyEvent evt){
        if (evt.getKeyChar() == 32)
            evt.consume();
    }
    
    public static void length (KeyEvent evt, JTextField tx, int size){
        if (tx.getText().length() >= size)
            evt.consume();
    }
    
    public static void upperCase (KeyEvent evt) {
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(("" + evt.getKeyChar()).toUpperCase().charAt(0));
    }
    
    public static void lowerCase (KeyEvent evt) {
        if (Character.isUpperCase(evt.getKeyChar()))
            evt.setKeyChar(("" + evt.getKeyChar()).toLowerCase().charAt(0));
    }
    
    public static void capitalize(KeyEvent evt, JTextField tx){
        if ( tx.getText().length() == 0 ){
            upperCase(evt);
        } else {
            if (tx.getText().charAt(tx.getText().length()-1) ==  ' ')
                upperCase(evt);
            else
                lowerCase(evt);
        }
    }
    
    public static void selectContent (JTextComponent tx) {
        tx.setSelectionStart(0);
        tx.setSelectionEnd(tx.getText().length());
        tx.grabFocus();
    }
    
    public static void onlyNumbers (KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }
    
    public static void onlyDecimal(KeyEvent evt, JTextField tx) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.' || tx.getText().contains(".")))
            evt.consume();
    }
    
    public static void onlyWords (KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < 65 || c > 90) && (c < 97 || c > 122) && c != 32) {
            if (c != 241 && c != 209)
                evt.consume();
        }
    }
    
    public static boolean isMail (String txt){
        return Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$",txt);
    }
    
    public static void dni(KeyEvent evt, JTextField tx){
        length(evt, tx, 8);
        onlyNumbers(evt);
    }
    
    public static void ruc(KeyEvent evt, JTextField tx){
        length(evt, tx, 11);
        onlyNumbers(evt);
    }
    
    public static void phone(KeyEvent evt, JTextField tx){
        length(evt, tx, 9);
        onlyNumbers(evt);
    }
}
