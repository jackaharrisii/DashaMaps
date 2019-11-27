import java.io.IOException;
import java.util.ArrayList;

public class DashaMapOne implements HashMapX{

    private MyCustomHashMap dashaMapOne;
    String hashKey;

    public MyCustomHashMap getDashaMapOne() {
        return dashaMapOne;
    }

    public DashaMapOne() {
        dashaMapOne = new MyCustomHashMap(1);
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
        return String.valueOf(dashaMapOne.getSinglyLinkedList(hashKey).get(listKey));
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
            count += dashaMapOne.getSinglyLinkedList(i).getListCount();
        }
        return count;
    }

//    @Override
//    protected boolean bucketSize(String key) {
//        return false;
//    }

}
