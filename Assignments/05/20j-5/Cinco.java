// CS19 Java  Cinco! Word Guessing Game
// starter code by Steve J. Hodges
// use these class definitions, adding code for each function

import java.util.*;
import java.lang.*;
import java.io.*;

class Dictionary{
	private HashSet<String> words;
	private ArrayList<String> secrets;
	private static Random rng = new Random();

// constructor: read words from a file   
	public Dictionary(String filename){
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
	public boolean validWord(String word){
		//should this be case sensitive ??? 
		return words.contains(word);
	}

	// get a legal secret word from the dictionary
	public String getLegalSecretWord(){
		int index = rng.nextInt(secrets.size());
		return secrets.get(index);
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
	//Dictionary dictionary;
	int numguesses;
	boolean cheated;
	String secret;
	private static String DEFAULT_WORD_LIST = "cinco-words.txt";

	public Cinco(){ }
	public Cinco(String filename){ }
	public void play(){ } // contains main game loop and console i/o

	// return # of matching letters secret/guess
	//private int countMatchingLetters(String guess){ }

	// return # of in-place letters secret/guess
	//private int countInPlaceLetters(String guess){ }

	// main program, required, minimal code
	public static void main(String [] args){
		//TESTING
		Dictionary dictionary = new Dictionary(DEFAULT_WORD_LIST);
		if (args.length > 0)
			System.out.println("args[0] =" + args[0]);
		//TESTING LOOP
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()){
			System.out.println("rng = " + dictionary.getLegalSecretWord());
			System.out.println("validWord?:" + dictionary.validWord(input.nextLine()));
		}
	}
}
