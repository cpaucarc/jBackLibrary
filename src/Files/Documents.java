package Files;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Frank Paucar
 */
public class Documents {
    static JFileChooser chooser;
    
    public static boolean existFileInDirectory(String path) {
        return new File(path).exists();
    }

    public static String selectDirectory(String currentDirectory){

        try {
            chooser = new JFileChooser(new File(currentDirectory));
            chooser.setDialogTitle("Select a Carpet");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (chooser.showDialog(null, "Select") == JFileChooser.APPROVE_OPTION) {
                String path = new File(chooser.getSelectedFile().toString()).getPath();
                return path.endsWith("\\") ? path : (path + "\\");
        }
        } catch (HeadlessException e) {
        }
        return null;
    }

    public static File selectPDFDocument(String currentDirectory) {

        chooser = new JFileChooser(new File(currentDirectory));
        chooser.setDialogTitle("Select a PDF document");
        chooser.setFileFilter(new FileNameExtensionFilter("document PDF", "pdf", "PDF"));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return new File(chooser.getSelectedFile().toString());
        }

        return null;
    }

    public static void copyFile(File src, File dest){
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException iOException) {
            }
        }
    }

    public static boolean copy(File fileOrigin, String path) {
        File fileCopy = new File(path);
        if (fileCopy.exists()) {
            int rsta = JOptionPane.showConfirmDialog(null,
                    "This file already exists, do you want replace it?", "Warning",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (rsta == 0) { // Replace it
                copyFile(fileOrigin, fileCopy);
                return true;
            } else {
                return false;
            }
        } else {
            copyFile(fileOrigin, fileCopy);
            return true;
        }
    }
}
