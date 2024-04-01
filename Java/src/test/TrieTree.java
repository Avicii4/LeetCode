package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树定义
 */
public class TrieTree {
    TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        cur.pas++;
        for (char c : word.toCharArray()) {
            // 如果cur.nexts没有里存着当前字符，则新建节点
            if (!cur.nexts.containsKey(c)) {
                cur.nexts.put(c, new TrieNode());
            }
            cur = cur.nexts.get(c);
            cur.pas++;
        }
        cur.end++;
    }

    public int search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.nexts.get(c);
            if (cur == null) {
                return 0;
            }
        }
        return cur.end;
    }

    public void delete(String word) {
        if (search(word) > 0) { // 有这个单词才做删除
            TrieNode cur = root;
            cur.pas--;
            for (char c : word.toCharArray()) {
                cur = cur.nexts.get(c);
                cur.pas--;
                if (cur.pas == 0) {
                    // 已经没有单词经过这个节点了，
                    // 那么直接删除该节点（以及以下的内容），完成删除
                    cur.nexts.remove(c);
                    return;
                }
            }
            cur.end--;
        }
    }

    /**
     * 求以preString为前缀的字符串数量
     *
     * @param preString 前缀字符串
     * @return 数量
     */
    public int prefixNum(String preString) {
        TrieNode cur = root;
        for (char c : preString.toCharArray()) {
            cur = cur.nexts.get(c);
            if (cur == null) {
                return 0;
            }
        }
        return cur.pas;
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "abd", "abcd", "aaa", "cbd", "aaa"};
        TrieTree trieTree = new TrieTree();
        for (String s : strings) {
            trieTree.insert(s);
        }
        System.out.println(trieTree.search("aew"));
        //System.out.println(trieTree.prefixNum("ab"));
    }

}


/**
 * 节点定义
 */
class TrieNode {
    int pas;  // 通过的次数
    int end;  // 以该节点为结尾的次数
    Map<Character, TrieNode> nexts;

    public TrieNode() {
        pas = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}
