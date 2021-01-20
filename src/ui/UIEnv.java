/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Paucar
 */
public interface UIEnv {
    // Colors
    final Color UI_BLUE = new Color(0, 122, 255);
    final Color UI_RED = new Color(255, 45, 85);
    final Color UI_GREEN = new Color(52, 199, 89);
    final Color UI_YELLOW = new Color(255, 204, 0);
    final Color UI_ORANGE = new Color(255, 149, 0);
    final Color UI_PURPLE = new Color(88, 86, 214);
    final Color UI_BLACK = new Color(30, 30, 30);
    final Color UI_WHITE = new Color(255, 255, 255);
    final Color UI_SKYBLUE = new Color(90, 200, 250);
    final Color UI_VIOLET = new Color(175, 82, 222);
    final Color UI_HARD_GREY = new Color(79, 79, 79);
    final Color UI_SOFT_GREY = new Color(209, 209, 214);
    
    // Sizes
    final int DEFAULT_HEIGHT = 25;
    
    // Font
    final String FONT_FAMILY = "Roboto";
    final int FONT_NORMAL_SIZE = 13;
    final int FONT_SMALL_SIZE = 11;
    final int FONT_LARGE_SIZE = 16;
    final Font FONT_NORMAL = new Font(FONT_FAMILY, Font.PLAIN , FONT_NORMAL_SIZE);
    final Font FONT_NORMAL_BOLD = new Font(FONT_FAMILY, Font.BOLD , FONT_NORMAL_SIZE);
    final Font FONT_SMALL = new Font(FONT_FAMILY, Font.PLAIN , FONT_SMALL_SIZE);
    final Font FONT_SMALL_BOLD = new Font(FONT_FAMILY, Font.BOLD , FONT_SMALL_SIZE);
    final Font FONT_LARGE = new Font(FONT_FAMILY, Font.PLAIN , FONT_LARGE_SIZE);
    final Font FONT_LARGE_BOLD = new Font(FONT_FAMILY, Font.BOLD , FONT_LARGE_SIZE);
}
