public class TrieTest {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));   // returns true
    System.out.println(trie.search("app"));     // returns false
    System.out.println(trie.searchPrefix("app")); // returns true
    trie.insert("app");
    System.out.println(trie.search("app"));     // returns true
    trie.delete("app");
    System.out.println(trie.search("app"));     // returns false
  }
}
