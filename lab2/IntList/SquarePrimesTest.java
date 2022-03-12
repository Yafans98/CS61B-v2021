package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

  /**
   * Here is a test for isPrime method. Try running it. It passes, but the starter code
   * implementation of isPrime is broken. Write your own JUnit Test to try to uncover the bug!
   */
  @Test
  public void testSquarePrimesSimple() {
    IntList lst = IntList.of(14, 15, 16, 17, 18);
    boolean changed = IntListExercises.squarePrimes(lst);
    assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
    assertTrue(changed);
  }

  @Test
  public void testSquarePrimesSimple2() {
    IntList lst = IntList.of(1, 2, 23, 57, 4);
    boolean changed = IntListExercises.squarePrimes(lst);
    assertEquals(("1 -> 4 -> 529 -> 57 -> 4"), lst.toString());
    assertTrue(changed);
  }

  @Test
  public void testSquarePrimesSimple3() {
    IntList lst = IntList.of(1, 8, 6, 57, 4);
    boolean changed = IntListExercises.squarePrimes(lst);
    assertEquals(("1 -> 8 -> 6 -> 57 -> 4"), lst.toString());
    assertEquals(false, changed);
  }
}
