package ui;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Frank Paucar
 */
public class Frames {
    
    public void setFavicon(JFrame frame, String url) {
        URL iconURL = getClass().getResource(url);
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());
    }
    
    public void setFavicon(JDialog dialog, String url) {
        URL iconURL = getClass().getResource(url);
        ImageIcon icon = new ImageIcon(iconURL);
        dialog.setIconImage(icon.getImage());
    }
}
