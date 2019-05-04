class QuickSort {

  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
  static int getPivotPoint(int[] a, int s, int e) {
    int pivot = e - 1;
    int largerElementIndex = s;
    for (int i = s; i < e - 1; i++) {
      if (a[i] <= a[pivot]) {
        swap(a, i, largerElementIndex);
        largerElementIndex++;
      }
    }
    swap(a, pivot, largerElementIndex);
    return largerElementIndex;
  }
  static void quickSort(int[] a, int s, int e) {
    if(s >= e - 1) {
      return;
    }
    int pivot = getPivotPoint(a, s, e);
    quickSort(a, s, pivot);
    quickSort(a, pivot + 1, e);
  }
  public static void main(String[] args) {
    int[] a = {3,4,6,2,4,1,94,45,323,2,234,37,432,34,23,2,34,3,4,3424,3,34,23,4,3,324,23,423,4,3};
    quickSort(a, 0, a.length);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }

}