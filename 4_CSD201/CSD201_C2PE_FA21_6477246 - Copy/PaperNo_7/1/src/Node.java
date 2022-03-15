// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Beer info;
  Node next;
  Node() {
   }
  Node(Beer x, Node p) {
    info=x;next=p;
   }
  Node(Beer x) {
    this(x,null);
   }
 }

