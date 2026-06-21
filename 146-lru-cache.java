class LRUCache {

    Node head ;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.value = value;
            this.key = key;
        }
    }

    int capacity;
    Map <Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
     tail = new Node(0,0);
    head.next = tail;
    tail.prev = head;
    }
    
    public int get(int key) {
         if(!map.containsKey(key)) {
           return -1;
         }
        else{
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            insert(node);

            if(map.size()>capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
                
            }
            }else{
                Node oldNode = map.get(key);
                                       oldNode.value = value;

                remove(oldNode);
              
                       insert(oldNode);

            }
        
    }

    public void insert(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */