package Trie;

public class TrieDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
        trie.insert("flink");
        trie.insert("netty");
        trie.insert("mysql");
        trie.insert("redis");

        // false
        System.out.println(trie.search("mongodb"));
        // true
        System.out.println(trie.search("redis"));
        //false
        System.out.println(trie.search("my"));
        // true
        System.out.println(trie.search("mysql"));
        // true
        System.out.println(trie.startsWith("my"));
	}

}
