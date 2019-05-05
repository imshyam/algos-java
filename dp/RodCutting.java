public class RodCutting {

  static void printsol(int[] sol, int n) {
    while(n > 0) {
      System.out.print(sol[n] + " ");
      n -= sol[n];
    }
  }
  static int maxRevenue(int[] p, int n) {
    int[] rn = new int[n + 1];
    int[] sol = new int[n + 1];
    for(int i = 1; i <= n; i++) {
      for (int j = 1; j <= (p.length < i ? p.length : i); j++) {
        if (rn[i] < p[j - 1] + rn[i - j]) {
          rn[i] = p[j - 1] + rn[i - j];
          sol[i] = j;
        }
      }
    }
    printsol(sol, n);
    System.out.println();
    return rn[n];
  }
  public static void main(String[] args) {
    int[] p = {1,5,8,9,10,17,17,20,24,30};
    System.out.println(maxRevenue(p, 7));
    int[] p1 = {2, 5, 7, 8};
    System.out.println(maxRevenue(p1, 5));
  }

}