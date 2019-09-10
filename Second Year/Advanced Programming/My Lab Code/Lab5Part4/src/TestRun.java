import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
class StopTheLights extends JFrame implements ActionListener{  
	
	
	
	public boolean flag = false;
	
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
			//TrafficLights t = new TrafficLights(canvas);
			//t.setFlag(true);
			t.start();
			//btn1.setEnabled(false);
			t.setFlag(true);
			canvas.setVisible(true);
			System.out.println(t.getFlag() + "  Start");
		}//end if
		else if (e.getSource() == btn2){
			btn1.setEnabled(true);
			canvas.setVisible(false);
		}//end else if
	}
	
	public static void main(String args[]){
		JFrame frame = new StopTheLights();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
}//end class

class TrafficLights extends Thread{  
	
	//LightThread light = new LightThread();
	private volatile boolean flag = false;
	
	public TrafficLights(JPanel trafficPanel){ 
		panel2 = trafficPanel; 
	}//end trafficLights panel method

	public void draw(){ 
		Graphics g = panel2.getGraphics();
		g.setColor(Color.black);
    	g.fillRect(100, 80, 80, 180);
    	drawRed();
		   try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   drawBlack(0);
		   drawAmber();
        try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        drawBlack(50);
        drawGreen();
        try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        drawBlack(100);
    	g.dispose();
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
	  // while(flag=true){
	   if(flag=false){
		   System.out.println("If statement TEST");
	   }
	   
	   if(flag=false){
		   System.out.println("If statement TEST");
	   }
	  //while(getFlag() == true){
	   draw();
   }//end run method
   
   public void sleep(){
	  //flag = false;
	  try {
		Thread.currentThread().sleep(MAX_PRIORITY);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public boolean getFlag() {
	   return flag;
	}
	
	public void setFlag(boolean f) {
		flag = f;
	}
   private JPanel panel2;
}//end class*/