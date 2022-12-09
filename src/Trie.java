public interface Trie {

  TrieNode root = new TrieNode();

  void add(String word);

  boolean contains(String word);

  boolean containsPrefix(String prefix);

  void remove(String word);
}
