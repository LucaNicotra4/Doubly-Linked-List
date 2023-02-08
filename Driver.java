public class Driver {
     public static void main(String[] s){
          DoublyLinkedList list = new DoublyLinkedList();
          list = fillList();
          System.out.println(list);
          list.removeNodeAt(5);
          System.out.println(list);
          System.out.println("Size: " + list.size());
          list.toUpperCaseList();
          System.out.println(list);
          list.toLowerCaseList();
          System.out.println(list);
          System.out.println(list.toStringReverse());
     }

     public static DoublyLinkedList fillList(){
          DoublyLinkedList list = new DoublyLinkedList();
          list.add("box");
          list.add("xanax");
          list.add("jungle");
          list.add("cart");
          list.add("apple");
          list.add("company");

          return list;
     }
}
