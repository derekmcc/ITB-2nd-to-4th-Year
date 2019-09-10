import java.lang.reflect.Method;

import reflections.ReflectionClass;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class Test {

	/*************************************************************************************************************
	 * @param args <<<<<<<<<<<<<<------------------ HAVE TO TIDY UP --------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 *************************************************************************************************************/
	public static void main(String[] args) {
		//this.reflections.ReflectionClass.getClass();
		//String ReflectionClass = "Student";
		Test tester1 = null;
		tester1 = new Test();
		ReflectionClass tester = null;
		tester = new ReflectionClass();
		System.out.print(tester1.getClass() + "\n");
		System.out.println(Test.class.getName());
		
		try {
			tester = (ReflectionClass)Class.forName("ReflectionClass").newInstance();
		}//end try
		catch(ClassNotFoundException e) {
			//e.printStackTrace();
		}//end catch
		catch(InstantiationException ex) {
			ex.printStackTrace();
		}//end catch
		catch(IllegalAccessException ex1) {
			ex1.printStackTrace();
		}//end catch
		tester.multi("test");
		
		Method[] methods = tester.getClass().getDeclaredMethods();

		for(int i=0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}//end for
	}//end main
}//end class
