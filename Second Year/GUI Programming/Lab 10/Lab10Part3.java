import java.awt.*;
import javax.swing.*;

public class Lab10Part3 extends JFrame{
	
	//variable to add onto the y axis within the loop 
	int n = 0;
	
    public Lab10Part3() {
    	//set the title
    	super("2 Cars");	
     	//set the size and visibility
    	setSize(700,700);
    	setVisible(true);
    }//end constructor
    
    public void paint(Graphics g){
    	super.paint(g);
    	//call the drawCars method
    	drawCars(g); 	
    }//end paint method
    
    public void drawCars(Graphics g){
    	//loop to create cars
    	for (int i=0;i<2;i++){
    		//call the drawWheel method
	    	drawWheels(g);
	    	//if its the first iteration
	    	if (i == 0){
	    		//set the colour to red
	    		g.setColor(Color.red);
	    		//call the drawFrame method
	    		drawFrame(g);
	    	}//end if
	    	else{
	    		//set the colour to black
	    		g.setColor(Color.black);
	    		//call the drawFrame method
	    		drawFrame(g);
	    	}//end else
	    	//call the ContourLines & drawWindows methods
			drawContourLines(g);
			drawWindows(g);
			//add 200 to the y axis
			n=200;
    	}//end for
    			
	}//end drawBlackCar
	
	public void drawWindows(Graphics g){
		//windows
      	g.setColor(Color.gray);
      	g.fillRect(270, 160 + n, 70, 40);
      	g.fillRect(360, 160 + n, 70, 40);
	}//draw windows method
	
	public void drawWheels(Graphics g){
		//wheels
      	g.setColor(Color.black);
    	g.fillOval(230, 240 + n, 80, 80);
    	g.fillOval(385, 240 + n, 80, 80);
	}//draw windows method
	
	public void drawContourLines(Graphics g){
      	g.setColor(Color.white);
    	g.drawLine(350, 150 + n, 350, 270 + n);
		g.drawLine(251, 201 + n, 450, 201 + n);
	}//draw windows method
	
	public void drawFrame(Graphics g){
		//frame
	    g.fillRect(200, 200 + n, 300, 70);
	    g.fillRect(250, 150 + n, 200, 70);
	}//draw windows method
	
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab10Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class