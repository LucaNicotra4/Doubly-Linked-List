public class DoublyLinkedList {
     private Node root;
     private Node end;
     
     public DoublyLinkedList(){

     }

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

     public void toUpperCaseList(){
          Node temp = root;
          if(temp == null) return;
          while(temp != end){
               temp.val = temp.val.toUpperCase();
               temp = temp.next;
          }
          temp.val = temp.val.toUpperCase();
     }

     public void toLowerCaseList(){
          Node temp = root;
          if(temp == null) return;
          while(temp != end){
               temp.val = temp.val.toLowerCase();
               temp = temp.next;
          }
          temp.val = temp.val.toLowerCase();
     }

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
