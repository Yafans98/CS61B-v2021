package deque;

import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
  private IntNode sentinal = new IntNode(null, null, null);
  private int size;

  private class IntNode {
    private IntNode prev;
    private T item;
    private IntNode next;

    private IntNode(IntNode p, T f, IntNode n) {
      prev = p;
      item = f;
      next = n;
    }
  }

  // return an empty LinkedListDeque
  public LinkedListDeque() {
    sentinal.next = sentinal;
    sentinal.prev = sentinal;
    size = 0;
  }

  // addFirst
  public void addFirst(T x) {
    IntNode p = new IntNode(sentinal, x, sentinal.next);
    sentinal.next.prev = p;
    sentinal.next = p;
    size += 1;
  }
  // addLast
  public void addLast(T x) {
    IntNode p = new IntNode(sentinal.prev, x, sentinal);
    sentinal.prev.next = p;
    sentinal.prev = p;
    size += 1;
  }
  // size
  public int size() {
    return size;
  }
  // printDeque
  public void printDeque() {
    LinkedListDeque<String> lld = new LinkedListDeque<>();
    for (T x : this) {
      lld.addLast(x.toString());
    }
    System.out.println(String.join(" ", lld) + "\n");
  }
  // removeFirst
  public T removeFirst() {
    if (size == 0) {
      return null;
    }
    T val = sentinal.next.item;
    sentinal.next.next.prev = sentinal;
    sentinal.next = sentinal.next.next;
    size -= 1;
    return val;
  }
  // removeLast
  public T removeLast() {
    if (size == 0) {
      return null;
    }
    T val = sentinal.prev.item;
    sentinal.prev.prev.next = sentinal;
    sentinal.prev = sentinal.prev.prev;
    size -= 1;
    return val;
  }
  // get
  public T get(int index) {
    if (this.size == 0 || this.size < index + 1) {
      return null;
    }
    IntNode currentNode = sentinal.next;
    while (index > 0) {
      currentNode = currentNode.next;
      index -= 1;
    }
    return currentNode.item;
  }
  // getRecursive
  public T getRecursive(int index) {
    IntNode currentNode = sentinal.next;
    if (index == 0) {
      return currentNode.item;
    }
    currentNode = currentNode.next;
    return getSupport(currentNode, index - 1);
  }

  private T getSupport(IntNode t, int index) {
    if (index == 0) {
      return t.item;
    }
    return getSupport(t.next, index - 1);
  }

  // Iterator
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {
    private int curPos;

    public LinkedListIterator() {
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
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (!(o instanceof Deque<?>)) {
      return false;
    }
    Deque<?> ad = (Deque<?>) o;
    if (ad.size() != size) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (ad.get(i) != get(i)) {
        return false;
      }
    }
    return true;
  }
}
