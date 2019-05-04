import java.util.HashSet;
import java.util.Set;

class Entry<K, V> {
  final K key;
  V val;
  Entry<K, V> next;
  Entry(K key, V val) {
    this.key = key;
    this.val = val;
    next = null;
  }
}

class MyMap<K, V> {

  private Entry<K, V>[] bucket;
  private int DEFAULT_SIZE = 1 << 10;
  private int size;
  private Set<K> keySet;

  @SuppressWarnings("unchecked")
  MyMap() {
    bucket = new Entry[DEFAULT_SIZE];
    size = 0;
    keySet = new HashSet<>();
  }

  void put(K key, V val) {
    keySet.add(key);
    int hashCode = key.hashCode();
    if (bucket[hashCode % DEFAULT_SIZE] == null) {
      bucket[hashCode % DEFAULT_SIZE] = new Entry<>(key, val);
      size++;
    }
    else {
      Entry<K, V> head = bucket[hashCode % DEFAULT_SIZE];
      if (head.key == key) {
        head.val = val;
        return;
      }
      while(head.next != null) {
        head = head.next;
        if (head.key == key) {
          head.val = val;
          return;
        }
      }
      head.next = new Entry<>(key, val);
      size++;
    }
  }

  V get(K key) {
    int hashCode = key.hashCode();
    if (bucket[hashCode % DEFAULT_SIZE] == null) {
      return null;
    }
    else {
      Entry<K, V> head = bucket[hashCode % DEFAULT_SIZE];
      if (head.key == key) {
        return head.val;
      }
      while(head.next != null) {
        head = head.next;
        if (head.key == key) {
          return head.val;
        }
      }
      return null;
    }
  }
  Set<K> keySet() {
    return keySet;
  }
  int size() {
    return size;
  }
  
}

class MapTest {
  public static void main(String[] args) {
    MyMap<String, Integer> mp = new MyMap<>();
    mp.put("Apple", 1);
    mp.put("Book", 2);
    mp.put("Cat", 3);
    mp.put("Dog", 4);
    mp.put("Eye", 5);
    mp.put("Fan", 6);
    System.out.println(mp.size());
    System.out.println(mp.get("Apple"));
    System.out.println(mp.get("Kitty"));
    System.out.println(mp.get("Eye"));
    mp.put("Eye", 25);
    System.out.println(mp.get("Eye"));
    for (String key: mp.keySet()) {
      System.out.println(key + " -> " + mp.get(key));
    }
  }
}