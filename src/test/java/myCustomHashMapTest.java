import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class myCustomHashMapTest {

    MyCustomHashMap testMyCustomHashMap;
    SinglyLinkedList expectedAList;

    @Before
    public void setUp() throws Exception {
        testMyCustomHashMap = new MyCustomHashMap();
        expectedAList = new SinglyLinkedList("a");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructorTest(){
        Assert.assertEquals("a", testMyCustomHashMap.getSinglyLinkedList(0).getHead().getKey());
        Assert.assertEquals("i", testMyCustomHashMap.getSinglyLinkedList(8).getHead().getKey());
        Assert.assertEquals("q", testMyCustomHashMap.getSinglyLinkedList(16).getHead().getKey());
        Assert.assertEquals("z", testMyCustomHashMap.getSinglyLinkedList(25).getHead().getKey());
        Assert.assertEquals(26, testMyCustomHashMap.sizeOfHashArray());
    }

}