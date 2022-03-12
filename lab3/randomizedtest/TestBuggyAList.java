package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/** Created by hug. */
public class TestBuggyAList {
  @Test
  public void testThreeAddThreeRemove() {
    AListNoResizing<Integer> anr = new AListNoResizing<>();
    BuggyAList<Integer> ba = new BuggyAList<>();
    for (int i = 1; i <= 3; i += 1) {
      anr.addLast(i);
      ba.addLast(i);
    }
    for (int i = 1; i <= 3; i++) {
      assertEquals(anr.removeLast(), ba.removeLast());
    }
  }

  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> B = new BuggyAList<>();

    int N = 5000;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 4);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        B.addLast(randVal);
        System.out.println("addLast(" + randVal + ")");
      } else if (operationNumber == 1) {
        // size
        int size = L.size();
        int size2 = B.size();
        System.out.println("L size: " + size);
        System.out.println("B size:" + size2);
      } else if (operationNumber == 2) {
        if (L.size() > 0) {
          int lastNum = L.removeLast();
          int bLastNum = B.removeLast();
          assertEquals(lastNum, bLastNum);
        } else {
          System.out.println("The size is 0! There is nothing to remove:)");
        }
      } else if (operationNumber == 3) {
        if (L.size() > 0) {
          int lastNum = L.getLast();
          int bLastNum = B.getLast();
          assertEquals(lastNum, bLastNum);
        } else {
          System.out.println("The size is 0, null takes the last place:)");
        }
      }
    }
  }
}
