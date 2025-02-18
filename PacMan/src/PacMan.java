

import java.awt.*;
import javax.swing.JPanel;

public class PacMan extends JPanel { // Extend Jpanel.. pacman grid inherits jpanel? 
    private int rowCount = 21;  
    private int columnCount = 19; 
    private int tileSize = 32; 
    private int boardWidth = columnCount * tileSize;  
    private int boardHeight = rowCount * tileSize;

    PacMan(){ 
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // Instructor 
        setBackground(Color.BLACK);
         
    }



}
