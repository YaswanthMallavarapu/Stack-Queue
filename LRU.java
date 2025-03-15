class LRUCache {
    class Node {
        int key, value;
        Node next, prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node head, tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
        map.put(node.key, node);
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        delete(node); // Remove from current position
        insert(node); // Move to front (most recently used)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delete(map.get(key)); // Remove old node
        } else if (map.size() == capacity) {
            delete(tail.prev); // Remove least recently used (LRU) node
        }
        insert(new Node(key, value)); // Insert new node at front
    }
}