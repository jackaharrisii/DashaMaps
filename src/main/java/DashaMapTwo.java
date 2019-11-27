public class DashaMapTwo implements HashMapX{

    private MyCustomHashMap dashaMapTwo;
    String hashKey;

    public MyCustomHashMap getDashaMapTwo() {
        return dashaMapTwo;
    }

    public DashaMapTwo(){
        dashaMapTwo = new MyCustomHashMap(1);
    }

    private String hashFunctionTwo(String input) {
        if (input.length() > 1) {
//            return String.toLowerCase(String.valueOf(input.charAt(1)));       //had to rearrange to get toLowerCase() to work
            return String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;  // obviously, this wasn't "nil"
    }

    public void put(String listKey, String value) {
        for(SinglyLinkedList thisList : dashaMapTwo.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionTwo(listKey))){
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
        for(SinglyLinkedList thisList : dashaMapTwo.getHashArray()){
            if (thisList.getHead().getKey().equals(hashFunctionTwo(listKey))){
                thisList.set(listKey, value);
            }
        }
    }

    @Override
    public String delete(String key) {
        hashKey = hashFunctionTwo(key);
        dashaMapTwo.getSinglyLinkedList(hashKey).remove(key);
        return null;
    }

    @Override
    public String get(String listKey) {
        hashKey = hashFunctionTwo(listKey);
        return String.valueOf(dashaMapTwo.getSinglyLinkedList(hashKey).get(listKey));
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
        for (int i = 0; i < 26; i++){
            count += dashaMapTwo.getSinglyLinkedList(i).getListCount();
        }
        return count;
    }

//    @Override
//    protected boolean bucketSize(String key) {
//        return false;
//    }

}
