import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This is a program that uses an applet to play a sound file.
 * @author Derek McCarthy B00007439
 * @version 1.0
 *
 */
public class PlayMySoundApplication extends Applet implements ActionListener{
	
	//global variables
	JButton play,stop, loop;
	AudioClip audio;
	
	/**
	 * init method to create the applet
	 */
	public void init() {
		//set the layout of the applet
		setLayout( new FlowLayout() ); 
		//create & and add the components to the applet
		play = new JButton("Play");
		play.addActionListener(this);
		add(play);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		add(stop);
		loop = new JButton("Loop");
		loop.addActionListener(this);
		add(loop);
		//get the audio clip
		audio = getAudioClip(getDocumentBase(), "horror003.wav");
	}//end method
	
	/**
	 * Method to stop the sound file from playing
	 */
	public void stop(){
		audio.stop();
	}//end stop method
	
	/**
	 * This is the a method to respond to user interactions
	 * @param e To listen for user interactions with the program
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			audio.play();
		}//end if
		else if(e.getSource() == stop){
			audio.stop();
		}//end else if 
		else if (e.getSource() == loop){
			audio.loop(); 
		}//end else if
	}//end actionPerformed method
}//end class
