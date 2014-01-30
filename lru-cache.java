public class LRUCache {
    class QueueItem {
        int key;
        QueueItem next;
        QueueItem(int key) {
            this.key = key;
        }
    }
    
    private int capacity;
    private int count = 0;
    private Map<Integer, QueueItem> map;
    private Map<Integer, Integer> values;
    private QueueItem head = new QueueItem(Integer.MIN_VALUE);
    private QueueItem tail = head;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, QueueItem>(capacity);
        values = new HashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if (values.containsKey(key)) {
            QueueItem parent = map.get(key);
            QueueItem item = parent.next;
            map.put(key, tail);
            tail.next = item;
            parent.next = item.next;
            map.put(item.next.key, parent);
            item.next = null;
            tail = item;
            return values.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            values.put(key, value);
            QueueItem parent = map.get(key);
            QueueItem item = parent.next;
            map.put(key, tail);
            tail.next = item;
            parent.next = item.next;
            map.put(item.next.key, parent);
            item.next = null;
            tail = item;
        } else {
            if (count < capacity) {
                count++;
            } else {
                QueueItem item = head.next;
                map.remove(item.key);
                values.remove(item.key);
                head.next = head.next.next;
                if (item.next != null) {
                    map.put(item.next.key, head);
                }
            }
            values.put(key, value);
            QueueItem item = new QueueItem(key);
            map.put(key, tail);
            tail.next = item;
            tail = item;
        }
    }
}
