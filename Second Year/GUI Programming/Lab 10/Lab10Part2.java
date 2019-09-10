import java.awt.*;
import javax.swing.*;

public class Lab10Part2 extends JFrame{

    //circle of circle radius
	int radius = 256;
    int a = 128;
    int b = 128;
    //the number of circles
    int numberOfCircles = 10;
    
    public Lab10Part2(int n) {
    	//set the title
    	super("Draw Circles");
    	//set the size & visibility 
    	setSize(700, 700);
    	setVisible(true);
    }//end constructor
    
    public void paint(Graphics g){
    	super.paint(g);
		//set the initial colour
      	g.setColor(Color.red);
    	//let a be equal to half the size of the width of the frame 
		a = getWidth() / 2;
		//let b be equal to half the size if the height if the frame
        b = getHeight() / 2;
      	//equations for the circles 
        int m = Math.min(a, b);
        int r = 4 * m / 5;
        int r2 = Math.abs(m - r) / 2;
		//loop to create the circles
		for (int i = 0; i < 10; i++) {
            double t = 2 * Math.PI * i / numberOfCircles;
            int x = (int) Math.round(a + r * Math.cos(t));
            int y = (int) Math.round(b + r * Math.sin(t));
            //draw the circles
            g.drawOval(x - r2, y - r2, 2 * r2, 2 * r2);
		}//end for
    }//end paint method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab10Part2(10);
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
    
}//end class