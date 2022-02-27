public class MaxFunc {
  /** Returns the maximum value from m. */
  public static int max(int[] m) {
    int maxValue = m[0];
    for (int i = 1; i <= m.length - 1; i++) {
      if (m[i] >= maxValue) {
        maxValue = m[i];
      }
    }
    System.out.println(maxValue);
    return 0;
  }

  public static void main(String[] args) {
    int[] numbers = new int[] {9, 2, 15, 2, 22, 10, 6};
    max(numbers);
  }
}
