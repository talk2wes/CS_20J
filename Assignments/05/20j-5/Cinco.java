/* Wesley Johanson	Pengo: wjohanso		talk2wes@gmail.com
 * Filename: Cinco.Java
 * Assignment 5: Cinco game
 *
 * Status: working and tested. I have NOT implemented the case sensitivity yet.
 * The code will not find any word in the dictionary if spelt with capital 
 * letters.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * In this game, the computer will pick a (random) secret five letter word from
 * its Dictionary. A human player guesses a word. A word is only a legal guess
 * if it appears in the Dictionary. A word is only a legal secret word if it 
 * appears in the Dictionary and is also comprised of five different distinct 
 * letters */

class Dictionary{
	private HashSet<String> words;
	private ArrayList<String> secrets;
	private Random rng;

	// Default Constructor
	public Dictionary(String filename){
		//I should probably use the time class for better randoms 
		rng = new Random();
		words = new HashSet<String>();
		secrets = new ArrayList<String>();
		String temp = "";

		try{
			Scanner fin = new Scanner(new File(filename));
			while (fin.hasNextLine()){
				temp = fin.nextLine();
				words.add(temp);
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

	/* returns true if the word is an element of the dictionary*/
	public boolean validWord(String word){ return words.contains(word); }

	/* Returns a legal secret word from the dictionary object */
	public String getLegalSecretWord(){
		return secrets.get(rng.nextInt(secrets.size()));
	}

	/* Returns true if the word is a legal secret word. (i.e. 5 letters, no
	 * repeating characters, is element of dictionary)*/
	private boolean isLegalSecretWord(String word){
		for (int i = 0; i < word.length(); i++){
			for (int j = 0; j < word.length(); j++)
				if (i != j && word.charAt(i) == word.charAt(j))
					return false;
		}
		return true;
	}
}

//Class that uses dictionary and runs the game
class Cinco{
	int numguesses;
	boolean cheated;
	String secret ;
	Dictionary dictionary;
	private String defaultFilename = "cinco-words.txt";

	//Default Constructor
	public Cinco(){
		dictionary  =  new Dictionary(defaultFilename);	
		secret = dictionary.getLegalSecretWord();
		numguesses = 0;
		cheated = false;
	}

	//Overloaded constructor for custom files
	public Cinco(String filename){  //make sure this one works
		dictionary  =  new Dictionary(filename);	
		secret = dictionary.getLegalSecretWord();
		numguesses = 0;
		cheated = false;
	}

	//Primary game loop that the game runs in
	public void play(){
		System.out.print("Cinco! Assignment 5\n" +
			"by Wesley Johanson\n" +
			"I'm thinking of a five letter word...\n" +
			"your guess? ");
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()){
			String myInput = input.nextLine();
			if (dictionary.validWord(myInput)){ //valid words
				numguesses++;
				if (countMatchingLetters(myInput) == 5 && 
					countInPlaceLetters(myInput) == 5){
					System.out.println(
					"Correct! You got it in " + 
					numguesses + " guesses.");
					if (cheated)
						System.out.println("but only by"
						+ " cheating");
					return; //Correct Guess
				}
				System.out.println("Matching: " + 
					countMatchingLetters(myInput) +
					"\nIn-Place: " +
					countInPlaceLetters(myInput)); 
			}else{ //invalid words
				if (myInput.equals("xxxxx")){//cheat
					numguesses++;
					System.out.println("Secret word : "
					+ secret); 
					cheated = true;
				}else{
					System.out.println(
					"I don't know that word");
				}
			}
			System.out.print("Your Guess? ");
		}
	}

	// return # of matching letters in both secret & guess
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

	// return # of in-place letters in both secret & guess
	private int countInPlaceLetters(String guess){
		int total = 0;
		for (int i = 0; i < guess.length(); i++)
			if (guess.charAt(i) == secret.charAt(i))
				total++;
		return total;
	}

	// main function, just to initiate the program
	public static void main(String [] args){
		Cinco game;
		if (args.length > 0)
			game = new Cinco(args[0]);
		else
			game = new Cinco();
		game.play();
	}		
}
