public class LinkedListisPalindrome {

	public static void main(String[] args) {
		
	   int arr[] = {1, 2, 3, 2, 1}; 
   	   Node head = push(arr);
        
        if (isPalindromicLinkedListWithoutExtraSpace(head)) { 
            System.out.println("Is Palindrome"); 
        } else { 
            System.out.println("Not Palindrome"); 
        }  
        
        
	}
	
	public static Node push(int arr[]) { 
		 Node head = new Node(String.valueOf(arr[0]));
		 Node current = head;
		 for (int i = 1; i< arr.length ; i++) { 
			 Node newNode = new Node(String.valueOf(arr[i]));
			 current.next = newNode;
			 current = newNode;
		 }
		 	
		 return head;
    } 
	
	public static boolean isPalindromicLinkedListWithoutExtraSpace(Node head) {
		
		if(head == null || head.next == null)
			return true;
		
	     Node slowPointer = head;
	     Node fastPointer = head;
	     Node first_half = head;
	     Node second_half = null;
	     while (fastPointer != null && fastPointer.next != null) {
	        fastPointer = fastPointer.next.next;
	        slowPointer = slowPointer.next;
	    }
	    
	    if(fastPointer != null) {
	    	slowPointer = slowPointer.next;
	    }
	    second_half = reverseUsingIteration(slowPointer);
	    
	    while (first_half != null && second_half != null) {
			if(Integer.valueOf(first_half.data) != Integer.valueOf(second_half.data)) {
				return false;
			}
			second_half = second_half.next;
			first_half = first_half.next;
		}
	    
		return true;
	}
	
	public static void printList(Node head) {
		while (head != null) {
			System.out.print("->"+head.getData());
			head = head.getNext();
	    }
		System.out.println();
	}
}