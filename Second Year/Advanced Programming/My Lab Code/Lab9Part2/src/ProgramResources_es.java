import java.io.IOException;
import java.util.PropertyResourceBundle;

//Spanish Language Resource Bundle
public class ProgramResources_es extends PropertyResourceBundle {

	public ProgramResources_es() throws IOException {
		   super(ProgramResources_es.class.getResourceAsStream("ProgramResources_es.txt"));
	}//end method
}//end class
