import java.io.*;

public class StackTest{
	public static void main(String[] args) {
		StackReferenceBased stack = new StackReferenceBased();

		stack.push("Hello");
		stack.push("Brilliant");
		stack.push("World");

		System.out.println("Top is " + stack.top());

		System.out.println("We just popped " + stack.pop());

		System.out.println("Top is " + stack.top());
	}
}