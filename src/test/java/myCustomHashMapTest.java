import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class myCustomHashMapTest {

    MyCustomHashMap testMyCustomHashMap;
    MyCustomHashMap testMyDeepHashMap;
//    SinglyLinkedList expectedAList;

    @Before
    public void setUp() throws Exception {
        testMyCustomHashMap = new MyCustomHashMap(1);
        testMyDeepHashMap = new MyCustomHashMap(2);
//        expectedAList = new SinglyLinkedList("a");
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

    @Test
    public void deepConstructorTest(){
        Assert.assertEquals("aa", testMyDeepHashMap.getSinglyLinkedList(0).getHead().getKey());
        Assert.assertEquals("iq", testMyDeepHashMap.getSinglyLinkedList(224).getHead().getKey());
        Assert.assertEquals("qi", testMyDeepHashMap.getSinglyLinkedList(424).getHead().getKey());
        Assert.assertEquals("zz", testMyDeepHashMap.getSinglyLinkedList(675).getHead().getKey());
        Assert.assertEquals(676, testMyDeepHashMap.sizeOfHashArray());
    }

}