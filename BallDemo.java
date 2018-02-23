import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] myBalls;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);

    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line
        
        myBalls = new BouncingBall[numberOfBalls];

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        Random aleatorio = new Random();
        for(int i = 0; i < numberOfBalls; i++) {
           
            int radios = aleatorio.nextInt(20) + 5;
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            
            Color color = new Color(red, green, blue);
            
            int posX = aleatorio.nextInt(300);
            BouncingBall ball = new BouncingBall(posX, 50, radios, color, ground, myCanvas);
            ball.draw();
            myBalls[i] = ball;
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i<numberOfBalls; i++) {
                myBalls[i].move();
                if(myBalls[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
            
        }

    }
}
