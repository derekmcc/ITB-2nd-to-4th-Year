

import java.io.IOException;
import java.util.PropertyResourceBundle;

//English language resource bundle
public class ProgramResources_en extends PropertyResourceBundle {
	public ProgramResources_en() throws IOException {
		   super(ProgramResources_en.class.getResourceAsStream("ProgramResources_en.txt"));
	}//end method
}//end class