class Node {
  int val;
  Node next;
  Node(int n) {val = n; next = null;}
}
class MergeSortLinkedList {
  static void print(Node head) {
    Node curr = head;
    int i = 15;
    while (i > 0 && curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
      i--;
    }
  }
  static void insert(Node head, int val) {
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = new Node(val);
  }
  static Node getMiddle(Node head) {
    if (head == null) {
      return head;
    }
    Node slow = head;
    Node fast = head.next;
    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
        slow = slow.next;
      }
    }
    return slow;
  } 
  static Node merge(Node left, Node right) {
    System.out.println();
    print(left);
    System.out.println();
    print(right);
    System.out.println("\n--------------------------");
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    Node head;
    if(left.val < right.val) {
      head = left;
      head.next = merge(left.next, right);
    } else {
      head = right;
      head.next = merge(left, right.next);
    }
    return head;
  }
  static Node mergeSort(Node head) {
    if(head == null || head.next == null) {
      return head;
    }
    // Split into left and right
    Node mid = getMiddle(head);
    Node right = mid.next;
    mid.next = null;
    Node x = mergeSort(head);
    Node y = mergeSort(right);
    return merge(x, y);
  }
  public static void main(String[] args) {
    Node head = new Node(34);
    insert(head, 22);
    insert(head, 13);
    insert(head, 44);
    insert(head, 45);
    print(head);
    head = mergeSort(head);
    print(head);
  }
}