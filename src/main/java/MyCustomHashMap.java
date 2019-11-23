import java.util.ArrayList;

public class MyCustomHashMap {

    final String[] alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
    private ArrayList<SinglyLinkedList<String, String>> hashArray;

    public MyCustomHashMap(){
        hashArray = new ArrayList<>(26);
        for (int i = 0; i < alphabet.length; i++){
            hashArray.add( new SinglyLinkedList<String, String>(alphabet[i]));
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
}
