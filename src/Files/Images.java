package Files;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Frank Paucar
 */
public class Images {
    static JFileChooser chooser;
    
    public static File selectImage(String currentDirectory){        
        chooser = new JFileChooser(new File(currentDirectory));
        chooser.setDialogTitle("Select an image");
        chooser.setFileFilter(new FileNameExtensionFilter("Images","jpg", "png", "gif", "JPG", "PNG", "GIF"));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            return new File(chooser.getSelectedFile().toString());        
        
        return null;
    }
        
    public static void scaleImage(String path, JLabel label){        
        scaleImage(path, label, label.getBounds().width, label.getBounds().width);
    }
    
    public static void scaleImage(String path, JLabel label, int width, int height){        
        ImageIcon image = new ImageIcon(path);
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING));
        label.setIcon(icono);
    }
    
    public static void setImageIntoLabel(File file, JLabel label){
        String path = file.getAbsolutePath();
        scaleImage(path, label);
    }
    
    public static void setImageIntoLabel(File file, JLabel label, int width, int height){
        String path = file.getAbsolutePath();
        scaleImage(path, label, width, height);
    }
 
    public static String getImageExtension(File file){
        String name = file.getName();
        String[] aux = name.replace(".", "-").split("-");
        return "."+(aux)[aux.length-1];        
    }
}
