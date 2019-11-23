public class Node<K, V> {
    private K key;
    private V value;

    private Node<K, V> next;
    private Node<K, V> prev;

    public Node (K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Node<K, V> getNext(){
        return this.next;
    }

    public Node<K, V> setNext(Node<K, V> next){
        this.next = next;
        return this.next;
    }

    public Boolean hasNext(){
        return (next!= null);
    }

    public Node<K, V> getPrev(){
        return this.prev;
    }

    public Node<K, V> setPrev(Node<K, V> prev){
        this.prev = prev;
        return this.prev;
    }

//    public void linkToPrev(Node<K, V> prev){
//        this.setPrev(prev).setNext(this);
//    }

}
