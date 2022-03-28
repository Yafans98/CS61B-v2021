package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
  // addTest
  @Test
  public void addTest() {
    ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    ArrayDeque<Integer> ad2 = new ArrayDeque<>();
    ad1.addFirst(2);
    ad1.addLast(3);
    assertEquals(2, (int) ad1.get(0));
    assertEquals(3, (int) ad1.get(1));
    assertEquals(2, ad1.size());
    assertEquals(true, ad2.isEmpty());
  }

  // printTest
  @Test
  public void printTest() {
    ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    ad1.addFirst(5);
    ad1.addLast(3);
    ad1.printDeque();
  }

  // removeTest
  @Test
  public void removeTest() {
    ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    ArrayDeque<Integer> ad2 = new ArrayDeque<>();
    ad1.addFirst(3);
    ad1.addFirst(2);
    ad1.addFirst(1);
    ad1.addFirst(0);
    ad1.addLast(4);
    ad2.addLast(4);
    ad2.addLast(5);
    ad2.addLast(6);
    ad2.addLast(7);
    int itemFirst = ad1.removeFirst();
    int itemLast = ad1.removeLast();
    int itemLast2 = ad2.removeLast();
    assertEquals(4, itemLast);
    assertEquals(0, itemFirst);
    assertEquals(3, ad1.size());
    assertEquals(7, itemLast2);
  }

  // equalsTest
  @Test
  public void equalsTest() {
    ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    ArrayDeque<Integer> ad2 = new ArrayDeque<>();
    LinkedListDeque<Integer> ld1 = new LinkedListDeque<>();
    assertEquals(true, ad1.equals(ad2));
    ad1.addFirst(2);
    assertEquals(false, ad1.equals(ad2));
    ad2.addFirst(2);
    assertEquals(true, ad1.equals(ad2));
    ld1.addFirst(2);
    assertEquals(false, ad1.equals(ld1));
  }

  // outOfBoundTest
  @Test
  public void outOfBoundTest() {
    ArrayDeque<Integer> ad1 = new ArrayDeque<>();
    ad1.addLast(3);
    ad1.addLast(3);
    ad1.addLast(3);
    ad1.addLast(3);
    ad1.addLast(3);
    assertEquals(3, (int) ad1.get(4));
  }
}
