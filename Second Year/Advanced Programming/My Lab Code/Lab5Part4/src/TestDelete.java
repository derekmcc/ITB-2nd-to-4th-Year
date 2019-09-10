import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDelete extends JFrame implements ActionListener{
	
	private JPanel canvas;
	JButton btn1,btn2;
	public TestDelete(){
		
		super("Traffic Lights");
		

		Container contentPane = getContentPane();
		canvas = new JPanel();
		contentPane.add(canvas, "Center");
		JPanel panel = new JPanel();

		btn1 = new JButton("Start");
		btn1.addActionListener(this);
		
		btn2 = new JButton("Stop");
		btn2.addActionListener(this);
		panel.add(btn1);
		panel.add(btn2);
		
      	contentPane.add(panel, new BorderLayout().SOUTH);
      	
      	//set the size & resizability
  		setSize(300, 400);
  		setResizable(false);
	}
	public static void main(String args[]){
		JFrame frame = new TestDelete();
		frame.setVisible(true);
   }//end main method

	@Override
	public void actionPerformed(ActionEvent e) {
		TrafficLigh t = new TrafficLigh(canvas);
		
		if(e.getSource() == btn1){
			t.setFlag(1);
			t.start();
		}//end if
		else if (e.getSource() == btn2){
			t.cancel();
			t.sleep();
    		t.setFlag(-1);
		}//end else if	
	}
}//end class

class TrafficLigh extends Thread {//throws intInterruptedException{  
	private int c =1;
	//LightThread light = new LightThread();
	private boolean flag = false;
	
	public TrafficLigh(JPanel trafficPanel){ 
		panel2 = trafficPanel; 
	}//end trafficLights panel method

	public void draw(){ 
		Graphics g = panel2.getGraphics();
		g.setColor(Color.black);
    	g.fillRect(100, 80, 80, 180);
    	drawRed();
		//sleep(1000);
		drawBlack(0);
		drawAmber();
       // sleep(1000);
        drawBlack(50);
        drawGreen();
        //sleep(1000);
        drawBlack(100);
    //  g.dispose();
   }//end draw method 
	
   public Graphics drawRed(){
   		Graphics g = panel2.getGraphics();
   		g.setColor(Color.red);
    	g.fillOval(120, 100, 40, 40);
		return g;
	}//end draw red method
   
	public Graphics drawBlack(int x){
   		Graphics g = panel2.getGraphics();
   		g.setColor(Color.black);
    	g.fillOval(120, 100 + x, 40, 40);
		return g;
	}//end draw black method
	
	public Graphics drawAmber(){
		Graphics g = panel2.getGraphics();
   		g.setColor(Color.orange);
    	g.fillOval(120, 150, 40, 40);
		return g;
	}//end draw amber method
	
	public Graphics drawGreen(){
		Graphics g = panel2.getGraphics();
   		g.setColor(Color.green);
    	g.fillOval(120, 200, 40, 40);
		return g;
	}//end draw green method

   public void run(){ 
	   System.out.println(getFlag());
	   try{  
		  draw();
		   sleep(1000);
		   /*
		   while(!Thread.currentThread().isInterrupted()){
			   draw();
			   synchronized(this){
				   drawRed();
				   sleep(1000);
				   drawBlack(0);
				   drawAmber();
		           sleep(1000);
		           drawBlack(50);
		           drawGreen();
		           sleep(1000);
		           drawBlack(100);
			   }//end synchBlock
			   System.out.println(getFlag());	
			//   cancel();
		   }//end while
		   */
		  // sleep(4000);
      }//end try
	  
      catch(InterruptedException e){
    	  cancel();
    	  e.printStackTrace();
      }//end catch
	  
   }//end run method//
   public void cancel() {
	   interrupt(); 
	   Thread.currentThread().interrupt();
   }
   public void sleep(){
	   Thread.currentThread().interrupt();
	//   setFlag(false);
	 //  getThread.sleep(3000);
	 //  draw();
//	sleep(1000);
   }
   public int getFlag() {
	   return c;
	}
	
	public void setFlag(int f) {
		c = f;
	}
   private JPanel panel2;
}//end class