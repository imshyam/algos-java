public class MergeSort {

  static void merge(int[] a, int s, int m, int e) {
    int[] sol = new int[e - s];
    int l = s;
    int r = m;
    for(int i = s; i < e; i++) {
      if (l >= m) {
        sol[i - s] = a[r];
        r++;
      } else if (r >= e) {
        sol[i - s] = a[l];
        l++;
      } else {
        if(a[l] < a[r]) {
          sol[i - s] = a[l];
          l++;
        } else {
          sol[i - s] = a[r];
          r++;
        }
      }
    }
    for(int i = s; i < e; i++) {
      a[i] = sol[i - s];
    }
  }

  static void mergesort(int[] a, int s, int e) {
    if (s == e - 1) {
      return;
    }
    int m = (s + e) / 2;
    mergesort(a, s, m);
    mergesort(a, m, e);
    merge(a, s, m, e);
  }
  public static void main(String[] args) {
    int[] a = {3,4,6,2,4,1,94,45,323,2,234,37,432,34,23,2,34,3,4,3424,3,34,23,4,3,324,23,423,4,3};
    mergesort(a, 0, a.length);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }

}