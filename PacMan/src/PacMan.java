import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel; // game panel

public class PacMan extends JPanel { 

    // Grid Dimeensions (rows, columns,tile size in pixels)

    private int rowCount = 21;   // height  (Up-down)
    private int columnCount = 19; // width (Left-Right)
    private int tileSize = 32; 
    // Pac-Man's position (starting position)
    private int pacmanX = 9 * tileSize;
    private int pacmanY = 17 * tileSize;
    private int pacmanSpeed = 2; // speed per frame
    // Pac-Man's direction (int not moving)
    private int directionX = 0;
    private int directionY = 0;
    // Animation frames
    private Image[] pacmanFrames;
    private int frameIndex = 0;

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
        "X....X... ...X....X",
        "X.XXXXXX.X.XXXXXX.X",
        "X.................X",
        "XXXXXXXXXXXXXXXXXXX"
    };

    // Constructor: Sets Up the game panel ( where game is drawn )

    PacMan(){ 
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // sets Panel to match Game Board
        setBackground(Color.BLACK); // sets Background Black
        // load animation frames
        pacmanFrames = new Image[4];
        pacmanFrames[0] = loadImage("pacman1.png");
                pacmanFrames[1] = loadImage("pacman2.png");
                pacmanFrames[2] = loadImage("pacman3.png");
                pacmanFrames[3] = loadImage("pacman2.png");
        
                // Listen for keyboard input
                setFocusable(true);
                addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyPressed(KeyEvent e){
                        int key = e.getKeyCode();
        
                        if (key == KeyEvent.VK_LEFT){
                            directionX = -1;
                            directionY = 0;
                        }else if (key == KeyEvent.VK_RIGHT){
                            directionX = 1;
                            directionY = 0;
                        }else if (key == KeyEvent.VK_UP){
                            directionX = 0;
                            directionY = -1;
                        }else if (key == KeyEvent.VK_DOWN){
                            directionX = 0;
                            directionY = 1;
                        }
                    }
                });
        
                // GAME LOOP using timer 
                Timer timer = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        updatePacMan();
                    }
        
                });
                timer.start(); //
                 
            }
        
            private Image loadImage(String fileName){
                return new ImageIcon(getClass().getResource(fileName)).getImage();
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
        // draw pacman
        if (pacmanFrames[frameIndex] != null){
            g.drawImage(pacmanFrames[frameIndex], pacmanX,pacmanY,tileSize,tileSize,this);
        } else{
            System.out.println("Pac-Man Image ERROR");
        }
    }
    public void updatePacMan(){
        // Move Pac-Man Based on direction
        pacmanX += directionX * pacmanSpeed;
        pacmanY += directionY * pacmanSpeed;

        // Cycle through animation frames
        frameIndex = (frameIndex + 1) % pacmanFrames.length;

        // Repaint the screen wit new frame (refresh screen)
        repaint();

    }



}
