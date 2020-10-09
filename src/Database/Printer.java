package Database;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Frank Paucar
 */
public class Printer extends Conection{
    
    private boolean devMode;
    private String prodPath;
    
    public Printer(String user, String psw, String db, String host, boolean devMode) {
        super(user, psw, db, host);
        this.devMode = devMode;
    }
  
    private void subPrint(String path, Map parame) throws HeadlessException, JRException{
        try {
            JasperPrint prt = JasperFillManager.fillReport(path, parame, this.con);
            int n = prt.getPages().size();
            if (n > 0) {
                JasperViewer JsperView = new JasperViewer(prt, false);
                JsperView.setExtendedState(6);
                JsperView.show();
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (HeadlessException | JRException e) {
            System.out.println("Error en subPrint \n"+e);
        }
    }
    
    //Impresion para 1 Parametro
    public void Print1P(String path, String parameter, String value) {
        try {
            Map parame = new HashMap();            
            parame.put(parameter, value);
            subPrint(getPath(path), parame);
        } catch (HeadlessException | JRException E) {System.out.println("Error en Print1P \n"+E);}
    }
    
    //Impresion para 2 Parametro
    public void Print2P(String path, String parameter1, String value1, String parameter2, String value2) {
        try {
            Map parame = new HashMap();
            parame.put(parameter1, value1);
            parame.put(parameter2, value2);
            subPrint(path, parame);
        } catch (HeadlessException | JRException E) { System.out.println("Error en Print2P \n"+E); }
    }
    
    //Impresion para 3 Parametro
    public void Print3P(String path, String parameter1, String value1,
            String parameter2, String value2, String parameter3, String value3) {
        try {
            Map parame = new HashMap();
            parame.put(parameter1, value1);
            parame.put(parameter2, value2);
            parame.put(parameter3, value3);
            
            subPrint(path, parame);
        } catch (HeadlessException | JRException E) { System.out.println("Error en Print3P \n"+E); }
    }
    //Impresion para 4 Parametro
    public void Print4P(String path, String parameter1, String value1,
            String parameter2, String value2, String parameter3, String value3, String parameter4, String value4) {
        try {
            Map parame = new HashMap();
            parame.put(parameter1, value1);
            parame.put(parameter2, value2);
            parame.put(parameter3, value3);
            parame.put(parameter4, value4);
            
            subPrint(path, parame);
        } catch (HeadlessException | JRException E) { System.out.println("Error en Print4P \n"+E); }
    }
    //Impresion para 5 Parametro
    public void Print5P(String path, String parameter1, String value1,
            String parameter2, String value2, String parameter3, String value3, 
            String parameter4, String value4, String parameter5, String value5) {
        try {
            Map parame = new HashMap();
            parame.put(parameter1, value1);
            parame.put(parameter2, value2);
            parame.put(parameter3, value3);
            parame.put(parameter4, value4);
            parame.put(parameter5, value5);
            
            subPrint(path, parame);
        } catch (HeadlessException | JRException E) { System.out.println("Error en Print5P \n"+E); }
    }    
    
    private String getPathDevMode(String path){
        return System.getProperty("user.dir") + "/src/"+ path + ".jasper";
        /* path = Reports/docentes */
    }
    
    private String getPathProdMode(String path){
        return prodPath + path + ".jasper";
        /* esperado : "C:/Program Files (x86)/Programa/" + Nomrep + ".jasper"; */
    }
    
    /*Recomendation: Create an option in your program where you save the path of reports location when your program is in producction mode*/
    public void setProdPath(String prodPath){
        this.prodPath = prodPath;
    }
    
    private String getPath(String path){
        if (devMode)
            return getPathDevMode(path);
        else
            return getPathProdMode(path);
    }        
}
