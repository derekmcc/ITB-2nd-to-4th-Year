package resources;

import java.util.ListResourceBundle;

//German language resource bundle
public class ProgramResource_fr extends ListResourceBundle{
	
	  private static final Object[][] resourceContents = { {"btn1","One"}, {"btn2","Two"}, {"btn3","Three"} };

	  public Object[][] getContents() { 
		  return resourceContents;  
	  }//end object method

}