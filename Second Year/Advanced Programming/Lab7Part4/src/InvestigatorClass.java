

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat.Field;
import java.util.Hashtable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.Policy.Parameters;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class InvestigatorClass {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Method[] mthd = MysteryClass.class.getDeclaredMethods();  

        java.lang.reflect.Field[] fld =  MysteryClass.class.getDeclaredFields();  

        // Loop for get all the methods in class
        for(Method mthd1:mthd) {
        	Class[] paramTypes = mthd1.getParameterTypes();
        
            System.out.println("Method: " + mthd1.getName());
            System.out.println("Return Type : " + mthd1.getReturnType());
            
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                	System.out.print(", ");
                }//end if
                System.out.print("Parameter : " + paramTypes[j].getName());
            }//end for
            System.out.println("\n");
        }//end for 
        
        // Loop for get all the Field in class
        for(java.lang.reflect.Field fld1:fld) {
            fld1.setAccessible(true);
            System.out.println("Field Name : "+fld1.getName());
            System.out.println("Type : "+fld1.getType());
        }//end for
        MysteryClass ms = new MysteryClass();
        Method[] mthd1 = ms.getClass().getDeclaredMethods();

        //method invoked
		try {
			System.out.println(mthd[0].invoke(ms, 2));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // }//end for
        //System.out.println(ms.getClass().getMethods());
	}//end main method
}//end class
