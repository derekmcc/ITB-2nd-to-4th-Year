import java.io.IOException;
import java.util.PropertyResourceBundle;

//French language resource bundle
public class ProgramResources_fr extends PropertyResourceBundle {
	
	public ProgramResources_fr() throws IOException {
		   super(ProgramResources_fr.class.getResourceAsStream("ProgramResources_fr.txt"));
	}//end method
}//end class