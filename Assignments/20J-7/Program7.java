/* Wesley Johanson	talk2wes@gmail.com	pengo:wjohanso
 * Filename: Program7.java
 * Assignment 7: Solitare Encryption */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Program7{

	final int JOKER_A = 27;
	final int JOKER_B = 28;
	
	public static ArrayList<Integer> readDeckFile(Scanner deckFile){
		ArrayList<Integer> deck = new ArrayList<Integer>();
		return deck;
	}

	public static String encrypt(String msg){
		String encrypted = "lil booty";
			
		return encrypted;
	}

	public static String decrypt(String msg){
		String decrypted = "lil pussy";
		return decrypted;
	}
	
	public static String plaintext(String msg){
		String plaintext = "plaintext msg";
		return plaintext;
	}


	public static void main(String args[]){

		if ( args.length != 2) return ;

		try {
			//read deck from file
			Scanner deckFile = new Scanner( new File( args[1] ) );
			Scanner input = new Scanner(System.in);
			ArrayList<Integer> deck = readDeckFile(deckFile);


			//encrypt message
			if ( args[0].equals("e") ){
				System.out.println(
					"Enter message to be encrypted");
				String msg = input.nextLine();
				msg = plaintext(msg);
				System.out.println(decrypt(msg));
			}

			//decrypt message
			if ( args[0].equals("d") ){
				System.out.println(
					"Enter message to be decrypted");
				String msg = input.nextLine();
				String decrypted = decrypt(msg);	
				System.out.println(decrypted);
			}

		} catch (Exception e){ 
			System.err.println("ERROR OPENING FILE\n" + e); }
	}

}

class List{
	class LinkNode{
		private LinkNode next;
		private LinkNode prev;
		private int data;
	}
}

