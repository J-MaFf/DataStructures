package oldPA6;


public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(0);
	}

	private TrieNode locus(String str) { // complete this method
		// Set a TrieNode temporary variable tmp to the root. (In C++, tmp is a pointer.)
		TrieNode tmp = root;
		for (int i = 0; i < str.length(); i++) {
			// – Let c be the character at position i of str.
			char c = str.charAt(i);
			// – Let v be the child of tmp such that the edge from tmp to the v is labeled by c; use the hashtable edges stored in tmp to get
			// hold of v.
			TrieNode v = tmp.edges.get(c);
			// – If v is null, then the character c cannot be matched in the trie. This means tmp is the locus; so return tmp.
			if (v == null) {
				return tmp;
			}

			// – Else, set tmp to v
			else {
				tmp = v;
			}
		} // end for
			// • The entire string is matched at this point; so, the locus is given by tmp; return it.
		return tmp;
	}

	public void insert(String str) { // complete this method
		// Let parent be the locus of str.
		TrieNode parent = locus(str);
		for (int i = parent.depth; i < str.length() ; i++) { // • Start a for-loop from the depth of parent until the end of the string. Within the loop,
			// Let c be the character at the index of str given by the for-loop counter.
			char c = str.charAt(i);
			// – Create a new TrieNode child whose depth is one more than the loop counter.
			TrieNode child = new TrieNode(i + 1);
			// – Insert this newly created node as the child of parent by using the hashtable edges stored at parent. Specifically, insert the child as value into edges keyed by c.
			parent.edges.put(c, child);
			// – Set parent to child
			parent = child;
		} // end for
	} // end insert

	public boolean search(String str) { // complete this method
		// A string is found if the string is entirely matched, which implies that a string is found if the locus has the same depth as the length of the string itself, else it is not found.
		if (locus(str).depth == str.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static String longestCommonSubstring(String str1, String str2) { // complete this method
		// create a trie object
		Trie objTrie = new Trie();
		// Now, use a for-loop to go over each index in str1. Within the loop, do the following:
		for (int i = 0; i < str1.length(); i++) {
			// Let sub be the suffix of str1 that starts at the index given by the loop counter.
			String sub = str1.substring(i);
			// Insert sub into the trie object.
			objTrie.insert(sub);
		} // end for
		// At this point, the trie contains all suffixes of str1. Declare a string variable lcs, which will store the longest common substring.
		String lcs = "";
		// What we want to do is pick every suffix of str2 and find its locus in the trie. The deepest locus gives us the longest common substring (because the string obtained by
		// concatenating the characters until the locus in the trie is present in both str1 and str2). So, run a loop to go over each index in str2. Within the loop, do the following:
		for (int i = 0; i < str2.length(); i++) {
			//Let sub be the suffix of str2 that starts at the index given by the loop counter.
			String sub = str2.substring(i);
			// – Let v be the locus of the string sub in the trie object.
			TrieNode v = objTrie.locus(sub);
			
			// – If depth of v is more than the length of lcs, then we have found a longer common substring. So, set lcs to the substring of str2 
			// that starts at the index given by the loop counter and has length equaling the depth of v.
			if (v.depth > lcs.length()) {
				lcs = str2.substring(i, i + v.depth);
			}
		} // end for
		return lcs;
	}
}
