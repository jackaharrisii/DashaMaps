public class DashaMapOne implements HashMapX{

    private MyCustomHashMap dashaMapOne;
    String hashKey;

    public MyCustomHashMap getDashaMapOne() {
        return dashaMapOne;
    }

    public DashaMapOne(){
        dashaMapOne = new MyCustomHashMap();
    }

    private String hashFunctionOne(String input) {
        if (input.length() > 0) {
//            return String.toLowerCase(String.valueOf(input.charAt(0)));       //had to rearrange to get toLowerCase() to work
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    public void put(String listKey, String value) {
        for(SinglyLinkedList thisList : dashaMapOne.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionOne(listKey))){
                thisList.add(listKey, value);
            }
        }
    }

    @Override
    public void set(String listKey, String value) {
        for(SinglyLinkedList thisList : dashaMapOne.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionOne(listKey))){
                thisList.set(listKey, value);
            }
        }
    }

    @Override
    public String delete(String key) {
        hashKey = hashFunctionOne(key);
        dashaMapOne.getSinglyLinkedList(hashKey).remove(key);
        return null;
    }

    @Override
    public String get(String listKey) {
        hashKey = hashFunctionOne(listKey);
        dashaMapOne.getSinglyLinkedList(hashKey).find(listKey);
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() > 0) return false;
        return true;
    }

    @Override
    public long size() {
        long count = 0;
        for (int i = 0; i < 26; i++){
            dashaMapOne.getSinglyLinkedList(i).size();
        }
        return count;
    }

//    @Override
//    protected boolean bucketSize(String key) {
//        return false;
//    }

}
