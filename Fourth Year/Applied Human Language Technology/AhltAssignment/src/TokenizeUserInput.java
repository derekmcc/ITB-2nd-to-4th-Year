import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

/**
 * A parser for regular expressions 
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TokenizeUserInput {

	//global scope variables 
	private ArrayList<String> tagList = new ArrayList<String>();
	private ArrayList<String> ruleList = new ArrayList<String>();
	private ArrayList<String> usersWords = new ArrayList<String>();
	private ArrayList<String> lexiconWords = new ArrayList<String>();
	private String posTags = "";
	private String addTagsToWords = "";
	UserInterface ui;
	boolean wordsDontMatch = false;
	
	/**
	 * Default Constructor
	 */
	public TokenizeUserInput(){
	}//end default constructor
	
	/**
	 * Method to scan the users input and lexicon and add its tags to an arraylist
	 * @param userStringTokens The tokens taken from the users input
	 * @param usersWords Each individual word from the users sentence
	 */
	public TokenizeUserInput(StringTokenizer userStringTokens, ArrayList<String> usersWords) {
		//add the users words to the arraylist
		this.usersWords = usersWords;
		//create a scanner object
		Scanner readLexiconFile = null;
		
		//while their are more tokens in the users inputed string loop
		while (userStringTokens.hasMoreTokens()) {
			//read the lexicon file
			readLexiconFile = new Scanner(getClass().getResourceAsStream("lexicon.txt"));
			String token = userStringTokens.nextToken();
			
			//while there is text in the text file loop
			while(readLexiconFile.hasNextLine()) {	
				//temp variable to hold the lexicon data being read in
				String text = readLexiconFile.nextLine().toString();
				//create 2 tokenizers one for the POS tags the otjer for the lexicon words
				StringTokenizer lexiconTokens1 = new StringTokenizer(text);
				StringTokenizer lexiconTokens2 = new StringTokenizer(text);
				//add the lexicon words to the arraylist
				lexiconWords.add(lexiconTokens2.nextToken());
				
				//loop while their is more data from the lexicon being read in
				while(lexiconTokens1.hasMoreTokens()){
					//if the users token matches the lexicon token
					if(token.equals(lexiconTokens1.nextToken())) {
						//add the lexicon tag token to a temp variable
						String thisLexToken = lexiconTokens1.nextToken();
						//add the temp variable to the tag array list
						tagList.add(thisLexToken);
					}//end if
				}//end while
			}//end inner while
		}//end outer while
		//close the scanner
		readLexiconFile.close();
		
		//loop to check if the words entered by the user are in the lexicon
		for(int i = 0; i < usersWords.size(); i++){
			//if the users words are in the lexicon
			if (lexiconWords.contains(usersWords.get(i))){
				//set the boolean flag to false
				wordsDontMatch = false;
			}//end if
			else {
				//else set the boolean flag to true and break the loop
				wordsDontMatch = true;
				break;
			}//end else
		}//end for
		
		//add each POS tag to a concatenated string
		for(int i = 0; i < tagList.size(); i++) {
			posTags += tagList.get(i) + " ";
		}//end for
	}//end constructor
	
	/**
	 * Method to check if the regular expression is valid or invalid
	 * @return Whether the regular expression is true or false 
	 */
	public boolean checkRegularExpresion() {
		//arraylist to hold the rules
		ArrayList<String> ruleList = new ArrayList<String>();
		//scanner to read in the rules
		Scanner readRuleFile = null;
		//initiate the scanner process of reading in the data
		readRuleFile = new Scanner(getClass().getResourceAsStream("rules.txt"));
		//loop while there is data to be read in
		while(readRuleFile.hasNextLine()) {	
			//add the rule list to a temp variable
			String text = readRuleFile.nextLine().toString();
			//add the temp variable to the rule array list
			ruleList.add(text);
		}//end while
		//close the scanner
		readRuleFile.close();
		//boolean flag variable
		boolean acceptable = false;
		
		//loop through the rule array list
		for(int i = 0; i < ruleList.size(); i++) {
			//temp variables to hold the rules and POS tags
			String string1 = ruleList.get(i).toString();
			String string2 = posTags.toString();
		
			//check if the POS tags match the rules
			if (string1.replace(" ", "").equalsIgnoreCase(string2.replace(" ", ""))) {
				//set flag to true and break
				acceptable = true;
				break;
			}//end if
			else {
				//else set flag to false
				acceptable = false;			
			}//end else
		}//end for
		
		//if the POS tags and Rules match
		if (acceptable == true) {
			//if a word was entered thats not in the lexicon
			if (wordsDontMatch) {
				//display a message
				JOptionPane.showMessageDialog(null, "Unknown Word Entered");
				//return false
				return false;
			}//end if
			else {
				for (int i = 0; i < tagList.size(); i++){
					addTagsToWords += usersWords.get(i) + "_" + tagList.get(i) + " ";
				}
				//else return true (the POS tags and Rules match)
				return true;
			}//end else
		}//end if
		else {
			//else false (the POS tags and Rules don't match)
			return false;
		}//end else
	}//end default constructor
	
	/**
	 * Method to get the tag list
	 * @return The tag list
	 */
	public ArrayList<String> getTagList() {
		return tagList;
	}//end getTagList
	
	/**
	 * Method to set the tag list
	 * @param tagList The tag array list 
	 */
	public void setTagList(ArrayList<String> tagList) {
		this.tagList = tagList;
	}//end setTagList
	
	/**
	 * Method to get the POS tags
	 * @return The POS tags
	 */
	public String getPosTags() {
		return posTags;
	}//end getPosTags
	
	/**
	 * Method to set the POS tags
	 * @param posTags
	 */
	public void setPosTags(String posTags) {
		this.posTags = posTags;
	}//end setPosTags
	
	/**
	 * Method to get the add tags to words string variable
	 * @return addTagsToWords  
	 */
	public String getAddTagsToWords() {
		return addTagsToWords;
	}//end getAddTagsToWords

	/**
	 * Method to set the add tags to words string variable
	 * @param addTagsToWords String variable 
	 */
	public void setAddTagsToWords(String addTagsToWords) {
		this.addTagsToWords = addTagsToWords;
	}//end setAddTagsToWords
}//end class
