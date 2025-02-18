

import javax.swing.JFrame;

public class App {
    public static void main(String[] args){
        int rowCount = 21;  // height
        int columnCount = 19; // width 
        int tileSize = 32; // tile size pixels
        int boardWidth = columnCount * tileSize;  // width (left-right grid named: Columns)
        int boardHeight = rowCount * tileSize;  // height (up-down grid named: Rows)

        JFrame frame = new JFrame("Pac-Man"); // creates game window
        frame.setVisible(true); // make window visible
        frame.setSize(boardWidth, boardHeight); // Size of game
        frame.setLocationRelativeTo(null); // setting the window / null: center of screen
        frame.setResizable(false); // stops fWrom resizing window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x button exits

        //instance of jpanel 
        PacMan pacmanGame = new PacMan();
        frame.add(pacmanGame); // add panel onto window
        frame.pack(); // full size frame 
        frame.setVisible(true);

        
    }
}
