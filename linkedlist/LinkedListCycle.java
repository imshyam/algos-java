class Node {
  int val;
  Node next;
  Node(int n) {val = n; next = null;}
}
class LinkedListCycle {
  
  static void insert(Node head, int val) {
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new Node(val);
  }

  static void print(Node head) {
    Node curr = head;
    int i = 15;
    while (i > 0 && curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
      i--;
    }
  }

  static void removeLoop(Node head, int size) {
    Node aheadBySize = head;
    while(size > 0) {
      aheadBySize = aheadBySize.next;
      size--;
    }
    Node ptrToStart = head;
    Node parent = aheadBySize;
    while(ptrToStart != aheadBySize) {
      parent = aheadBySize;
      aheadBySize = aheadBySize.next;
      ptrToStart = ptrToStart.next;
    }
    parent.next = null;
    System.out.println(parent.val);
  }

  static void findLoopAndDelete(Node head) {
    // Floyd Cycle Detect
    Node ptr = head;
    Node ptr1 = head.next.next;
    while(ptr != ptr1) {
      ptr = ptr.next;
      ptr1 = ptr1.next.next;
    }
    System.out.println("\nNode in cycle: " + ptr.val + " == " + ptr1.val);
    int circleSize = 1;
    ptr1 = ptr1.next;
    while(ptr != ptr1) {
      ptr1 = ptr1.next;
      circleSize++;
    }
    System.out.println("Circle Size: " + circleSize);
    removeLoop(head, circleSize);
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    insert(head, 2);
    insert(head, 3);
    insert(head, 4);
    insert(head, 5);
    insert(head, 6);
    insert(head, 7);
    insert(head, 8);
    Node ptr = head.next.next;
    Node endPtr = head;
    while(endPtr.next != null) {
      endPtr = endPtr.next;
    }
    endPtr.next = ptr;
    print(head);

    findLoopAndDelete(head);
    print(head);
  }
}