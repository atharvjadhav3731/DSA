public class linklist02 {
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
    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1 move
            fast = fast.next.next;
            if(slow == fast){
                return true; // cycle exist
            }
        
        }
        return false;
    }
    public static void removecycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1 move
            fast = fast.next.next; //+2 move
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        // find slow and fast meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next ;//+1move
            fast = fast.next; //+1 move
            }
            // remove cycle
            prev.next = null;
        }
    private Node getmid(Node head){
            if(head == null){
                return null;
            }
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;  
        }
    private Node merge(Node lefthead, Node righthead){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while( lefthead != null && righthead != null){
            if(lefthead.data <= righthead.data){
                temp.next = lefthead;
                lefthead = lefthead.next;
                temp = temp.next;
            }else{
                temp.next = righthead;
                righthead = righthead.next;
                temp = temp.next;
            }
            while(lefthead != null){
                temp.next = lefthead;
                lefthead = lefthead.next;
                temp = temp.next;    
            }
            while(righthead != null){
                temp.next = righthead;
                righthead = righthead.next;
                temp = temp.next;    
            }
        }
        return mergeLL.next;
        
    }        
    public Node mergesort(Node head){
        if(head == null || head.next == null){
            return head;
        }
    //find mid
        Node mid = getmid(head);    
    //left and right merger sort
        Node righthead = mid.next;
        mid.next = null;
        Node newLeft = mergesort(head);
        Node newRight = mergesort(righthead);
    //merge
        return merge(newLeft,newRight);
    }  
    // ZIG-ZAG
    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next  = prev;
            prev = curr;
            curr = next;
        } 
        Node left = head;
        Node right = prev;
        Node nextL,nextR;     
        // alternatmerge - zigzag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }  
        }                  
    public static void main(String[] args){
        
      //  head = new Node(1);
        //Node temp = new Node(2);
     //   head.next = temp;
      //  head.next.next = new Node(3);   
       // head.next.next.next = temp;         
      //  System.out.println(iscycle());
        //removecycle();
       // System.out.println(iscycle());
        linklist02 ll = new linklist02();
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3); 
        ll.addfirst(2);
        ll.addfirst(1);
        ll.print();
      //  ll.head = ll.mergesort(ll.head);
        ll.zigzag();
        ll.print();
} 
}

    
    


    
