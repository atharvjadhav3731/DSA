public class linklist01 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
     }
     public static Node head;
     public static Node tail;
     public static int size;
     public void addfirst(int data){           //time complexicity O(1) = constant
        // step 1 = creat a new node               
        Node newnode = new Node(data);
        size++;
          if(head == null){
            head = tail = newnode;
            return;
        } 
        //step 2 = newnode next = head
        newnode.next = head;
        //step 3 = newnode = head
        head = newnode;
      }
      public void addlast(int data){       //time complexicity O(1) = constant
        // crate a new node
        Node newnode = new Node(data); 
        size++;
        if(head == null){
            head = tail = null;
            return;
        }
        // put next of tail to newnode
        tail.next = newnode;
        // newnode = tail
        tail = newnode;
      }
      public void print(){  //O(n)
        if(head == null){
            System.out.println("link list is empty");
        }
        Node temp = head;
        while(temp != null ){
            System.out.print(temp.data +" -> ");
            temp = temp.next;
         }
         System.out.println(" null");

      }
      public void add(int idx, int data){
        Node newnode = new Node(data);
        size ++;
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            temp = temp.next;
            i++ ;
        }
        // i = idx -1; temp -> prev
        newnode.next = temp.next;
        temp.next = newnode;
      }
      public int removeFirst(){
        if(size == 0){
            System.out.println("linklist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
      }
      public int removelast(){
        if(size == 0){
            System.out.println("linklist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
             head = tail = null;
            size = 0;
            return val;
        }
        //previous : i =  size - 2
        Node previous = head;
        for(int i = 0 ; i < size - 2; i++){
            previous = previous.next;
        }
        int val = previous.next.data; //tail.next also
        previous.next = null;
        tail = previous;
        size-- ; 
        return val;
    }
    public int search(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){ // key found case
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1; //key not found case
    }
    // recursive search
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        } 
        return idx+1;

    }
    public int recsearch(int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev = null;
        Node current = tail = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        head = prev;
    }
    // delete nth node from last
    public void deleteNth(int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            head = head.next; //delete head condition
            return;

        }
        int i = 1;
        int itofind = size - n;
        Node prev = head;
        while(i <itofind){
            prev = prev.next;
            i++;        
        }
        prev.next = prev.next.next;
        }
        //slow fast approch
    public Node findMid(Node head) {
        if (head == null) {
        return null;
    }
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;   // middle node
    }
    // palindrom
    public  boolean checkpalindrom(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1 = find mid
        Node midnode = findMid(head);
        //step 2 = reverse 2nd half
        Node prev = null;
        Node current = midnode;
        Node next;
        while(current != null){
            next = current;
            current.next = prev;
            prev = current;
            current = next; 
        }
        Node right = prev;
        Node left = head;
        // step 3 = check left is equal to right 
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        } 
        return true;
    }
    // cycle present or not
    public static boolean iscycle(){
         Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
            if(slow == fast){
                return true; // cycle exist
            }
            return false ; // cycle does not exist
            }
    
    public static void main(String args[]){
       // linklist01 ll = new linklist01();
        //ll.print();
        //ll.addfirst(1);
       // ll.print();
      //  ll.addfirst(2);
      //  ll.print();
       //ll.addlast(3);
        //ll.print();
        //ll.addlast(4);
        //ll.print();
       // ll.add(1,9);
        //ll.print();
        //System.out.println(ll.size);
        //ll.removeFirst();
        //ll.print();
       // ll.removelast();
       // ll.print();
       // System.out.println(ll.size);
       // System.out.println(ll.search(9));
       // System.out.println(ll.search(10)); 
        //System.out.println(ll.recsearch(3));
        //System.out.println(ll.recsearch(10));
        //ll.reverse();
        //ll.print();
        //ll.deleteNth(3);
        //ll.print();
        //ll.addfirst(1);
        //ll.addfirst(2);
        //ll.addfirst(3);
        //ll.addfirst(2);
        //ll.addfirst(1);
        //ll.print();
        //System.out.println(ll.checkpalindrom());
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node (1);
        System.out.println(iscycle());
      

    }
}
    
    
