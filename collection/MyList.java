import java.util.Arrays;

/**
 * MyList
 */
class MyList {

  private int[] arr;
  private int size;
  MyList() {
    arr = new int[5];
    size = 0;
  }

  void add(int t) {
    if (size == arr.length) {
      resize(10);
    }
    arr[size++] = t;
  }

  void removeAtIndex(int i) {
    if (i >= size) {
      throw new IndexOutOfBoundsException("Index " + i + " Out of bound");
    }
    for (int j = i; j < size; j++) {
      arr[j] = arr[j + 1];
    }
    if (arr.length - size > 10) {
      resize(-10);
    }
    size--;
  }

  private void resize(int addSize) {
    arr = Arrays.copyOf(arr, size + addSize);
  }

  int get(int i) throws IndexOutOfBoundsException {
    if (i >= size) {
      throw new IndexOutOfBoundsException("Index " + i + " Out of bound");
    }
    return arr[i];
  }

  int size() {
    return size;
  }

}

class ListTest {
  public static void main(String[] args) {
    MyList list = new MyList();
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    System.out.println(list.get(0));
    System.out.println("size: " + list.size());
    System.out.println(list.get(2));
    list.removeAtIndex(2);
    System.out.println(list.get(2));
    System.out.println("size: " + list.size());
  }
}