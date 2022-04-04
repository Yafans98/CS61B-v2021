package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
  private BSTNode root;
  private int size;

  private class BSTNode {
    private K key;
    private V val;
    private BSTNode left, right;
    private int size;

    BSTNode(K k, V v, int sz) {
      key = k;
      val = v;
      size = sz;
    }
  }

  public BSTMap() {}

  @Override
  public void clear() {
    root = null;
  }

  @Override
  public boolean containsKey(K key) {
    return get(key) != null;
  }

  @Override
  public V get(K key) {
    return getSupport(root, key);
  }

  private V getSupport(BSTNode node, K key) {
    if (node == null) {
      return null;
    }
    int cpt = key.compareTo(node.key);
    if (cpt < 0) {
      return getSupport(node.left, key);
    } else if (cpt > 0) {
      return getSupport(node.right, key);
    } else if (node.val != null) {
      return node.val;
    } else {
      return (V) new Object();
    }
  }

  @Override
  public int size() {
    if (root != null) {
      size = size(root);
    } else {
      size = 0;
    }
    return size;
  }

  private int size(BSTNode x) {
    if (x == null) {
      return 0;
    }
    return x.size;
  }

  @Override
  public void put(K key, V value) {
    root = putSupport(root, key, value);
  }

  private BSTNode putSupport(BSTNode x, K key, V value) {
    if (x == null) {
      return new BSTNode(key, value, 1);
    }
    int cpt = key.compareTo(x.key);
    if (cpt < 0) {
      x.left = putSupport(x.left, key, value);
    } else if (cpt > 0) {
      x.right = putSupport(x.right, key, value);
    } else {
      x.val = value;
    }
    x.size = 1 + size(x.left) + size(x.right);
    return x;
  }

  @Override
  public Set<K> keySet() {
    throw new UnsupportedOperationException("This method do not need to be implemented!");
  }

  @Override
  public V remove(K key) {
    throw new UnsupportedOperationException("This method do not need to be implemented!");
  }

  @Override
  public V remove(K key, V value) {
    throw new UnsupportedOperationException("This method do not need to be implemented!");
  }

  @Override
  public Iterator<K> iterator() {
    throw new UnsupportedOperationException("This method do not need to be implemented!");
  }

  // printCheck
  public void printInOrder() {}
}
