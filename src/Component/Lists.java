package Component;

import javax.swing.JList;

/**
 *
 * @author Paucar Frank
 */
public class Lists {
    public static void Light(JList list){
        list.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(64, 69, 78));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellHeight(30);
    }
}
