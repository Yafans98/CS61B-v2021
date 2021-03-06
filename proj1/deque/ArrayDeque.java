package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[8];

  private int size;
  private int nextFirst;
  private int nextLast;
  private int Asize;

  // return an empty ArrayDeque
  public ArrayDeque() {
    nextFirst = 3;
    nextLast = 4;
    size = 0;
    Asize = 8;
  }

  // sizeAdjust
  private void sizeAdjust() {
    if (isEmpty()) {
      resize(8);
    }
    if (nextFirst < 0 || nextLast == Asize) {
      resize(Asize * 2);
    }
    if (size < Asize * 0.25 && Asize > 16) {
      resize(Asize / 2);
    }
  }

  // resize
  @SuppressWarnings("unchecked")
  private void resize(int x) {
    T[] a = (T[]) new Object[x];
    int firstPos = Math.abs(x - Asize) / 2;
    System.arraycopy(items, nextFirst + 1, a, firstPos, size);
    Asize = x;
    items = a;
    nextFirst = firstPos - 1;
    nextLast = firstPos + size;
  }

  // addFirst
  public void addFirst(T x) {
    items[nextFirst] = x;
    size += 1;
    nextFirst -= 1;
    sizeAdjust();
  }

  // addLast
  public void addLast(T x) {
    items[nextLast] = x;
    size += 1;
    nextLast += 1;
    sizeAdjust();
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
    if (size == 0) {
      return null;
    }
    nextFirst += 1;
    T returnItem = items[nextFirst];
    items[nextFirst] = null;
    size -= 1;
    sizeAdjust();
    return returnItem;
  }

  // removeLast
  public T removeLast() {
    if (size == 0) {
      return null;
    }
    nextLast -= 1;
    T returnItem = items[nextLast];
    items[nextLast] = null;
    size -= 1;
    sizeAdjust();
    return returnItem;
  }

  // get
  public T get(int index) {
    if (this.size == 0 || this.size < index + 1) {
      return null;
    }
    return items[nextFirst + 1 + index];
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
    if (!(o instanceof Deque)) {
      return false;
    }
    Deque deckQ = (Deque) o;
    return equalsHelper(deckQ);
  }

  private boolean equalsHelper(Deque<?> Q) {
    if (Q.size() != size()) {
      return false;
    }

    int index = nextFirst + 1;
    for (int i = 0; i < size(); i += 1) {
      boolean equals = items[index].equals(Q.get(i));
      if (!equals) {
        return false;
      }
      index += 1;
    }
    return true;
  }
}
