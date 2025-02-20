import javax.swing.*; // GUI
import java.awt.*; // Graphics & Font
import java.awt.event.*; // KeyListener 

public class App {
    private enum State{ START, PLAYING} // Game States
    private State gameState = State.START; // Default to Start Screen
    private JPanel startScreen;
    private PacMan pacmanGame;
    private JFrame frame;
    public static void main(String[] args){
        new App(); 
     }
     public App(){
        int rowCount = 21;  // height
        int columnCount = 19; // width 
        int tileSize = 32; // tile size pixels
        int boardWidth = columnCount * tileSize;  // width (left-right grid named: Columns)
        int boardHeight = rowCount * tileSize;  // height (up-down grid named: Rows)

        frame = new JFrame("Pac-Man"); // creates game window
        frame.setVisible(true); // make window visible
        frame.setSize(boardWidth, boardHeight); // Size of game
        frame.setLocationRelativeTo(null); // setting the window / null: center of screen
        frame.setResizable(false); // stops fWrom resizing window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x button exits

        createStartScreen(); // Show this first
        frame.setVisible(true);
     }
     private void createStartScreen(){
        startScreen = new JPanel(){
                    @Override
                    protected void paintComponent(Graphics g){
                        super.paintComponent(g);
                        if (gameState == State.START){
                        g.setColor(Color.BLACK);
                        g.fillRect(0, 0, getWidth(), getHeight());
        
                        g.setColor(Color.YELLOW);
                        g.setFont(new Font("Arial", Font.PLAIN, 20));
                        g.drawString("Press ENTER to Start", getWidth() / 2 - 120, 300);
                        }
                    }
                };
        startScreen.setFocusable(true);
        startScreen.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    startGame(); // switch to game 
                }
            }
        });

        frame.add(startScreen);
        startScreen.requestFocusInWindow(); //Ensuring keyboard is detected
    }

     private void startGame(){
        gameState = State.PLAYING;
        frame.remove(startScreen);
        pacmanGame = new PacMan();
        frame.add(pacmanGame); // add panel onto window
        frame.pack(); // full size frame 
        pacmanGame.requestFocusInWindow();
        frame.revalidate();
        frame.repaint();

        System.out.println("PacMan Started");
     }


        
    }
