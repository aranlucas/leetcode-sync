class FileSystem {
    Trie trie;

    public FileSystem() {
        trie = new Trie();
    }

    public boolean createPath(String path, int value) {
        return trie.addPath(path, value);
    }

    public int get(String path) {
        return trie.findPath(path);
    }
}

class TrieNode {
    int value = -1;
    Map<String, TrieNode> children = new HashMap<>();
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean addPath(String path, int value) {
        String[] components = path.split("/");

        TrieNode cur = root;
        for (int i = 1; i < components.length; i++) {
            String p = components[i];

            if (!cur.children.containsKey(p)) {
                if (i == components.length - 1) {
                    cur.children.put(p, new TrieNode());
                } else {
                    return false;
                }
            }
            cur = cur.children.get(p);
        }
        if (cur.value != -1) {
            return false;
        }
        cur.value = value;
        return true;
    }

    public int findPath(String paths) {
        String[] components = paths.split("/");

        TrieNode cur = root;
        for (int i = 1; i < components.length; i++) {
            String c = components[i];
            if (!cur.children.containsKey(c)) {
                return -1;
            }
            cur = cur.children.get(c);
        }

        return cur.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
