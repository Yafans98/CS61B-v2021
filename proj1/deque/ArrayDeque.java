package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T> {
  private T[] items;
  private int size;
  private int nextFirst;
  private int nextLast;
  private int Asize;
  // return an empty ArrayDeque
  public ArrayDeque() {
    nextFirst = 3;
    nextLast = 4;
    items = (T[]) new Object[8];
    size = 0;
    Asize = 8;
  }
  // indexAdjust
  private int indexAdjust(int x) {
    x = x < 0 ? x + Asize : x;
    x = x < Asize ? x : x % Asize;
    return x;
  }
  // addFirst
  public void addFirst(T x) {
    items[nextFirst] = x;
    size += 1;
    nextFirst = indexAdjust(nextFirst - 1);
  }
  // addLast
  public void addLast(T x) {
    items[nextLast] = x;
    size += 1;
    nextLast = indexAdjust(nextLast + 1);
  }
  // isEmpty
  public boolean isEmpty() {
    return size == 0;
  }
  // size
  public int size() {
    return size;
  }
  // printDeque
  public void printDeque() {
    ArrayDeque<String> ad1 = new ArrayDeque<>();
    for (int i = 0; i < size; i++) {
      ad1.addFirst(get(i).toString());
    }
    System.out.println(String.join(" ", ad1) + "\n");
  }
  // removeFirst
  public T removeFirst() {
    T returnItem = get(0);
    nextFirst = indexAdjust(nextFirst + 1);
    items[nextFirst] = null;
    size -= 1;
    return returnItem;
  }
  // removeLast
  public T removeLast() {
    T returnItem = get(size - 1);
    nextLast = indexAdjust(nextLast - 1);
    items[nextLast] = null;
    size -= 1;
    return returnItem;
  }
  // get
  public T get(int index) {
    if (this.size == 0 || this.size < index + 1) {
      return null;
    }
    return items[indexAdjust(nextFirst + 1 + index)];
  }
  // Iterator
  public Iterator<T> iterator() {
    return new ArrayDequeIterator();
  }

  private class ArrayDequeIterator implements Iterator<T> {
    private int curPos;

    public ArrayDequeIterator() {
      curPos = 0;
    }

    @Override
    public boolean hasNext() {
      return curPos < size;
    }

    public T next() {
      T returnItem = get(curPos);
      curPos += 1;
      return returnItem;
    }
  }
  // equals
  public boolean equals(Object o) {
    if (o instanceof ArrayDeque) {
      if (((ArrayDeque) o).size() != this.size()) {
        return false;
      }
      for (int i = 0; i < this.size(); i += 1) {
        if (this.get(i) != ((ArrayDeque) o).get(i)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
