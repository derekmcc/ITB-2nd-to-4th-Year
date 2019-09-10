package resources;

import java.util.ListResourceBundle;


//German language resource bundle
public class ProgramResource_en extends ListResourceBundle {
	
	private static final Object[][] resourceContents = { {"translateTo1","Un"}, {"translateTo2","Deux"}, {"translateTo3","Trois"} };

	  public Object[][] getContents() { 
		  return resourceContents;  
	 }//end object method

}
