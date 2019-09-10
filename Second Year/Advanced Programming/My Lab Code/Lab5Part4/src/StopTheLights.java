import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopTheLights extends JFrame implements ActionListener{  
	
	private static final long serialVersionUID = 1L;
	
	JButton btn1, btn2;
	
	public StopTheLights(){
		super("Traffic Lights");

		Container contentPane = getContentPane();
		canvas = new JPanel();
		contentPane.add(canvas, "Center");
		JPanel panel = new JPanel();

		btn1 = new JButton("Start");
		btn1.addActionListener(this);
		panel.add(btn1);

		btn2 = new JButton("Stop");
		btn2.addActionListener(this);
		panel.add(btn2);
      	contentPane.add(panel, "South");
      	
      	//set the size & resizability
  		setSize(300, 400);
  		setResizable(false);
  		setVisible(true);
	}//end constructor
	
	private JPanel canvas;

	@Override
	public void actionPerformed(ActionEvent e) {
		TrafficLights t = new TrafficLights(canvas);
		if(e.getSource() == btn1){
			t.start();
		}//end if
		else if (e.getSource() == btn2){
			btn1.setEnabled(true);
			Thread.interrupted();
		}//end else if
	}//end dactionPerformed
	
	public static void main(String args[]){
		JFrame frame = new StopTheLights();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
}//end class

class TrafficLights extends Thread{  
	
	private volatile boolean flag = false;
	
	public TrafficLights(JPanel trafficPanel){ 
		panel2 = trafficPanel; 
	}//end trafficLights panel method

	public void draw(){ 
		Graphics g = panel2.getGraphics();
		g.setColor(Color.black);
    	g.fillRect(100, 80, 80, 180);
    	//g.dispose();
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
	   try{ 
		   draw();
		   drawRed();
		   sleep(1000);
		   drawBlack(0);
		   drawAmber();
           sleep(1000);
           drawBlack(50);
           drawGreen();
           sleep(1000);
           drawBlack(100);
      } catch(InterruptedException e){
    	  e.printStackTrace();  
      }//end catch
   }//end run method
   
   private JPanel panel2;
}//end class
