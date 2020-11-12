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
	boolean cheated;
	String secret ;
	Dictionary dictionary;
	private String defaultFilename = "cinco-words.txt";

	public Cinco(){
		dictionary  =  new Dictionary(defaultFilename);	
		secret = dictionary.getLegalSecretWord();
		numguesses = 0;
		cheated = false;
	}
	public Cinco(String filename){  //make sure this one works
		dictionary  =  new Dictionary(filename);	
		secret = dictionary.getLegalSecretWord();
		numguesses = 0;
		cheated = false;
	}
	public void play(){
		System.out.print("Cinco! Assignment 5\n" +
			"by Wesley Johanson\n" +
			"I'm thinking of a five letter word...\n" +
			"your guess? ");
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()){
			String myInput = input.nextLine();
			if (dictionary.validWord(myInput)){
				numguesses++;
				if (countMatchingLetters(myInput) == 5 && 
					countInPlaceLetters(myInput) == 5){
					System.out.println("Correct! You got it in " + 
					numguesses + " guesses.");
					if (cheated)
						System.out.println("but only by"
						+ " cheating");
					return;
				}
				System.out.println("Matching: " + 
					countMatchingLetters(myInput) +
					"\nIn-Place: " +
					countInPlaceLetters(myInput)); 
			}else{
				if (myInput.equals("xxxxx")){
					numguesses++;
					System.out.println("Secret word : "
					+ secret); 
					cheated = true;
				}else{
					System.out.println("I don't know that word");
				}
			}
			System.out.print("Your Guess? ");
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
					alphabet[secret.charAt(i) - 'a'] = true;
		for (int i = 0; i < lettersInAlpha; i++)
			diffs = alphabet[i] ? diffs + 1 : diffs;
		return diffs;
	}

	

	// return # of in-place letters secret/guess
	private int countInPlaceLetters(String guess){
		int total = 0;
		for (int i = 0; i < guess.length(); i++)
			if (guess.charAt(i) == secret.charAt(i))
				total++;
		return total;
	}

	// main program, required, minimal code
	public static void main(String [] args){
		Cinco game;
		if (args.length > 0)
			game = new Cinco(args[0]);
		else
			game = new Cinco();
		game.play();
	}		
}
