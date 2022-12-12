public class Trie {

  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        current.children[index] = new TrieNode();
      }
      current = current.children[index];
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        return false;
      }
      current = current.children[index];
    }
    return current.isEndOfWord;
  }

  public boolean searchPrefix(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        return false;
      }
      current = current.children[index];
    }
    return true;
  }

  public void delete(String word) {
    TrieNode current = root;
    TrieNode[] stack = new TrieNode[word.length()];
    int top = -1;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (current.children[index] == null) {
        return;
      }
      stack[++top] = current;
      current = current.children[index];
    }
    current.isEndOfWord = false;

    // Delete nodes if they are not part of any other word
    while (top >= 0) {
      TrieNode node = stack[top--];
      if (node.isEndOfWord) {
        return;
      }
      for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
          return;
        }
      }
      if (top >= 0) {
        TrieNode parent = stack[top];
        for (int i = 0; i < 26; i++) {
          if (parent.children[i] == node) {
            parent.children[i] = null;
            break;
          }
        }
      }
    }
  }
}
