import java.awt.*;
import javax.swing.*;

public class Lab10Part1 extends JFrame{

    public Lab10Part1() {
    	//set the title
    	super("Draw initials DMcC");
     	//set the size & visibility
    	setSize(400,400);
    	setVisible(true);
    }//end constructor
    
    public void paint(Graphics g){
    	
    	super.paint(g);
		//set the initial colour
      	g.setColor(Color.red);
		//draw the D
	    g.drawLine(40, 100, 40, 300);
	    g.drawLine(40, 100, 90, 210);
	    g.drawLine(40, 300, 90, 210);
	    g.drawLine(41, 101, 41, 301);
	    g.drawLine(41, 101, 91, 211);
	    g.drawLine(41, 301, 91, 211);
	    
	    //draw M
      	g.drawLine(100, 100, 100, 300);
      	g.drawLine(100, 100, 150, 210);
      	g.drawLine(200, 100, 150, 210);
      	g.drawLine(200, 100, 200, 300);
      	g.drawLine(101, 101, 101, 301);
      	g.drawLine(101, 101, 151, 211);
      	g.drawLine(201, 101, 151, 211);
      	g.drawLine(201, 101, 201, 301);
      	
      	//draw c
      	g.drawLine(220, 100, 220, 180);
      	g.drawLine(220, 100, 270, 100);
      	g.drawLine(220, 180, 270, 180);
      	g.drawLine(221, 101, 221, 181);
      	g.drawLine(221, 101, 271, 101);
      	g.drawLine(221, 181, 271, 181);
      	
      	//draw C
      	g.drawLine(300, 100, 300, 300);
      	g.drawLine(300, 100, 360, 100);
      	g.drawLine(300, 300, 360, 300);
      	g.drawLine(301, 101, 301, 301);
      	g.drawLine(301, 101, 361, 101);
      	g.drawLine(301, 301, 361, 301);
    }//end paint method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab10Part1();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method   
}//end class