/* Wesley Johanson	Pengo: wjohanso		talk2wes@gmail.com	
 * Filename: List.java
 * Assignment6: Splicer */


import java.lang.String;
import java.util.Scanner;

class List{
	class LinkNode{
		LinkNode(){ next = null; data = ""; }	
		private LinkNode	next;
		private String		data;
	}


	List(){ first = null; size = 0; }
	public int	getSize(){ return size; }
	public boolean	isEmpty(){ return (first == null); }

	public String	toString(){
		String s = "";
		return s;
	}
	public void	print(){
		LinkNode temp = first;
		System.out.print("{");
		boolean firstElemPrinted = false;

		while (temp != null){
			if (temp != first)
				System.out.print(", ");
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println("}");
	}

	public boolean 	insert(String s){
		s = upperCase(s);
		if (s.length() == 0)
			return false;
		List newList = new List();
		newList = strToList(s);
		newList.append(this);
		this.first = newList.first;
		this.size = this.size + newList.size;
		this.first = newList.first;
		return true;
	}

	public boolean splice(String find, String replace){

		return true;
	}

	public List	strToList(String inputStr){
		//make sure to invalidate weird strings
		List newList = new List();
		String str = new String(upperCase(inputStr));
		for (int i = 0; i < str.length(); i++){
			//make the new node
			LinkNode newNode = new LinkNode();
			newNode.data = str.substring(i, i + 1); 
			//System.out.println("substring: " + str.substring(i,i + 1));
			//attach first node
			if ( newList.isEmpty() ){
				newList.first = newNode;
				newList.size++;
			}else{ //append additional nodes to back of the list 
				LinkNode lastNode = new LinkNode();
				lastNode = newList.first;
				while (lastNode.next != null)
					lastNode = lastNode.next;
				lastNode.next = newNode;	
				newList.size++;
			}
		}
		return newList;
	}

	// add list 'L' to the back of this list
	public void	append(List newList){
		LinkNode lastNode = this.first;
		while (lastNode.next != null)
			lastNode = lastNode.next;
		lastNode.next = newList.first;
	}

	public void	append(LinkNode L){

	}

	public String	upperCase(String str){
		for (int i = 0; i < str.length(); i++)
			if (!Character.isLetter(str.charAt(i)))
				return "";
		return str.toUpperCase();
	}
	
	private LinkNode first;
	private int size;
}
