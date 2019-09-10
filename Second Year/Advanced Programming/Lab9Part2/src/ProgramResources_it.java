import java.io.IOException;
import java.util.PropertyResourceBundle;

//Italian Language Resource Bundle
public class ProgramResources_it extends PropertyResourceBundle {

	public ProgramResources_it() throws IOException {
		   super(ProgramResources_it.class.getResourceAsStream("ProgramResources_it.txt"));
	}//end method
}//end class
