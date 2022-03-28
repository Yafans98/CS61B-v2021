package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
  private Comparator<T> comparator;

  public MaxArrayDeque(Comparator<T> c) {
    comparator = c;
  }

  public T max() {
    return max(comparator);
  }

  private T max(Comparator<T> c) {
    if (this.isEmpty()) {
      return null;
    }
    int maxIndex = 0;
    for (int i = 0; i < size(); i += 1) {
      if (c.compare(get(i), get(maxIndex)) > 0) {
        maxIndex = i;
      }
    }
    return get(maxIndex);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof MaxArrayDeque)) {
      return false;
    }
    if (((MaxArrayDeque) o).max() != max()) {
      return false;
    }
    return super.equals(o);
  }
}
