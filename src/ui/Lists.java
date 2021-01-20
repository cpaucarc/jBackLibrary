package ui;

import javax.swing.JList;

/**
 *
 * @author Paucar Frank
 */
public class Lists implements UIEnv{
    public static void Light(JList list){
        list.setFont(FONT_NORMAL);
        list.setForeground(UI_BLACK);
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellHeight(DEFAULT_HEIGHT);
    }
}
