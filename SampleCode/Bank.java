import java.util.*;

public class Bank {
	private static LinkedList<String> firstName = new LinkedList<String>();
	private static LinkedList<String> lastName = new LinkedList<String>();
	private static LinkedList<String> bankAccount = new LinkedList<String>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		begin();
	}
	public static void begin(){
				System.out.println("\n a: Show all records" 
				+ "\n r: Remove the current record"
				+ "\n f: Change the first name in current record"
				+ "\n l: Change the last name in current record"
				+ "\n n: Add a new record"
				+ "\n d: Make a Deposit"
				+ "\n w: Make a Withdrawl"
				+ "\n q: Quit"
			    + "\n s: Select a record from the list to become current record"
			    + "\n Enter a command from the list above (q to quit): ");
				String m;
				m = sc.next();
				char p = m.charAt(0);
				switch(p){
				case 'a': showAll();
				case 'r': removeRecord();
				case 'f': changeFirst();
				case 'l': changeLast(); 
				case 'n': newRecord();
				case 'd': deposit();
				case 'w': withdrawl();
				case 'q': quit();
				case 's': selectRecord();
				default: System.out.println("Invalid Character");
			
				}
	}
	public static void quit() {
		System.out.println("Thanks For Using Haro Banking!");
		System.exit(0);
		
	}
	public static void showAll(){
					bankList list = new bankList();
					for (int i = 0; i < firstName.size(); i++ ) {
						bankNode node = new bankNode();
						node.setData(firstName.get(i), lastName.get(i), bankAccount.get(i));
						list.insertTwo(node);
					}
					list.print();
					begin();
	}
	public static void newRecord(){
					System.out.print("Enter first name: ");
					String first = sc.next();
					System.out.print("Enter last name: ");
					String last = sc.next();
					System.out.print("Enter Account Balance: ");
					String number = sc.next();
					firstName.add(first);
					lastName.add(last);
					bankAccount.add(number);
					System.out.print("Current record is: " + last + ", " + first
							+ ". Balance = " + number);
					begin();
	}
	public static void removeRecord(){
					System.out.println("Removing... " + firstName.getLast() + " " 
	+ lastName.getLast() + " " + bankAccount.getLast());
					firstName.removeLast();
					lastName.removeLast();
					bankAccount.removeLast();
					System.out.println("Succesfully Removed.");
					begin();
	}
	public static void changeFirst(){
					try {
					String change;
					System.out.print("Enter new first name: ");
					change = sc.next();
					int findLast = firstName.lastIndexOf(firstName.getLast());
					firstName.set(findLast, change);
					System.out.println("Current record is: " + lastName.getLast() 
							+ ", " + firstName.getLast() + ". Balance = " + bankAccount.getLast());
					} catch (NoSuchElementException ex) {
						System.out.println("No Record Found");
					}
					begin();
	}
	public static void changeLast(){
					String change1;
					System.out.print("Enter new last name: ");
					change1 = sc.next();
					int findLast1 = lastName.lastIndexOf(lastName.getLast());
					lastName.set(findLast1, change1);
					System.out.println("Current record is: " + lastName.getLast() 
							+ ", " + firstName.getLast() + ". Balance = " + bankAccount.getLast());
					begin();
	}
	public static void withdrawl(){
		int w;
		System.out.print("How much would you like to withdrawl?: ");
		w = sc.nextInt();
		int findLast = bankAccount.lastIndexOf(bankAccount.getLast());
		int original = Integer.parseInt(bankAccount.getLast());
		if(original < w){
			System.out.println("Insufficient Funds.");
			begin();
		}else{
			original -=w;
		}
		String x = String.valueOf(original);
		bankAccount.set(findLast, x);
		System.out.println("Current Record is: " + lastName.getLast() + ", "
				+ firstName.getLast() + ". Balance = " + bankAccount.getLast());
		begin();
	}
	public static void deposit(){
		int d;
		System.out.print("How much would you like to deposit?: ");
		d = sc.nextInt();
		int findLast = bankAccount.lastIndexOf(bankAccount.getLast());
		int original = Integer.parseInt(bankAccount.getLast());
		original +=d;
		String x = String.valueOf(original);
		bankAccount.set(findLast, x);
		System.out.println("Current Record is: " + lastName.getLast() + ", "
				+ firstName.getLast() + ". Balance = " + bankAccount.getLast());
		begin();
	}
					
	public static void selectRecord(){
					String search1;
					String search2;
					System.out.print("Enter first name: ");
					search1 = sc.next();
					System.out.print("Enter last name: ");
					search2 = sc.next();
					if(lastName.contains(search2) != true) {
						System.out.println("Not in record");
						begin();
					} else {
					int indexfirst = firstName.indexOf(search1);
					firstName.addLast(firstName.get(indexfirst));
					firstName.remove(indexfirst);
					int indexlast = lastName.indexOf(search2);
					lastName.addLast(lastName.get(indexlast));
					lastName.remove(indexlast);
					bankAccount.addLast(bankAccount.get(indexfirst));
					bankAccount.remove(indexfirst);
					System.out.println("Current record is: " + lastName.getLast() 
							+ ", " + firstName.getLast() + ". Balance = " + bankAccount.getLast());
						}
					begin();
	}
	}

//----------------------------------------------------------------------------
 class bankNode {
	private String firstName, lastName, balance, name;
	private bankNode next, prev;

	public bankNode() {
		
	}
	
	public bankNode(String firstname, String lastname, String b) {
		this.firstName = firstname;
		this.lastName = lastname;
		balance = b;
		name = firstName + " " + lastName;
		next = null;
	}
	
	public void setData(String firstname, String lastname, String b) {
		this.firstName = firstname;
		this.lastName = lastname;
		balance = b;
		name = firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setNext(bankNode v) {
		next = v;
	}
	
	public void setPrev(bankNode v) {
		prev = v;
	}
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public void setLastName(String ln) {
		lastName = ln;
	}	
	public bankNode getNext() {
		return next;
	}
	
	public bankNode getPrev() {
		return prev;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String toString() {
		return name + " " + balance;
	}
	
	public String uString() {
		return firstName + "             " + lastName + "                  " + balance;
	}
}
 //------------------------------------------------------------------------
 
  class bankList extends LinkedList<String>{
	  private static final long serialVersionUID = 1L;
		private bankNode head;
		
		public bankList() {
			head = null;
		}
		
		public boolean isEmpty() {
			return head == null;
		}
		
		public bankNode findInsertionPoint(bankNode head, bankNode node) {
			if (head == null || node.getLastName().compareTo(head.getLastName()) < 0)
				return null;
			bankNode curr = head;
			while (curr != null) {
				if (curr.getLastName().compareTo(node.getLastName()) == 0)
					return curr;
				else if(curr.getNext() == null || curr.getNext().getLastName().compareTo(node.getLastName()) > 0)
					return curr;
				else 
					curr = curr.getNext();
			}
			return null;
		}
		
		public void insertTwo(bankNode node) {
			bankNode newNode = node;
			bankNode insertPoint = this.findInsertionPoint(this.head, node);
			if (insertPoint == null){
				newNode.setNext(this.head);
				this.head = newNode;
			} else {
				if (insertPoint.getLastName().compareTo(node.getLastName()) == 0) {
					insertPoint.setNext(insertPoint.getNext());
				} else
					newNode.setNext(insertPoint.getNext());
					insertPoint.setNext(newNode);
			}
		}
		
		
		public String remove(String name) {
			if (isEmpty())
				return "Bank List is empty.";
			bankNode current = head;
			bankNode previous = null;
			if (current.getName().equals(name)) {
				head = current.getNext();
				return "Removed " + current.toString();
			}
			while ((current.getNext() != null) && (!current.getName().equals(name))) {
				previous = current;
				current = current.getNext();
			}
			if (current.getName().equals(name)) {
				previous.setNext(current.getNext());
				return "Removed " + current.toString();
			} else
				return ("Sorry. No entry for " + name);
		}
		
		public void print() {
			bankNode current = head;
			System.out.println("First Name          Last Name                      Balance");
			System.out.println(" ");
			System.out.println("----------          ---------                      --------");
			while (current != null) {
				System.out.println(current.uString());
				current = current.getNext();
			}
		}
	}
	 
	 
	 
	 
	 
 
 
 
 
 
 
