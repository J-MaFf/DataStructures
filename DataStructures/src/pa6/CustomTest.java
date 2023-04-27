package pa6;

public class CustomTest {

    // Test every method in the Trie class

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("hell");
        t.insert("help");
        t.insert("he");
        t.insert("h");
        t.insert("hi");
        t.insert("hey");
        t.insert("hellish");
        t.insert("hellion");
        t.insert("hellfire");
        t.insert("hellbent");
        t.insert("hellcat");

        System.out.println(t.search("hello"));
        System.out.println(t.search("hell"));
        System.out.println(t.search("help"));
        System.out.println(t.search("he"));
        System.out.println(t.search("h"));
        System.out.println(t.search("hi"));
        System.out.println(t.search("hey"));
        System.out.println(t.search("hellish"));
        System.out.println(t.search("hellion"));
        System.out.println(t.search("hellfire"));
        System.out.println(t.search("hellbent"));
        System.out.println(t.search("hellcat"));
        System.out.println(t.search("hellboy"));
        System.out.println(t.search("hellraiser"));
        System.out.println(t.search("hellspawn"));
        System.out.println(t.search("hellboy"));
        System.out.println(t.search("hellraiser"));
        System.out.println(t.search("hellspawn"));
        System.out.println(t.search("hellbilly"));
        System.out.println(t.search("hellbound"));
        System.out.println(t.search("hellhole"));
        System.out.println(t.search("hellhound"));
        System.out.println(t.search("hellkite"));
        System.out.println(t.search("hellman"));
        System.out.println(t.search("hellmouth"));
        System.out.println(t.search("helluva"));
        System.out.println(t.search("hellwalker"));
        System.out.println(t.search("hellweg"));
        System.out.println(t.search("hellzapoppin"));
        System.out.println(t.search("hellcat"));

        System.out.println(
            "Longest Common Substring of hello and hell: " +
            Trie.longestCommonSubstring("hello", "hell")
        );
        System.out.println(
            "Longest common substring of hell and help: " +
            Trie.longestCommonSubstring("hell", "help")
        );
        System.out.println(
            "Longest common substring of hell and he: " +
            Trie.longestCommonSubstring("hell", "he")
        );
        System.out.println(
            "Longest common substring of hell and h: " +
            Trie.longestCommonSubstring("hell", "h")
        );
        System.out.println(
            "Longest common substring of hell and hi: " +
            Trie.longestCommonSubstring("hell", "hi")
        );
        System.out.println(
            "Longest common substring of hell and hey: " +
            Trie.longestCommonSubstring("hell", "hey")
        );
        System.out.println(
            "Longest common substring of hell and hellish: " +
            Trie.longestCommonSubstring("hell", "hellish")
        );
        System.out.println(
            "Longest common substring of hell and hellion: " +
            Trie.longestCommonSubstring("hell", "hellion")
        );
        System.out.println(
            "Longest common substring of hell and hellfire: " +
            Trie.longestCommonSubstring("hell", "hellfire")
        );
        System.out.println(
            "Longest common substring of hell and hellbent: " +
            Trie.longestCommonSubstring("hell", "hellbent")
        );
        System.out.println(
            "Longest common substring of hell and hellcat: " +
            Trie.longestCommonSubstring("hell", "hellcat")
        );
        System.out.println(
            "Longest common substring of hell and hellboy: " +
            Trie.longestCommonSubstring("hell", "hellboy")
        );
        System.out.println(
            "Longest common substring of hell and hellraiser: " +
            Trie.longestCommonSubstring("hell", "hellraiser")
        );
        System.out.println(
            "Longest common substring of hell and hellspawn: " +
            Trie.longestCommonSubstring("hell", "hellspawn")
        );
        System.out.println(
            "Longest common substring of hell and hellbilly: " +
            Trie.longestCommonSubstring("hell", "hellbilly")
        );
        System.out.println(
            "Longest common substring of hell and hellbound: " +
            Trie.longestCommonSubstring("hell", "hellbound")
        );
        System.out.println(
            "Longest common substring of hell and hellhole: " +
            Trie.longestCommonSubstring("hell", "hellhole")
        );
        System.out.println(
            "Longest common substring of hell and hellhound: " +
            Trie.longestCommonSubstring("hell", "hellhound")
        );
    }
}
