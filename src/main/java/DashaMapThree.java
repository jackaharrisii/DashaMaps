public class DashaMapThree implements HashMapX{

    private MyCustomHashMap dashaMapThree;
    String hashKey;

    public MyCustomHashMap getDashaMapThree() {
        return dashaMapThree;
    }

    public DashaMapThree(){
        dashaMapThree = new MyCustomHashMap(2);
    }

    private String hashFunctionThree(String input) {
        if (input.length() > 1) {
//            return String.toLowerCase(String.valueOf(input.charAt(1)));       //had to rearrange to get toLowerCase() to work
            return String.valueOf(input.charAt(0)).toLowerCase() + String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;  // obviously, this wasn't "nil"
    }



    public void put(String listKey, String value) {
        for(SinglyLinkedList thisList : dashaMapThree.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionThree(listKey))){
                thisList.add(listKey, value);
            }
        }
    }

    public void addAllValuesFromWordList(String wordList){
        String[] keyValuePairs = wordList.split("\n");
        for (int i = 0; i < keyValuePairs.length; i++){
            String[] eachPair = keyValuePairs[i].split(" +");
            put(eachPair[0], eachPair[1]);
//            System.out.println(eachPair[0] + " " + eachPair[1]);
        }

    }

    @Override
    public void set(String listKey, String value) {
        for(SinglyLinkedList thisList : dashaMapThree.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionThree(listKey))){
                thisList.set(listKey, value);
            }
        }
    }

    @Override
    public String delete(String key) {
        hashKey = hashFunctionThree(key);
        dashaMapThree.getSinglyLinkedList(hashKey).remove(key);
        return null;
    }

    @Override
    public String get(String listKey) {
        hashKey = hashFunctionThree(listKey);
        return String.valueOf(dashaMapThree.getSinglyLinkedList(hashKey).get(listKey));
//        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() > 0) return false;
        return true;
    }

    @Override
    public long size() {
        long count = 0;
        for (int i = 0; i < 676; i++){
            count += dashaMapThree.getSinglyLinkedList(i).getListCount();
        }
        return count;
    }

//    @Override
//    protected boolean bucketSize(String key) {
//        return false;
//    }

}
