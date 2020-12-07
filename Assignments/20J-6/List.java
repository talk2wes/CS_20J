/* Wesley Johanson	Pengo: wjohanso		talk2wes@gmail.com	
 * Filename: List.java
 * Assignment6: Splicer */


import java.lang.String;
import java.lang.StringBuilder;
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
		StringBuilder s = new StringBuilder();
		
		//add size
		s.append("(");
		s.append(this.size);
		s.append(")");
		//add all the letters
		LinkNode temp = this.first;
		while(temp != null){
			s.append(temp.data);
			temp = temp.next;
		}
		return s.toString();
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
		LinkNode tempNode = this.first;
		LinkNode prev = null;
		find = upperCase(find);
		replace = upperCase(replace);
		boolean	successfulSplice = false;
		
		//invalid string || extra credit 
		if (find.length() == 0 || find.length() > 1)
			return false;

		while (tempNode != null){
				
			//the node being searched for was found
			if (tempNode.data.equals(find)){
				successfulSplice = true;
				if (replace.length() == 0){ //delete node case
					if (prev == null){ //del head node
						this.first = tempNode.next;
						tempNode = this.first;
						this.size--;
					}else if (tempNode.next == null){ //del tail node
						prev.next = null;
						tempNode = prev;
						this.size--;
					}else{ //del middle node 
						prev.next = tempNode.next;
						tempNode = prev;
						this.size--;
					}
				}else{ //replace node case
					List tempList = new List();
					tempList = strToList(replace);
					//replace the character with new node
					if (prev == null) //replace head node
						this.first = tempList.first;
					else //replace body/tail node
						prev.next = tempList.first;

					// get prev in the correct position
					prev = tempList.first;
					while (prev.next != null)
						prev = prev.next; 
					tempList.append(tempNode.next);
					tempNode = prev;
					this.size += tempList.size - 1;
					//clean up 
					tempList.first = null;
					tempList = null;
				}
			}
			//increment and check the next node 
			if (size < 2)
				prev = null;
			else{
				prev = tempNode;
				tempNode = tempNode.next;
			}
		}
		return successfulSplice;
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
		LinkNode lastNode = this.first;
		while (lastNode.next != null)
			lastNode = lastNode.next;
		lastNode.next = L; 

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
