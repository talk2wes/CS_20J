// CS19 Java  Cinco! Word Guessing Game
// starter code by Steve J. Hodges
// use these class definitions, adding code for each function

import java.util.*;
import java.lang.*;
import java.io.*;

class Dictionary{
	private HashSet<String> words;
	private ArrayList<String> secrets;
	private Random rng;

	// constructor: read words from a file   
	public Dictionary(String filename){
		rng = new Random();
		words = new HashSet<String>();
		secrets = new ArrayList<String>();
		String temp = "";

		try{
			Scanner fin = new Scanner(new File(filename));
			while (fin.hasNextLine()){
				temp = fin.nextLine();
				//add all words to hashSet
				words.add(temp);
				//add all legal secret words to array list 
				if (isLegalSecretWord(temp)){
					secrets.add(temp);
				}
			}
			fin.close();
		}catch(Exception e){
			System.err.println("Error while reading file");
			System.err.println(e);
		}
	}

	// is word in the dictionary?
	//should this be case sensitive??
	public boolean validWord(String word){ return words.contains(word); }

	// get a legal secret word from the dictionary
	public String getLegalSecretWord(){
		return secrets.get(rng.nextInt(secrets.size()));
	}

	// is this word a legal secret word?
	private boolean isLegalSecretWord(String word){

		for (int i = 0; i < word.length(); i++){
			for (int j = 0; j < word.length(); j++)
				if (i != j && word.charAt(i) == word.charAt(j))
					return false;
		}
		return true;
	}
}

class Cinco{
	int numguesses;
	boolean cheated = false; //innocent until proven guilty
	String secret ;
	private static String DEFAULT_WORD_LIST = "cinco-words.txt";
	Dictionary dictionary;

	public Cinco(){ }
	public Cinco(String filename){ }
	public void play(){
		dictionary  =  new Dictionary(DEFAULT_WORD_LIST);	
		Scanner input = new Scanner(System.in);
		secret = dictionary.getLegalSecretWord();

		System.out.println("Secret word : " + secret);
		while (input.hasNextLine()){
			String myInput = input.nextLine();
			System.out.println("valid word? = " + 
				dictionary.validWord(myInput) + 
				"\nCount Matching Letters = " + 
				countMatchingLetters(myInput) );
			
		}

			
	} // contains main game loop and console i/o

	// return # of matching letters secret/guess
	private int countMatchingLetters(String guess){
		int diffs = 0;
		int lettersInAlpha = 26;
		boolean alphabet[] = new boolean[lettersInAlpha];
		
		if (secret.length() != guess.length())
			return -1;
		for (int i = 0; i < guess.length(); i++)
			for (int j = 0; j < guess.length(); j++)
				if (secret.charAt(i) == guess.charAt(j))
					alphabet[i] = true;
		for (int i = 0; i < lettersInAlpha; i++)
			diffs = alphabet[i] ? diffs + 1 : diffs;
		return diffs;
	}

	

	// return # of in-place letters secret/guess
	//private int countInPlaceLetters(String guess){ }

	// main program, required, minimal code
	public static void main(String [] args){
		Cinco game = new Cinco();
		game.play();
	}		
}
