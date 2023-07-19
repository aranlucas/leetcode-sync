class File {
    String name = "";
    boolean isFile = false;
    Map<String, File> children = new TreeMap<>();
    String content = "";
}

class FileSystem {
    File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File node = traverse(path);
        List<String> result = new ArrayList<>();
        if (node.isFile) {
            result.add(node.name);
            return result;
        }

        for (String key : node.children.keySet()) {
            result.add(key);
        }

        return result;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        File node = traverse(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        File node = traverse(filePath);
        return node.content;
    }

    private File traverse(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;

        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!node.children.containsKey(dir)) {
                File file = new File();
                file.name = dir;
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }

        return node;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
