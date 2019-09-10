
public class ShapeCalculations {
	
	final static double PI = 3.14159265;
	
	public static double getVolumeOfCylinder(double radius, double height){
		double volume;
		return volume = PI * radius * radius * height;	
	}//end getVolumeOfCylinder method
	
	public static double getVolumeOfCube(double radius){
		double volume;
		return volume = 4 * PI * radius * radius * radius / 3;	
	}//end getVolumeOfCube method
	
	public static double getAreaOfSphere(double radius){
		double surfaceArea;
		return surfaceArea = 4 * PI * radius * radius;		
	}//end getAreaOfSphere() method
	
	public static void getPI(){
		System.out.println("\nThe value of PI is " + PI);
	}//end getPI
}//end class
