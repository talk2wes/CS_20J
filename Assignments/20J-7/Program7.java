/* Wesley Johanson	talk2wes@gmail.com	pengo:wjohanso
 * Filename: Program7.java
 * Assignment 7: Solitare Encryption */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.StringBuilder;

class Program7{

	static final int JOKER_A = 27;
	static final int JOKER_B = 28;
	static final int LET_IN_ALPHA = 26;
	static final int GROUP_SIZE = 5;
	
	//string to ascii vals 
	public static int[] strToIntArr(String msg){
		int[] asciiValues = new int[msg.length()];
		for (int i = 0; i < msg.length(); i++)
			asciiValues[i] = msg.charAt(i);
		return asciiValues;
	}

	//converts int array of ascii values to string 
	public static String intArrToStr(int[] asciiValues){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < asciiValues.length ; i++){
			str.append((char) asciiValues[i]);
		}
		return str.toString();
	}

	//encrypt the message
	public static String encrypt(String msg, List deck){
		int[] asciiValues = strToIntArr(msg);
		int[] keystreamValues = deck.genKeystream(msg.length());
		int[] encrypted = new int[msg.length()];	
		for (int i = 0; i < msg.length(); i++){
			encrypted[i] = asciiValues[i] + keystreamValues[i];
			encrypted[i] = encrypted[i] % LET_IN_ALPHA;
			encrypted[i] += (int) 'A';
		}
		return intArrToStr(encrypted); 
	}

	//decrpt the message 
	public static String decrypt(String msg, List deck){
		int[] asciiValues = strToIntArr(msg);
		int[] keystreamValues = deck.genKeystream(msg.length());
		int[] decrypted = new int[msg.length()];	
		for (int i = 0; i < msg.length(); i++){
			decrypted[i] = asciiValues[i] - keystreamValues[i];
			decrypted[i] = decrypted[i] % LET_IN_ALPHA;
			decrypted[i] += (int) 'A';
		}
		return intArrToStr(decrypted);
	}

	//Convert the message to plaintext (only uppercase letters)
	public static String plaintext(String msg){
		StringBuilder plaintext = new StringBuilder();
		//Add all alphabetical characters
		for (int i = 0; i < msg.length() ; i++)
			if (Character.isLetter(msg.charAt(i)))
				plaintext.append(msg.charAt(i));
		//add padding to make string lenth a multiple of 5
		int paddingChars = (plaintext.length() % GROUP_SIZE == 0) ?
			0 : GROUP_SIZE - plaintext.length() % GROUP_SIZE;
		for (int i = 0; i < paddingChars ; i++)	plaintext.append("X");
		//convert to upper case and return
		System.out.println("Plaintext message is: " + 
			plaintext.toString().toUpperCase());
		return (plaintext.toString()).toUpperCase();
	}

	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		String deckFileName = "";
		
		if (args.length == 1 && 
			(args[0].equals("e") || args[0].equals("d"))){
				System.out.print("what is the filename" +
					" of the deck? ");
				deckFileName = input.nextLine();
		}

				
		if ( args.length != 2)
			System.out.println(
				"usage: java Program7 [e OR d] [deckFileName]");
		try {
			//Load the deck from the deckFile 
			if (deckFileName.equals("")){ deckFileName = args[1]; }
			Scanner deckFile = new Scanner( new File( deckFileName));//args[1] ) );
			//Scanner input = new Scanner(System.in);
			List deck = new List();
			deck = List.readDeckFile(deckFile);
			deckFile.close();
			//encrypt message
			if ( args[0].equals("e") ){
				System.out.println(
					"Enter message to be encrypted" +
					" (non-letters ignored)");
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
			input.close();
		} catch (Exception e){ 
			System.err.println("ERROR OPENING FILE\n" + e); }
	}
}

class List{
	protected LinkNode head;
	protected LinkNode tail;
	static final int JOKER_A = 27;
	static final int JOKER_B = 28;
	static final int LET_IN_ALPHA = 26;

	List(){ head = tail = null; }

	public int[] genKeystream(int numOfValues){
		int[] keystreamValues = new int[numOfValues];
		for (int i = 0; i < numOfValues; i++)
			keystreamValues[i] = this.genKeystream();
		return keystreamValues;
	}
	
	public static List readDeckFile(Scanner deckFile){
		List deck = new List();
		String[] numbers = (deckFile.nextLine()).split(" ");
		for (String num : numbers)
			deck.addNodeBack(Integer.parseInt(num));
		return deck;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		if (head == null)
			return null;
		LinkNode temp = head;
		while (temp != null){
			s.append(temp.data);
			s.append(" ");
			temp = temp.next;
		}
		return s.toString();
	}

	//Swaps the node "swap" with the node that is next 
	public void swapNext(LinkNode swap){
		//calculate the size of the list
		int size = 0;
		LinkNode temp = head;
		while (temp != null){ size++; temp = temp.next;	}

		//Undefined operation: ERROR 
		if (swap == null || size < 2 ) return ;
	
		//put a handle on the next node to swap with
		LinkNode swapNext = swap.next;

		//Case: swapNext exists
		if (swapNext != null){
			//make references to the nodes before and after the swap nodes
			LinkNode left = swap.prev;
			LinkNode right = swapNext.next;
		
			//link the two swap nodes together
			swapNext.next = swap;
			swap.prev = swapNext;

			//Connect the swap-nodes to the rest of the list, if they exist
			//reassign head & tail if they changed 
			swapNext.prev = left;
			if (left != null) 
				left.next = swapNext;
			else
				head = swapNext;
			swap.next = right;
			if (right != null) 
				right.prev = swap;
			else
				tail = swap;
		}else{ //Case: swapNode doesn't exist. Swap with head instead
			swapNext = head;
			if (size == 2){ 
				tail = swapNext.next = swap;
				head = swap.prev = swapNext;
				swapNext.prev = swap.next = null;
			}else if (size == 3){
				LinkNode body = swapNext.next;
				//link the body to the terminal nodes 
				tail = body.next = swap;
				head = body.prev = swapNext;
				//Link the terminal nodes to the body
				swapNext.next = swap.prev = body;
				//set the ends of the list to null
				swapNext.prev = swap.next = null;
			}else if (size > 3) {
				//Make references to terminal ends of the body
				LinkNode left = head.next;
				LinkNode right = tail.prev;
				
				//link the body to the terminal nodes
				//reassign head & tail
				head = left.prev = swap;
				tail = right.next = swapNext;
				
				//link the swap-nodes to the body
				swap.next = left;
				swapNext.prev = right;

				//set the new ends to null
				swap.prev = swapNext.next = null;
			}
		}
		return;
	}

	public void tripleCut(){
		//find the first joker(left)
		LinkNode jokerL = head;
		while (jokerL.data != JOKER_A && jokerL.data != JOKER_B)
			jokerL = jokerL.next;
		//find the second joker(right)
		LinkNode jokerR = jokerL.next;
		while (jokerR.data != JOKER_A && jokerR.data != JOKER_B)
			jokerR = jokerR.next;
		//put refs on ends of the left & right sides of the deck
		LinkNode rHead = jokerR.next;
		LinkNode lTail = jokerL.prev;
		//if neither end exists, do nothing 
		if (lTail == null && rHead == null) return ;
		//if both sides exist 
		if (lTail != null && rHead != null){
			//attach the previous right-side to the left-joker
			tail.next = jokerL;
			jokerL.prev = tail;
			rHead.prev = null;

			//attach the previous left-side to the right-joker
			jokerR.next = head;
			head.prev = jokerR;
			lTail.next = null;
			
			//reassign the head and tail 
			head = rHead;
			tail = lTail;
		}else{ 
			tail.next = head;
			head.prev = tail;
			//if no left side
			if (lTail == null){ 
				jokerR.next = rHead.prev = null;
				head = rHead;
				tail = jokerR;
			//if no right side
			}else{
				jokerL.prev = lTail.next = null;
				head = jokerL;
				tail = lTail;
			}
		}
	}

	public void step1(){
		LinkNode joker = this.head;	
		//find the joker
		while (joker.data != JOKER_A)
			joker = joker.next;
		swapNext(joker);	
		return;
	}

	public void step2(){
		LinkNode joker = this.head;
		while (joker.data != JOKER_B)
			joker = joker.next;
		swapNext(joker);
		swapNext(joker);
	}
	
	public void step4(){
		LinkNode bottomCard = tail;
		//determine how many top cards to move to bottom;
		int topCards = bottomCard.data;
		if (topCards == JOKER_A || topCards == JOKER_B)
			topCards = JOKER_A;
		//put a ref on the lTail 
		LinkNode lTail = head;
		for (int i = 1; i < topCards; i++)
			lTail = lTail.next;
		//connect the middle of the new list
		tail.next = head;
		head.prev = tail;
		//reassign head to the head of the new list 
		head = lTail.next;
		//set the ends of the new list to null
		head.prev = null;
		lTail.next = null;
		//move the bottom card to the bottom
		while (bottomCard.next != null)
			swapNext(bottomCard);
	}
	
	public int step5(){
		LinkNode card = head;
		int i = (head.data == JOKER_B) ? JOKER_A : head.data;
		while (i > 1) { card = card.next; i--; }
		return (card.next.data);	
	}

	public int genKeystream(){
		int result;
		do{
			step1();
			step2();
			tripleCut();	
			step4();
			result = step5();
		}while (result == JOKER_A || result == JOKER_B);
		return result;
	}
	//add node to tail end of the list
	public void addNodeBack(int data){
		LinkNode newNode = new LinkNode();
		//empty list case
		if (head == null && tail == null){
			newNode.data = data;
			head = tail = newNode;
			return;
		}
		//list size == 1 case 
		if (head == tail){
			head.next = newNode;
			tail = newNode;
			newNode.data = data;
			newNode.prev = head;
			return;
		}
		//list size >= 2 case 
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		newNode.data = data;
		return;
	}

	protected class LinkNode{
		public LinkNode(){next = prev = null; data = 0; }
		public LinkNode getNext(){ return next; }
		protected LinkNode next;
		protected LinkNode prev;
		protected int data;
	}
}
