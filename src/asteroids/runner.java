package asteroids;

import javax.swing.JFrame;
import java.awt.Component;

public class runner extends JFrame
{
    static final int WIDTH = 1200;
    static final int HEIGHT = 725;
    
    public runner() throws Exception
	{
		super("Asteroids-By Inaki");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Asteroids runner = new Asteroids();
                			
		((Component)runner).setFocusable(true);			
		
                
		getContentPane().add(runner);
						
		setVisible(true);
                
                runner.run();
	}
	
	public static void main( String args[] ) throws Exception
	{
		runner run = new runner();
               
	}
    
}
