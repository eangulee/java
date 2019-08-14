package Trie;

public class TrieNode {

    /**
     * 当前节点要存储的字符
     */
    char val;

    /**
     * 标记节点，用来标记当前的节点是否为要存储节点的最后一个字符
     */
    boolean isEnd;

    /**
     *  存储树的下一个节点，因为这次只考虑到小写，因此
     *  只开辟了26个数组空间
     *
     *  //如果trie树的节点远大于26个的话，可以使用Map来作为next
     *  TreeMap<Character,TrieNode> = new TreeMap()
     */
    TrieNode[] next = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}