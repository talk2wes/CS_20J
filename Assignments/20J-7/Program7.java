/* Wesley Johanson	talk2wes@gmail.com	pengo:wjohanso
 * Filename: Program7.java
 * Assignment 7: Solitare Encryption */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.StringBuilder;

class Program7{

	final int JOKER_A = 27;
	final int JOKER_B = 28;
	
	public static List readDeckFile(Scanner deckFile){
		List deck = new List();
		return deck;
	}
	
	//string to ascii vals 
	public static int[] strToIntArr(String msg){
		int[] asciiValues = new int[msg.length()];
		for (int i = 0; i < msg.length(); i++){
			asciiValues[i] = msg.charAt(i);
			System.out.println(asciiValues[i]);
		}
		return asciiValues;
	}

	// ascii to string 
	public static String intArrToStr(int[] asciiValues){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < asciiValues.length ; i++){
			str.append((char) asciiValues[i]);
		}
		return str.toString();
	}

	public static String encrypt(String msg, List deck){
		String encrypted = "";
		int[] asciiValues = strToIntArr(msg);
		int[] keystreamValues = genKeystream(deck, msg.length());
		
		encrypted = intArrToStr(asciiValues);	
		return encrypted ; //testing  
	}

	public static String decrypt(String msg, List deck){
		String decrypted = "lil pussy";
		return decrypted;
	}
	
	public static String plaintext(String msg){
		StringBuilder plaintext = new StringBuilder();
		for (int i = 0; i < msg.length() ; i++){
			char msgChar = msg.charAt(i);
			if (Character.isLetter(msgChar))
				plaintext.append(msgChar);
		}
		//System.out.println("length = " + plaintext.length());
		int paddingChars =  5 - plaintext.length() % 5;
		for (int i = 0; i < paddingChars ; i++)
			plaintext.append("X");
		return (plaintext.toString()).toUpperCase();
	}

	public static int[] genKeystream(List deck, int numOfValues){
		int[] keystreamValues = new int[numOfValues];
		return keystreamValues;
	}
	
	public static int genKeystream(List deck){
		//step 1 
		//step 2
		//step 3
		//step 4
		//step 5

		return -1;
	}

	public static void main(String args[]){

		if ( args.length != 2) return ;

		try {
			//read deck from file
			Scanner deckFile = new Scanner( new File( args[1] ) );
			Scanner input = new Scanner(System.in);
			List deck = new List();

			//encrypt message
			if ( args[0].equals("e") ){
				System.out.println(
					"Enter message to be encrypted");
				System.out.println("The encrypted message is: "
					+ encrypt( 
					plaintext( input.nextLine() ), deck) );
			}

			//decrypt message
			if ( args[0].equals("d") ){
				System.out.println(
					"Enter message to be decrypted");
				System.out.println("The decrypted message is: "
					+ decrypt(input.nextLine(), deck) );
			}

		} catch (Exception e){ 
			System.err.println("ERROR OPENING FILE\n" + e); }
	}
}

class List{
	private LinkNode head;
	private LinkNode tail;

	List(){ head = tail = null; }

	//add node to tail end of the list
	public void addNodeBack(int data){
	}

	class LinkNode{
		private LinkNode next;
		private LinkNode prev;
		private int data;
	}
}

