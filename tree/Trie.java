import java.util.HashMap;
import java.util.Map;

class Trie {

  class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWorld;

    TrieNode() {
      children = new HashMap<>();
      endOfWorld = false;
    }
  }

  private final TrieNode root;
  Trie() {
    root = new TrieNode();
  }

  void insert(String str) {
    TrieNode current = root;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.endOfWorld = true;
  }

  boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current.endOfWorld;
  }

  void delete(String word) {
    delete(root, word, 0);
  }

  boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      if (!current.endOfWorld) {
        return false;
      }
      current.endOfWorld = false;
      return current.children.size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
    if (shouldDeleteCurrentNode) {
      current.children.remove(ch);
      return current.children.size() == 0;
    }
    return false;
  }

}

class TrieTest {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("book");
    trie.insert("cat");
    trie.insert("adam");
    trie.insert("axe");
    trie.insert("amy");
    System.out.println(trie.search("amy"));
    System.out.println(trie.search("axe"));
    trie.delete("axe");
    System.out.println(trie.search("axe"));
  }
}