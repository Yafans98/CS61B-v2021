public class DrawTriangle {
  public static void DrawTriangle(int N) {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print('*');
      }
      System.out.print('\n');
    }
  }

  public static void main(String[] args) {
    DrawTriangle(10);
  }
}
