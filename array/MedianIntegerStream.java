class MedianIntegerStream {

  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  static void minHeapify(int[] a, int n) {
    for (int i = 0; i < n / 2; i++) {
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      int min = l;
      if (r < n)
        min = a[l] < a[r] ? l : r;
      boolean update = a[min] < a[i];
      if (update) {
        swap(a, min, i);
        minHeapify(a, i);
      }
    }
  }

  static void maxHeapify(int[] a, int n) {
    for (int i = 0; i < n / 2; i++) {
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      int max = l;
      if (r < n)
        max = a[l] > a[r] ? l : r;
      boolean update = a[max] > a[i];
      if (update) {
        swap(a, max, i);
        maxHeapify(a, i);
      }
    }
  }

  static void print(int[] a, int index, double median) {
    for (int i = 0; i <= index; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println(" => " + median);
  }

  static void printHeap(int[] a, int n) {
    System.out.println("HEAP: ");
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  static void streamMedian(int[] a, int n) {
    int[] leftHeap = new int[n];
    int sizeLeftHeap = 0;
    int[] rightHeap = new int[n];
    int sizeRightHeap = 0;
    for (int i = 0; i < n; i++) {
      if (sizeLeftHeap > sizeRightHeap) {
        if (a[i] >= leftHeap[0]) {
          rightHeap[sizeRightHeap++] = a[i];
        } else {
          rightHeap[sizeRightHeap++] = leftHeap[0];
          leftHeap[0] = a[i];
          maxHeapify(leftHeap, sizeLeftHeap);
        }
        minHeapify(rightHeap, sizeRightHeap);
      } else {
        leftHeap[sizeLeftHeap++] = a[i];
        maxHeapify(leftHeap, sizeLeftHeap);
      }
      // printHeap(leftHeap, sizeLeftHeap);
      // printHeap(rightHeap, sizeRightHeap);
      if (i % 2 == 0) {
        print(a, i, leftHeap[0]);
      } else {
        print(a, i, (double)(leftHeap[0] + rightHeap[0]) / 2);
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    streamMedian(a, a.length);
  }
}