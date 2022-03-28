package deque;

import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;

public class MaxArrayDequeTest {
  private static class IntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
      return i1 - i2;
    }
  }

  public static class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  }

  @Test
  public void IntegerTest() {
    MaxArrayDeque<Integer> md1 = new MaxArrayDeque<>(new IntComparator());
    for (int i = 0; i < 6; i += 1) {
      md1.addFirst(i);
    }
    assertEquals((Integer) 5, md1.max());
  }

  @Test
  public void StringNameTest() {
    MaxArrayDeque<String> md1 = new MaxArrayDeque<>(new StringComparator());
    md1.addFirst("I am a man");
    md1.addLast("I am a woman");
    assertEquals("I am a woman", md1.max());
  }
}
