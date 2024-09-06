package problems.string;

import java.util.HashMap;
import java.util.Map;

// LeetCode 208题
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.nexts.containsKey(c)) {
                cur.nexts.put(c, new TrieNode());
            }
            cur = cur.nexts.get(c);
            cur.pass++;
        }
        cur.end++;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.nexts.containsKey(c)) {
                return false;
            }
            cur = cur.nexts.get(c);
        }
        return cur.end != 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.nexts.containsKey(c)) {
                return false;
            }
            cur = cur.nexts.get(c);
        }
        return cur.pass != 0;
    }
}

class TrieNode {

    int pass;   // 有多少字符串经过了本节点
    int end;    // 有多少字符以本节点为末尾
    Map<Character, TrieNode> nexts;

    TrieNode() {
        pass = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}

public class LC208 {
    public static void main(String[] args) {
        Trie trieTree = new Trie();
        String[] arr = {"abc", "abcd", "acd", "bd"};
        for (String s : arr) {
            trieTree.insert(s);
        }
        System.out.println(trieTree.search("bb"));
        System.out.println(trieTree.search("abc"));
        System.out.println(trieTree.startsWith("ab"));

    }
}