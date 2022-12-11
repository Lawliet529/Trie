public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!current.children.containsKey(currentChar)) {
        current.children.put(currentChar, new TrieNode());
      }
      current = current.children.get(currentChar);
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!current.children.containsKey(currentChar)) {
        return false;
      }
      current = current.children.get(currentChar);
    }
    return current.isEndOfWord;
  }

  public boolean searchPrefix(String prefix) {
    TrieNode current = root;
    for (int i = 0; i < prefix.length(); i++) {
      char currentChar = prefix.charAt(i);
      if (!current.children.containsKey(currentChar)) {
        return false;
      }
      current = current.children.get(currentChar);
    }
    return true;
  }

  public void delete(String word) {
    TrieNode lastSharedNode = root;
    int indexToBeDeleted = 0;
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!current.children.containsKey(currentChar)) {
        return;
      }
      if (current.children.size() > 1 || current.isEndOfWord) {
        lastSharedNode = current;
        indexToBeDeleted = i;
      }
      current = current.children.get(currentChar);
    }
    if (current.children.size() > 0) {
      current.isEndOfWord = false;
    } else {
      lastSharedNode.children.remove(word.charAt(indexToBeDeleted));
    }
  }
}
