import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * A parser for regular expressions 
 * @author Derek McCarthy B00007439
 * @version 1.0
 * 
 * This class constructs the bracketed phrasal structure around the users sentence
 */
public class BracketedPhrasalStructurBuilder {

	//global scope variables
	private ArrayList<String> posTags = new ArrayList<String>();
	private ArrayList<String> usersWords = new ArrayList<String>();
	private StringTokenizer stTokens;
	private String strToken = "", tokenPlaceholder = "", tempToken = "", tempTokenPlaceholder = "";
	
	/*
	 * start of the constructor to build the bracketed structure  
	 */
	public BracketedPhrasalStructurBuilder(String userInput) {
		
		//tokenize the users input 
		stTokens = new StringTokenizer(userInput);
		
		//iterate through the tokens
		while(stTokens.hasMoreTokens()) {
			//add the tokens to string variables 
			strToken = stTokens.nextToken();
			tokenPlaceholder = strToken;
			
			//remove the underscore the stanford tagger places on the tags
			strToken = strToken.replaceAll("[a-z]+_", "");
			tokenPlaceholder = tokenPlaceholder.replaceAll("_[A-Z]+", "");
			
			//add the pos tags and the users inputted words to arrayLists
			posTags.add(strToken);
			usersWords.add(tokenPlaceholder);
		}//end while
		
		//string variables to create bracketed structure
		String verbPhrase = "\n    [ VP [ ";
		String sentence = "[ S\n    [ NP [ ";
		String nounPhrase = "\n        [ NP !";
		String out = "";
		
		//loop through the POS tags
		for(int i = 0; i < posTags.size(); i++) {
			//if its the first word in the array
			if (i == 0) {
				//print the brackets needed for that word and tag
				UserInterface.jtBrackets.setText(out = sentence + posTags.get(i) + " [ " +  usersWords.get(i) + " ] ] [ ");
			}//end if 
			//if its the second word in the array
			else if (i == 1) {
				//print the brackets needed for that word and tag
				UserInterface.jtBrackets.setText(out += posTags.get(i) + " [ " +  usersWords.get(i) + " ] ] ] ");
			}//end else if 
			//if its the third word in the array
			else if (i == 2) {
				//print the brackets needed for that word and tag
				UserInterface.jtBrackets.setText(out += verbPhrase + posTags.get(i) + " [ " +  usersWords.get(i) + " ] ] ] \n        [ NP ");
			}//end else if
			//if its the last word in the array
			else {
				//print the brackets needed for that word and tag
				UserInterface.jtBrackets.setText(out += "[ " + posTags.get(i) + " [ " +  usersWords.get(i) + " ] ] ");
			}//end else if
		}//end for
		//add the closing brackets
		UserInterface.jtBrackets.setText(out += "] ]");
		//prin the closing tag for the command line
		System.out.println(out + " ] ");
	}//end constructor
}//end class
