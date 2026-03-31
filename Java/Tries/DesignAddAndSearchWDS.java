// https://neetcode.io/problems/design-word-search-data-structure

class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = false;
    }

}

// O(n) for each function call 
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.root;

        for(char c : word.toCharArray()) {
            int pos = c - 'a';

            if(node.children[pos] == null) node.children[pos] = new TrieNode();

            node = node.children[pos];
        }
        node.word = true;
    }

    public boolean search(String word) {
        return this.dfs(word, 0, this.root);
    }

    private boolean dfs (String word, int dot, TrieNode node) {
        for(int i = dot; i < word.length(); i++) {
            char c = word.charAt(i);
            int pos = c - 'a';

            if (c == '.') {
                for (TrieNode child : node.children) { 
                    if (child != null && dfs(word, i + 1, child)) return true;
                }
                return false;
            }

            else {
                if (node.children[pos] == null) return false;
                node = node.children[pos];
            }
        }
        return node.word;
    }
}