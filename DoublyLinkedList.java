/**
 * Doubly Linked List with both prev and next pointers,
 * supporting String values
 * @author Luca Nicotra
 */
public class DoublyLinkedList {
     private Node root;
     private Node end;
     
     public DoublyLinkedList(){

     }

     /**
      * Removes a Node from a specific Index
      * @param index
      * @return String removed or ""
      */
     public String removeNodeAt(int index){
          Node temp = root;
          if(root == null) return "";
          if(index == 0){
               if(root.next == null){
                    String str = root.val;
                    root = end = null;
                    return "Removed " + str;
               }
               String str = root.val;
               root = root.next;
               root.prev = null;
               return "Removed " + str;
          }
          //Runs until reaches Node preceding index
          for(int i = 0; i < index-1; i++){
               if(temp.next == null && i+1 != index) return "";
               temp = temp.next;
          }
          if(temp.next == null) return "";
          if(temp.next.next == null){
               String str = temp.next.val;
               temp.next = null;
               end = temp;
               return "Removed " + str;
          }else{
               String str = temp.next.val;
               temp.next = temp.next.next;
               temp.next.prev = temp;
               return "Removed " + str;
          }
     }

     /**
      * Alphabetically adds a new Node to the list
      * @param data
      */
     public void add(String data){
          Node temp = root;
          if(root == null){ //Empty list
               root = new Node(data);
          }else if(root.next == null){ //List length 1
               if(data.compareTo(temp.val) < 0){
                    root = new Node(data, temp);
                    temp.prev = root;
               }else{
                    temp.next = new Node(data, null, temp);
               }
          }else{ //List length >= 2
               if(temp.val.compareTo(data) > 0){ //if goes first in list
                    root = new Node(data, temp);
                    temp.prev = root;
                    return;
               }
               while(temp.next != null){
                    if(temp.next.val.compareTo(data) > 0){
                         temp.next = new Node(data, temp.next, temp);
                         temp.next.next.prev = temp.next;
                         return;
                    }
                    temp = temp.next;
               }
               temp.next = new Node(data, null, temp);
               end = temp.next;
          }
     }

     /**
      * Removes a Node with the given value
      * @param data
      * @return T/F if object was found and removed or not
      */
     public boolean remove(String data){
          Node temp = root;
          if(root == null) return false; //if list is empty
          if((root == end) && (root.val == data)){ //if list length is 1
               root = end = null;
               return true;
          }
          while(temp.next != null){ //if list length is >= 2
               if(temp.next.val == data){
                    if(temp.next.next != null){
                         temp.next = temp.next.next;
                         temp.next.prev = temp;
                         return true;
                    }
                    temp.next = null;
                    end = temp;
                    return true;
               }
               temp = temp.next;
          }
          return false;
     }

     /**
      * Returns the index of the inputed value
      * @param string
      * @return int index of given value
      */
     public int indexOf(String string){
          if(root == null) return Integer.MIN_VALUE;
          if(root.next == null) return Integer.MIN_VALUE;
          int count = 0;
          Node temp = root;
          while(temp.next != null){
               if(temp.val.equals(string)) return count;
               count++;
               temp = temp.next;
          }
          if(temp.val.equals(string)) return count;
          return Integer.MIN_VALUE;
     }

     /**
      * Returns size of list (num Nodes)
      * @return int size
      */
     public int size(){
          Node temp = root;
          int count = 1;
          if(root == null) return 0;
          while(temp != end){
               count++;
               temp = temp.next;
          }
          return count;
     }

     /**
      * Changes each element of list to uppercase
      */
     public void toUpperCaseList(){
          Node temp = root;
          if(temp == null) return;
          while(temp != end){
               temp.val = temp.val.toUpperCase();
               temp = temp.next;
          }
          temp.val = temp.val.toUpperCase();
     }

     /**
      * Changes each element of list to lowercase
      */
     public void toLowerCaseList(){
          Node temp = root;
          if(temp == null) return;
          while(temp != end){
               temp.val = temp.val.toLowerCase();
               temp = temp.next;
          }
          temp.val = temp.val.toLowerCase();
     }

     /**
      * Prints out value of each Node
      * @return String
      */
     public String toString(){
          Node temp = root;
          if(root == null){//Length 0
               return "[Empty List]";
          }else if(root == end){//Length 1
               return "[" + temp.val + "]";
          }else{//Length 2+
               String fin = "[";
               while(temp.next!= null){
                    fin += temp.val + ", ";
                    temp = temp.next;
               }
               fin += temp.val + "]";
               return fin;
          }
     }

     /**
      * Prints of list of elements in reverse order
      * @return String
      */
     public String toStringReverse(){
          Node temp = end;
          String str = "[";
          while(temp != root){
               str += temp.val + ", ";
               temp = temp.prev;
          }
          str += temp.val + "]";
          return str;
     }
}
