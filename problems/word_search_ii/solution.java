class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(i, j, board, trie.root, visited, result);
            }
        }

        return result;
    }

    public void dfs(
            int r, int c, char[][] board, TrieNode trie, boolean[][] visited, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return;
        }

        char ct = board[r][c];

        if (trie.nodes[ct - 'a'] == null) {
            return;
        }
        trie = trie.nodes[ct - 'a'];

        if (trie.isWord) {
            result.add(trie.word);
            trie.word = null;
            trie.isWord = false;
        }

        visited[r][c] = true;

        dfs(r + 1, c, board, trie, visited, result);
        dfs(r - 1, c, board, trie, visited, result);
        dfs(r, c + 1, board, trie, visited, result);
        dfs(r, c - 1, board, trie, visited, result);

        visited[r][c] = false;
    }
}

class TrieNode {
    public String word;
    public boolean isWord = false;
    public TrieNode[] nodes = new TrieNode[26];
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.nodes[index] == null) {
                cur.nodes[index] = new TrieNode();
            }
            cur = cur.nodes[index];
        }
        cur.word = word;
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.nodes[index] == null) {
                return false;
            }
            cur = cur.nodes[index];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (cur.nodes[index] == null) {
                return false;
            }
            cur = cur.nodes[index];
        }
        return true;
    }
}
