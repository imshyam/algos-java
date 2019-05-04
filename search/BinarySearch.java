import java.util.Arrays;

public class BinarySearch {

  static boolean binarySearch(int[] arr, int s, int e, int val) {
    if (s == e) {
      return false;
    }
    int m = (s + e) / 2;
    if (arr[m] == val) return true;
    if (arr[m] > val)
      return binarySearch(arr, s, m, val);
    else 
      return binarySearch(arr, m + 1, e, val);
  }
  public static void main(String[] args) {
    int[] arr = {1,21,212,12,121,2,1,2,1,21,2,1,2,1,21,2,121,2,12,98,23,4453,5,56,5,65,46,67,65,5,55,325,34,5,34,3,34};
    Arrays.sort(arr);
    System.out.println("121: " + binarySearch(arr, 0, arr.length, 121));
    System.out.println("1: " + binarySearch(arr, 0, arr.length, 1));
    System.out.println("33: " + binarySearch(arr, 0, arr.length, 33));
  }
  
}