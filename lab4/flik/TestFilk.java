package flik;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;

public class TestFilk {
  @Test
  public void TestFilk() {
    int i = 129;
    int j = 129;
    assertEquals(Flik.isSameNumber(i, j), true);
  }
}
