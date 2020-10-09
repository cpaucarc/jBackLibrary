package External;

import Files.Documents;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Frank Paucar
 */
public class Open {
    
    public static void openDocument(String path) throws IOException{
        try {
            if (Documents.existFileInDirectory(path)) {
                File file = new File(path);
                Desktop.getDesktop().open(file);
            }else{
                JOptionPane.showMessageDialog(null, 
                        "This file is not available currently!.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            throw new IOException("This file is not avalable.");
        }
    }
    
    public static void openBrowser(String url) throws URISyntaxException, IOException, Exception{
        if (url.isEmpty() || url == null){
            url = "http://www.google.com/";
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                throw new Exception("Not is posible open the URL in the browser.");
            }
        }
    }
}
