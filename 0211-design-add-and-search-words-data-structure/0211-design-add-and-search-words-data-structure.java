class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {

        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null &&
                    searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }
        int idx = ch - 'a';
        return searchHelper(word, index + 1, node.children[idx]);
    }
}
