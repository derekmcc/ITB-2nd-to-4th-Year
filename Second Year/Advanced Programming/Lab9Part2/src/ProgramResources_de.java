import java.io.IOException;
import java.util.PropertyResourceBundle;

//German Language Resource Bundle
public class ProgramResources_de extends PropertyResourceBundle {
	
	public ProgramResources_de() throws IOException {
		   super(ProgramResources_de.class.getResourceAsStream("ProgramResources_de.txt"));
	}//end method
}//end class