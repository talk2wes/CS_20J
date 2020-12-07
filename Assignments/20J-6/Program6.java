/* Wesley Johanson	Pengo: wjohanso		talk2wes@gmail.com	
 * Filename: Program6.java
 * Assignment6: Splicer */


import java.util.Scanner;

class Program6 {
	
	public static void main(String[] args){
		System.out.print("Happy corona!!\nInitial : ");
		List myList = new List();
		myList.print();
		Scanner userInput = new Scanner(System.in);
		while (userInput.hasNextLine()){
			myList.insert(userInput.nextLine());
			System.out.print("size: " + myList.getSize() + "\t");
			myList.print();
		}
	}

}
