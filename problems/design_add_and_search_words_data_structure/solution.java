class TrieNode {
    public boolean isWord = false;
    public TrieNode[] nodes = new TrieNode[26];
}

class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new TrieNode();
            }
            curr = curr.nodes[index];
        }
        curr.isWord = true;
    }
    
    private boolean searchInNode(String word, TrieNode node) {    
        if (node == null) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child: node.nodes) {
                    if (node != null) {
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            
            int index = c - 'a';
            
            if (node.nodes[index] == null) {
                return false;
            }
            node = node.nodes[index];
        }
        return node.isWord;
    } 
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */