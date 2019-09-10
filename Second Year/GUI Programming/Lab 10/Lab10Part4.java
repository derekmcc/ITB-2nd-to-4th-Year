import java.awt.*;
import javax.swing.*;

public class Lab10Part4 extends JFrame{

    public Lab10Part4() {
    	//set the title
    	super("Snowman");	
     	//set the size & visibility
    	setSize(550,550);
    	setVisible(true);
    	//set the background of the contentPane to black
    	getContentPane().setBackground(Color.BLACK);
    }//end constructor
    
    public void paint(Graphics g){
    	super.paint(g);    	
		//call the methods
    	drawHead(g);
		drawTorso(g);
		drawBottom(g);
		drawRightArm(g);
		drawLeftArm(g);
		drawHat(g);
    }//end paint method
    
    public void drawHead(Graphics g){
    	//head
		g.setColor(Color.WHITE);
		g.fillOval(240, 120, 100, 100);
		//eyes
		g.setColor(Color.BLACK);
		g.fillOval(265, 145, 15, 15);
		g.fillOval(298, 145, 15, 15);
		//nose
		g.setColor(Color.orange);
		//set attributes of the x and y axis
		int x1=275,x2=15,y1=167,y2=15;
		//loop to create nose	
		for (int i=0;i<4;i++){
			g.fillOval(x1, y1, x2, y2);
			x1-=10;
			y1+=2;
			y2-=1;
			x2-=1;
		}//end for
		
		//mouth
		g.setColor(Color.BLACK);
		g.fillOval(263, 187, 10, 10);
		g.fillOval(272, 192, 10, 10);
		g.fillOval(282, 194, 10, 10);
		g.fillOval(292, 192, 10, 10);
		g.fillOval(302, 187, 10, 10);
    }//end drawHead
    
    public void drawTorso(Graphics g){
    	//torso
		g.setColor(Color.WHITE);
		g.fillOval(227, 215, 130, 130);
		//buttons
		g.setColor(Color.BLACK);
		g.fillOval(283, 230, 15, 15);
		g.fillOval(283, 248, 15, 15);
		g.fillOval(283, 264, 15, 15);
		g.fillOval(283, 280, 15, 15);
    }//end drawTorso method
    
    public void drawBottom(Graphics g){
		g.setColor(Color.WHITE);
		//ORIGINAL WITHOUT LEGS
	//	g.fillOval(215, 330, 165, 165);
		g.fillRect(250,330,20,140);
		g.fillRect(200,450,70,20);
		g.fillRect(310,330,20,140);
		g.fillRect(310,450,70,20);
    }//end drawBottom method
    
     public void drawRightArm(Graphics g){
    	//arm
		g.setColor(Color.GRAY);
		g.drawLine(155, 190, 230, 250);
		g.drawLine(155, 190, 234, 250);
		//hand
		g.drawLine(155, 160, 175, 203);
		g.drawLine(155, 160, 178, 203);
		g.drawLine(145, 210, 177, 210);
		g.drawLine(148, 210, 186, 213);
    }//end drawRightArm method
    
    public void drawLeftArm(Graphics g){
    	//arm
		g.setColor(Color.GRAY);
		g.drawLine(420, 190, 348, 250);
		g.drawLine(420, 190, 343, 250);
		//hand
		g.drawLine(420, 160, 403, 203);
		g.drawLine(420, 160, 400, 203);
		g.drawLine(400, 210, 440, 210);
		g.drawLine(400, 207, 440, 210);
    }//end drawLeftArm method
    
    public void drawHat(Graphics g){
    	//hat
    	g.fillOval(233,110,110,15);
    	g.fillRect(265,70,50,50);
    }//end drawHat method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab10Part4();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class