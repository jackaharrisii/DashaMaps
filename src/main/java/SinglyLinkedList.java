public class SinglyLinkedList <K, V>{


    private int listCount;    // THE NUMBER OF NODES IN THE LIST
    private Node<K, V> head;        // NOTE: HEAD IS NOT ITSELF A NODE IN THE LIST - THINK OF HEAD AS HAVING AN INDEX OF -1
    private Node<K, V> tail;

    public SinglyLinkedList(K headKey){
        this.head = new Node(headKey, null);
        this.tail = new Node("tail", null);
        head.setNext(tail);
        tail.setPrev(head);
        listCount = 0;
    }

    // CLEARS ALL NODES FROM THE LIST
    public boolean clear (){
        if (head != null){                             // if the list exists
            head.setNext(tail).setPrev(head);                        // set the head to have no following node
            listCount = 0;                             // reset the list counter
            return true;                               // tell the user that clear was successful
        }
        return false;                                  //
    }

    // ADDING A NEW NODE TO THE END OF THE LIST
    public void add (K key, V value){
        if (head == null){                             //if adding the first element to the list
            head = new Node("head", null);
        }
//        Node tempNode = new Node(key, value);                // saves the new node to be added later
//        Node currentNode = head;                       // starts at the beginning
//
//        if (currentNode != null) {                     // in case of null pointer exceptions
//            while (currentNode.getNext() != null) {    // as long as the next node exists
//                currentNode = currentNode.getNext();   // make the current node equal the next node
//            }
//            currentNode.setNext(tempNode);             // saves the new node as the last element in the list
//        }
        Node tempNode = new Node(key, value);
        Node prevLastNode = tail.getPrev();
        prevLastNode.setNext(tempNode).setNext(tail).setPrev(tempNode).setPrev(prevLastNode);
        incrementCounter();                            // increment the count of nodes in the list
    }

    // INSERTING A NEW NODE AT A SPECIFIED INDEX
    public void add (K key, V value, int index){
        Node<K, V> tempNode = new Node<K, V>(key, value);                // saves the new node to be added later
        Node<K, V> currentNode = head;                       // starts at the beginning

        if (currentNode != null) {                     // in case of null pointer exceptions
            for (int i = 0; i < index && currentNode.getNext() != null; i++){    // find the directed index, or the end if larger than the current size
                currentNode = currentNode.getNext();
            }
        }
        tempNode.setNext(currentNode.getNext());      // sets the next node to now be after the node being inserted
        currentNode.setNext(tempNode);                // sets the node being inserted as next after the current node
        incrementCounter();                           // increment the count of nodes in the list
    }

    // REMOVES A NODE AT A SPECIFIED INDEX
    public boolean remove (int index) {
        if (index < 0 || index > size()) { return false; }                // ensures the index exists
        Node currentNode = head;                                          // starts at the head
        if (head != null) {                                               // avoids NPE
            for (int i = 0; i <= index; i++) {                            // iterates through the nodes
                if (currentNode.getNext() == null) {                      // if it hasn't found it, returns false (i.e., nothing was removed)
                    return false;
                }
                if (i == index){
                    currentNode.getPrev().setNext(currentNode.getNext())
                            .setPrev(currentNode.getPrev());              // sets the current node (@ i-1) to skip the removed node
                    decrementCounter();                                           // adjust the list size
                    return true;                                                  // lets us know that a node was successfully removed
                }
                currentNode = currentNode.getNext();                      // if it's not at the directed index yet, keep going
            }
        }
        return false;
    }

    public boolean remove (String key){
        if (size() == 0) {return false;}
        Node currentNode = head.getNext();
        for(int i = 0; i < size(); i++){
            if (currentNode.getKey() == key){
                currentNode.getPrev().setNext(currentNode.getNext()).setPrev(currentNode.getPrev());
                decrementCounter();
                return true;
            }
        }
        return false;
    }

    // CHECKS LIST TO SEE IF THE LIST CONTAINS A VALUE
    public boolean contains( V searchData){
        int index = this.find(searchData);
        if (index >= 0) { return true; }
        else { return false; }
    }

    public V get (K key){
        Node<K, V> currentNode = head;
        while (currentNode.hasNext()){
            currentNode = currentNode.getNext();
            if (currentNode.getKey() == key) return currentNode.getValue();
        }
        return null;
    }

    //RETURN INDEX OF SEARCH DATA, OR -1 IF DATA IS NOT IN THE LIST
    public int find(V searchData){
        Node<K, V> currentNode = null;
        if (head != null){                                  // prevents null pointer exception
            if (head.getNext() == null) { return -1;}       // returns -1 if the list is empty
            currentNode = head.getNext();                   // starts at index 0 (REMEMBER - HEAD IS NOT PART OF THE LIST, HEAD.GETNEXT IS INDEX 0)
            for (int i = 0; i < this.size(); i++) {         // iterates through the list if index is greater than 0 (if index = 0, skips the loop)
                if (currentNode.getValue().equals(searchData)) {
                    return i;
                }
//                if (currentNode.getNext() == null) {      // returns null if it hasn't found it in the list
//                    return false;
//                }
                currentNode = currentNode.getNext();        // sets the current to the next item
            }
//            return currentNode.getData();                 // returns the found node data
        }
        return -1;                                          // returns -1 if data was not found
    }

    // RETURNS CURRENT SIZE OF THE LIST
    public int size(){
        return listCount;
    }

    // RETURNS OBJECT AT A SPECIFIED INDEX
    public V get(int index){
        if (index < 0){ return null; }                // prevents out of bounds exception
        Node<K, V> currentNode = null;
        if (head != null){                            // prevents null pointer exception
            if (head.getNext() == null) { return null;} //returns null if the list is empty
            currentNode = head.getNext();             // starts at index 0 (NOTE - HEAD IS NOT PART OF THE LIST, HEAD.GETNEXT IS INDEX 0)
            for (int i = 0; i < index; i++) {         // iterates through the list if index is greater than 0 (if index = 0, skips the loop)
                if (currentNode.getNext() == null) {  // returns null if it hasn't found it in the list
                    return null;
                }
                currentNode = currentNode.getNext();  // sets the current to the next item
            }
            return currentNode.getValue();             // returns the found node data
        }
        return (V) currentNode;                           // returns current
    }

//    // RETURNS A NEW LIST CONTAINING THE SAME VALUES AS THIS.LIST (THIS WILL BE A DEEP COPY - i.e., COMPLETELY INDEPENDENT OF THE ORIGINAL)
//    public SinglyLinkedList <K, V> copy(){
//        SinglyLinkedList <K, V> listCopy = new SinglyLinkedList();
//        Node<K, V> currentNode = null;
//        if (this.head == null) { return listCopy;}              // returns a null list if this. is null
//        if (this.head.getNext() == null) {                      // returns an empty list if this.size() = 0
//            listCopy.add(K, "");
//            listCopy.clear();                                   // (you can't clear a null list.....)
//        }
//        if (this.head.getNext() != null){                       // returns a copy of the list if it has at least one node after the head
//            currentNode = this.head.getNext();
//            while (currentNode != null){
//                listCopy.add(currentNode.getValue());
//                currentNode = currentNode.getNext();
//            }
//        }
//        return listCopy;
//    }

//    // RETURNS A SORTED VERSION OF THE INDICATED LIST
//    public SinglyLinkedList <K, V> sort() {
//        boolean sorted = false;
//        while (!sorted) {
//            sorted = true;
//            for (Node<K, V> node = this.head; node.getNext() != null; node = node.getNext()) {
//                if (node.getValue().compareTo(node.getNext().getValue())) {
//                    node.swapNext();
//                    sorted = false;
//                }
//            }
//        }
//        return this;
//    }

//        Node currentNode = null;
//        Node tempNode = null;
//        if (head.getNext() != null) {currentNode = head.getNext();}
//        for (int i = 0; i < this.size()-1; i++){
//            for (int j = 0; j < this.size()-i-j; j++){
//                if (currentNode.getData().toString().length() > currentNode.getNext().getData().toString().length()){
//
//                    tempNode = currentNode;
//                    currentNode = currentNode.getNext();
//                    currentNode.getNext() = tempNode;
//
//                }
//            }
//        }
//        return false;

    // OPTIONAL - REVERSES THE ORDER OF THE LIST
    public void reverse(){
        // optional
        // build tail and prevNode to do this, and just make a copy
        // start from tail.getPrev() for the source array and set head.getNext of the new array
    }

    // OPTIONAL - RETURNS A SUBSET OF THIS.LIST
    public SinglyLinkedList slice(){
        // optional - but if completed, reference this when doing the copy
        return null;
    }

    // NOT IN DIRECTIONS, BUT I WANTED TO DO IT ANYWAY
    public String toString() {
        String output = "";
        if (this.getHead().getKey() == null) { return "list has not been instantiated"; }
        if (head != null) {
            if (this.getHead().getNext() == tail){ return "list is empty"; }
            Node currentNode = head.getNext();
            while (currentNode != tail) {
                output += "[" + currentNode.getValue().toString() + "]";
                currentNode = currentNode.getNext();
            }
        }
        return output;
    }

    public Node<K, V> getHead(){
        return this.head;
    }

    public Node<K, V> getTail(){
        return this.tail;
    }

    private void incrementCounter(){
        listCount++;
    }

    private void decrementCounter(){
        listCount--;
    }

}
