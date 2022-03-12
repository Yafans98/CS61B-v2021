package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

import javax.sound.sampled.DataLine;

/** Created by hug. */
public class TimeAList {
  private static void printTimingTable(
      AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
    System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
    System.out.printf("------------------------------------------------------------\n");
    for (int i = 0; i < Ns.size(); i += 1) {
      int N = Ns.get(i);
      double time = times.get(i);
      int opCount = opCounts.get(i);
      double timePerOp = time / opCount * 1e6;
      System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
    }
  }

  public static void main(String[] args) {
    timeAListConstruction();
  }

  public static void timeAListConstruction() {
    int N = 1000;
    AList<Integer> Ns = new AList<>();
    AList<Double> times = new AList<>();
    AList<Integer> counts = new AList<>();
    AList<Integer> test = new AList<>();
    while (N <= 128000) {
      Ns.addLast(N);
      int count = 0;
      Stopwatch sw = new Stopwatch();
      for (int i = 1; i <= N; i++) {
        test.addLast(i);
        count += 1;
      }
      double timeInSeconds = sw.elapsedTime();
      times.addLast(timeInSeconds);
      counts.addLast(count);
      N *= 2;
    }
    printTimingTable(Ns, times, counts);
  }
}
