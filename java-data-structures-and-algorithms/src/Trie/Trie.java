package Trie;

public class Trie {
	/**
     * Trie树的根节点
     */
    TrieNode root;

    /**
     * 初始化Trie数据结构
     */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /**
     * 插入一个单词到Trie树中
     *
     */
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 将当前的字符作为节点插入到Trie树中
            // 但是插入之前首先做一次检查
            if (currentNode.next[c - 'a'] == null) {
                currentNode.next[c - 'a'] = new TrieNode(c);
            }
            currentNode = currentNode.next[c - 'a'];
        }
        // 现在标识已经走到单词末尾了
        currentNode.isEnd = true;
    }

    /**
     * 判断某个单词是否在Trie树之中
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 在单词还未走完的时候发现已经不匹配了
            if (currentNode.next[c - 'a'] == null){
                return false;
            }
            currentNode = currentNode.next[c - 'a'];
        }
        // 在每个单词的末尾都有设置为true
        // 如果当前是false，那么代表未存储这个单词
        return currentNode.isEnd;
    }

    /**
     * 判断当前的单词是否为Trie树种某个单词的前缀，注意这里的逻辑与查询是相同的，唯一不同的是
     * 匹配完前缀之后返回true
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (currentNode.next[c - 'a'] == null){
                return false;
            }
            currentNode = currentNode.next[c - 'a'];
        }
        return true;
    }
}
