// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Bell info;
  Node next;
  Node() {
   }
  Node(Bell x, Node p) {
    info=x;next=p;
   }
  Node(Bell x) {
    this(x,null);
   }
 }

