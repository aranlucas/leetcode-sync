class DLinkedList {
    int val;
    int key;
    DLinkedList next;
    DLinkedList prev;

    public DLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    DLinkedList head;
    DLinkedList tail;
    int capacity;
    Map<Integer, DLinkedList> map;

    public LRUCache(int capacity) {
      head = new DLinkedList(-1, -1);
      tail = new DLinkedList(-1, -1);
      head.next = tail;
      tail.prev = head;
      this.capacity = capacity;
      map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        var node = map.get(key);
        // Move node front
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            var node = map.get(key);
            remove(node);
        }

        DLinkedList node = new DLinkedList(key, value);
        map.put(key, node);
        // Move to front of LL
        add(node);

        if (map.size() > capacity) {
            var toDelete = head.next;
            remove(toDelete);
            map.remove(toDelete.key);
        }
    }

    private void remove(DLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(DLinkedList node) {
        DLinkedList previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */