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

    public static void openDocument(String path) {
        try {
            if (Documents.existFileInDirectory(path)) {
                Desktop.getDesktop().open(new File(path));
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "This file is not available currently!.", "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (IOException e) {
        }
    }

    public static void openBrowser(String url) {
        if (url.isEmpty() || url == null) {
            url = "http://www.google.com/";
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
            }
        }
    }
}
