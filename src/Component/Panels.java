/*
 * Copyright (C) 2020 PAUCAR
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Component;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PAUCAR
 */
public class Panels {
    
    public static int x, y;
        
    public static void MoveFrame(JPanel panel, JFrame frame) {

        panel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}            
        });
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override public void mouseDragged(MouseEvent me) {
                Point p = MouseInfo.getPointerInfo().getLocation();
                frame.setLocation(p.x - x, p.y - y);
            }
            @Override public void mouseMoved(MouseEvent me) {}
        });
    }
    
}
