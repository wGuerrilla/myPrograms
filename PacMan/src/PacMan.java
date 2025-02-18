import java.awt.*; 
import javax.swing.JPanel; // game panel

public class PacMan extends JPanel { 

    // Grid Dimeensions (rows, columns,tile size in pixels)

    private int rowCount = 21;   // height  (Up-down)
    private int columnCount = 19; // width (Left-Right)
    private int tileSize = 32; 

    // Board size based on grid dimensions 

    private int boardWidth = columnCount * tileSize;   
    private int boardHeight = rowCount * tileSize;    

    // Grid Layout (X - wall, " "- empty space, . - food)

    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X........X........X",
        "X.XX.XXX.X.XXX.XX.X",
        "X.................X",
        "X.XX.X.XXXXX.X.XX.X",
        "X....X...X...X....X",
        "XXXX.XXX...XXX.XXXX",
        "   X.X..   ..X.X   ",
        "XXXX.X.XXXXX.X.XXXX",
        ".......X   X.......",
        "XXXX.X.XXXXX.X.XXXX",
        "   X.X.......X.X   ",
        "XXXX...XXXXX...XXXX",
        "X........X........X",
        "X.XX.XXX.X.XXX.XX.X",
        "X..X...........X..X",
        "XX.X.X.XXXXX.X.X.XX",
        "X....X.......X....X",
        "X.XXXXXX.X.XXXXXX.X",
        "X.................X",
        "XXXXXXXXXXXXXXXXXXX"
    };

    // Constructor: Sets Up the game panel ( where game is drawn )

    PacMan(){ 
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // sets Panel to match Game Board
        setBackground(Color.BLACK); // sets Background Black
         
    }

    // Method for game to be redrawn
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // clears previous frame 

        // Loop to draw walls
        for (int r = 0; r < rowCount; r++) { // loop through each row
            for (int c = 0; c < columnCount; c++) { // loop through each column
                char tile = tileMap[r].charAt(c); // Get the current tile character
                if (tile == 'X') { // if the tile is wall "X"
                    g.setColor(new Color(50,20, 90)); // Set it the BLUE Color
                    g.fillRect(c * tileSize, r *tileSize, tileSize, tileSize); // Draw a Square for the wall
                } else if (tile == '.'){ // if tile is . 
                    g.setColor(Color.WHITE);
                    int foodSize = tileSize / 6; // small dot
                    int offset = (tileSize - foodSize) / 2; // Center Dot in tile 
                    g.fillOval(c * tileSize + offset, r * tileSize + offset, foodSize,foodSize);
                }
             }
        }
    }



}
