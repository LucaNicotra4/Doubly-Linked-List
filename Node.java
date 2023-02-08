public class Node{
     protected String val;
     protected Node next;
     protected Node prev;

     public Node(String val){
          this.val = val;
     }

     public Node(String val, Node next){
          this.val = val;
          this.next = next;
     }

     public Node(String val, Node next, Node prev){
          this.val = val;
          this.next = next;
          this.prev = prev;
     }
}