package pa6;

public class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode(0);
    }

    private TrieNode locus(String str) { // complete this method
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            TrieNode v = tmp.edges.get(c); // not sure
            if (v == null) {
                return tmp;
            } else {
                tmp = v;
            }
        }
        return tmp;
    }

    public void insert(String str) {
        TrieNode parent = locus(str);
        for (int i = parent.depth; i < str.length(); i++) {
            char c = str.charAt(i);
            TrieNode child = new TrieNode(i + 1);
            parent.edges.put(c, child);
            parent = child;
        }
    } // complete this method

    public boolean search(String str) {
        TrieNode tmp = locus(str);
        return tmp.depth == str.length();
    } // complete this method

    public static String longestCommonSubstring(String str1, String str2) {
        Trie t = new Trie();
        String sub = "";
        for (int i = 0; i < str1.length(); i++) {
            sub = str1.substring(i);
            t.insert(sub);
        }
        String lcs = "";
        TrieNode v;
        for (int i = 0; i < str2.length(); i++) {
            sub = str2.substring(i);
            v = t.locus(sub);
            if (v.depth > lcs.length()) {
                lcs = str2.substring(i, v.depth);
            }
        }
        return lcs;
    } // complete this method
}
