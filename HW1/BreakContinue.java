public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */
    for (int i = 0; i < a.length; i++) {
      //      判断是否为最后一个元素
      if (i == a.length - 1) {
        break;
      } else if (a[i] <= 0) {
        continue;
      } else {
        for (int j = i + 1; j <= i + n; j++) {
          //          判断是否加到了数组最后
          if (j == a.length) {
            break;
          }
          a[i] += a[j];
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
