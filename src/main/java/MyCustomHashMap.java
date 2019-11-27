import java.util.ArrayList;

public class MyCustomHashMap {

    final String[] mapKeyArray = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

    public ArrayList<SinglyLinkedList<String, String>> getHashArray() {
        return hashArray;
    }

    private ArrayList<SinglyLinkedList<String, String>> hashArray;

    public MyCustomHashMap(int depth){
        if (depth == 1){
            hashArray = new ArrayList<>(26);    // initial capacity for reference only - doesn't actually change anything
            for (int i = 0; i < mapKeyArray.length; i++){
                hashArray.add( new SinglyLinkedList<String, String>(mapKeyArray[i]));
            }
        } else if (depth == 2){
            hashArray = new ArrayList<>(676);   // initial capacity for reference only - doesn't actually change anything
            for (int i = 0; i < mapKeyArray.length; i++){
                for (int j = 0; j < mapKeyArray.length; j++){
                    hashArray.add(new SinglyLinkedList<String, String>(mapKeyArray[i] + mapKeyArray[j]));
                }
            }
        }
    }

    public SinglyLinkedList<String, String> getSinglyLinkedList(int index){
        return hashArray.get(index);
    }

    public SinglyLinkedList<String, String> getSinglyLinkedList(String key){
        for (SinglyLinkedList list : hashArray){
            if (list.getHead().getKey().equals(key)){
                return list;
            }
        }
        return null;
    }

    //used to construct a HashArray without a pre-defined key set
    public void put (String hashKey, String key, String value){
        for(int i = 0; i < hashArray.size(); i++){
            if (hashArray.get(i).getHead().getKey().equals(hashKey)){
                hashArray.get(i).add(key, value);
                break;
            }
        }
    }

    // returns the size of the HashArray
    public int sizeOfHashArray (){
        return hashArray.size();
    }

//    @Override
//    // arrayListKey is decided in DashaMapOne, DashaMapTwo, etc
//    // how do I pass this and still override the set found in the interface?
//    public void set(String singlyLinkedListKey, String value) {
//        for(SinglyLinkedList thisList : this.getHashArray()){
//            if (thisList.getHead().getKey().equals(arrayListKey)){
//                thisList.set(singlyLinkedListKey, value);
//            }
//        }
//    }
//
////    @Override
////    // how do I pass each hashKey and still override the superclass method for set???
////    public void set(String listKey, String value) {
////        hashKey = hashFunctionOne(listKey);
////        dashaMapOne.put(hashKey, listKey, value);
////    }
//
//    @Override
//    public String delete(String key) {
////        hashKey = hashFunctionOne(key);
////        dashaMapOne.getSinglyLinkedList(hashKey).remove(key);
//        return null;
//    }
//
//    @Override
//    public String get(String listKey) {
////        hashKey = hashFunctionOne(listKey);
////        this.getSinglyLinkedList(hashKey).find(listKey);
//        return null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        if (size() > 0) return false;
//        return true;
//    }
//
//    @Override
//    public long size() {
//        long count = 0;
//        for (int i = 0; i < 26; i++){
//            this.getSinglyLinkedList(i).size();
//        }
//        return count;
//    }

}
