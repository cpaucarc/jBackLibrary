package Others;

import java.util.regex.Pattern;

//Code get from:  https://gist.github.com/leog1992/f96596d93b3ff4105ed7affa724f415f

public class numberToWord {

    private final String[] UNITS = {"", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    private final String[] TENS = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciseis",
        "diecisiete", "dieciocho", "diecinueve", "veinte", "treinta", "cuarenta",
        "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    private final String[] HUNDREDS = {"", "ciento", "doscientos", "trecientos", "cuatrocientos", "quinientos", "seiscientos",
        "setecientos", "ochocientos", "novecientos"};

    public numberToWord() {
    }

    public String turnIntoLiteral(String number, boolean uppercase) {
        String literal;
        String decimalPart;
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        number = number.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if (!number.contains(",")) {
            number = number + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", number)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String num[] = number.split(",");
            //se da formato al numero decimal
            decimalPart = "y " + num[1] + "/100";
            //se convierte el numero a literal
            if (Integer.parseInt(num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(num[0]) > 999999) {//si es millon
                literal = getMillones(num[0]);
            } else if (Integer.parseInt(num[0]) > 999) {//si es miles
                literal = getThousands(num[0]);
            } else if (Integer.parseInt(num[0]) > 99) {//si es centena
                literal = getHundreds(num[0]);
            } else if (Integer.parseInt(num[0]) > 9) {//si es decena
                literal = getTens(num[0]);
            } else {//sino unidades -> 9
                literal = getUnits(num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (uppercase) {
                return (literal + decimalPart).toUpperCase();
            } else {
                return (literal + decimalPart);
            }
        } else {//error, no se puede convertir
            return null;
        }
    }

    /* funciones para convertir los numeros a literales */
    private String getUnits(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNITS[Integer.parseInt(num)] + " ";
    }

    private String getTens(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnits(num);
        } else if (n > 19) {//para 20...99
            String u = getUnits(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return TENS[Integer.parseInt(num.substring(0, 1)) + 8] + " ";
            } else {
                return TENS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u + " ";
            }
        } else {//numeros entre 11 y 19
            return TENS[n - 10] + " ";
        }
    }

    private String getHundreds(String num) {// 999 o 099
        if (Integer.parseInt(num) > 99) {//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                return HUNDREDS[Integer.parseInt(num.substring(0, 1))] + getTens(num.substring(1)) + " ";
            }
        } else {//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getTens(Integer.parseInt(num) + "") + " ";
        }
    }

    private String getThousands(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n;
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getHundreds(m);
            return n + "mil " + getHundreds(c) + " ";
        } else {
            return "" + getHundreds(c) + " ";
        }

    }

    private String getMillones(String numero) { //000 000 000        
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n;
        if (millon.length() > 1) {
            n = getHundreds(millon) + "millones ";
        } else {
            n = getUnits(millon) + "millon ";
        }
        return n + getThousands(miles);
    }
}
