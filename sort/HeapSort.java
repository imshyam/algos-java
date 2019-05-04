public class HeapSort {
  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
  static void heapify(int[] a, int s, int e) {
    for (int i = s; (2 * i) + 1 < e; i++) {
      int leftChild = (i * 2) + 1;
      int rightChild = (i * 2) + 2;
      if (rightChild < e) {
        int index = a[leftChild] > a[rightChild] ? leftChild : rightChild;
        if (a[index] > a[i]) {
          swap(a, index, i);
          heapify(a, s, i);
        }
      }
      if (a[leftChild] > a[s]) {
        swap(a, leftChild, s);
      }
    }
  }
  static void heapSort(int[] a, int s, int e) {
    for (int i = e; i > 0; i--) {
      heapify(a, s, i);
      swap(a, s, i - 1);
    }
  }
  public static void main(String[] args) {
    
    int[] a = {3,4,6,2,4,1,94,45,323,2,234,37,432,34,23,2,34,3,4,3424,3,34,23,4,3,324,23,423,4,3};
    heapSort(a, 0, a.length);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }
}