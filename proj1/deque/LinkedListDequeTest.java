package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
  /**
   * Adds a few things to the list, checking isEmpty() and size() are correct, finally printing the
   * results.
   *
   * <p>&& is the "and" operation.
   */
  @Test
  public void getTest() {
    LinkedListDeque<Boolean> lld1 = new LinkedListDeque<>();
    LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
    lld1.addFirst(true);
    lld1.addLast(false);
    for (int i = 1; i <= 12; i += 1) {
      lld2.addLast(i);
    }
    assertEquals(11, (int) lld2.get(10));
    assertEquals(false, lld1.get(1));
  }

  public void addIsEmptySizeTest() {
    LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

    assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
    lld1.addFirst("front");

    // The && operator is the same as "and" in Python.
    // It's a binary operator that returns true if both arguments true, and false otherwise.
    assertEquals(1, lld1.size());
    assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

    lld1.addLast("middle");
    assertEquals(2, lld1.size());

    lld1.addLast("back");
    assertEquals(3, lld1.size());

    System.out.println("Printing out deque: ");
    lld1.printDeque();
  }

  @Test
  /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
  public void addRemoveTest() {
    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
    // should be empty
    assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

    lld1.addFirst(10);
    // should not be empty
    assertFalse("lld1 should contain 1 item", lld1.isEmpty());

    lld1.removeFirst();
    // should be empty
    assertTrue("lld1 should be empty after removal", lld1.isEmpty());
  }

  @Test
  /* Tests removing from an empty deque */
  public void removeEmptyTest() {
    LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
    lld1.addLast(0);
    int a = lld1.getRecursive(0);
    lld1.getRecursive(0);
    lld1.getRecursive(0);
    lld1.addLast(4);
    lld1.getRecursive(1);
    int size = lld1.size();
  }

  @Test
  /* Check if you can create LinkedListDeques with different parameterized types*/
  public void multipleParamTest() {

    LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
    LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
    LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

    lld1.addFirst("string");
    lld2.addFirst(3.14159);
    lld3.addFirst(true);

    String s = lld1.removeFirst();
    double d = lld2.removeFirst();
    boolean b = lld3.removeFirst();
  }

  @Test
  /* check if null is return when removing from an empty LinkedListDeque. */
  public void emptyNullReturnTest() {
    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

    boolean passed1 = false;
    boolean passed2 = false;
    assertEquals(
        "Should return null when removeFirst is called on an empty Deque,",
        null,
        lld1.removeFirst());
    assertEquals(
        "Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
  }

  @Test
  /* Add large number of elements to deque; check if order is correct. */
  public void bigLLDequeTest() {
    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
    for (int i = 0; i < 1000000; i++) {
      lld1.addLast(i);
    }

    for (double i = 0; i < 500000; i++) {
      assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
    }

    for (double i = 999999; i > 500000; i--) {
      assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
    }
  }

  @Test
  // Test get
  public void getTest1() {
    LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
    lld1.addFirst(2);
    lld1.addFirst(3);
    lld1.addFirst(4);
    lld1.addFirst(5);
    lld1.printDeque();
  }

  @Test
  // Test equals
  public void equalsTest() {
    LinkedListDeque<LinkedListDeque> lld1 = new LinkedListDeque<>();
    LinkedListDeque<LinkedListDeque> lld2 = new LinkedListDeque<>();
    LinkedListDeque<Integer> ele1 = new LinkedListDeque<>();
    LinkedListDeque<Integer> ele2 = new LinkedListDeque<>();
    ele1.addLast(1);
    ele2.addLast(2);
    lld1.addLast(ele1);
    lld1.addLast(ele1);
    lld1.addLast(ele1);
    lld1.addLast(ele1);
    lld1.addLast(ele2);
    lld1.addLast(ele2);
    lld1.addLast(ele2);
    lld1.addLast(ele2);
    lld2.addLast(ele1);
    lld2.addLast(ele1);
    lld2.addLast(ele1);
    lld2.addLast(ele1);
    lld2.addLast(ele2);
    lld2.addLast(ele2);
    lld2.addLast(ele2);
    lld2.addLast(ele2);

    assertEquals(true, lld1.equals(lld2));
  }
}
