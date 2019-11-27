import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

    public static SinglyLinkedList testAList;
    public static SinglyLinkedList nullList;

    @Before
    public void setUp() throws Exception {
        nullList = new SinglyLinkedList(null);
        testAList = new SinglyLinkedList("a");
        testAList.add("aa", "1");
        testAList.add("ab", "2");
        testAList.add("ac", "3");
        testAList.add("ad", "4");
        testAList.add("ae", "5");
    }

    @After
    public void tearDown() throws Exception{
        testAList.clear();
    }

    @Test
    public void testNullaryConstructor(){
        Assert.assertEquals(0, nullList.getListCount());
        Assert.assertNull(nullList.get(0));
    }

    @Test
    public void testClear(){
        Assert.assertTrue(testAList.clear());
        Assert.assertEquals(0, testAList.getListCount());
        Assert.assertNull(testAList.get(0));
        Assert.assertEquals(testAList.getHead().getNext(), testAList.getTail());
    }

    @Test
    public void testAdd(){
        testAList.add("a", "6");
        Assert.assertEquals("6", testAList.get(5));
        Assert.assertEquals(6, testAList.getListCount());
    }

    @Test
    public void testAdd2(){
        testAList.add("Q", "Q", 2);
        Assert.assertEquals("Q", testAList.get(2));
        Assert.assertEquals("3", testAList.get(3));
        Assert.assertEquals(6, testAList.getListCount());
    }

    @Test
    // removes from middle of list
    public void testRemove(){
        Assert.assertTrue(testAList.remove(2));
        Assert.assertEquals("4", testAList.get(2));
        Assert.assertEquals(4, testAList.getListCount());
    }

    @Test
    // removes the first element in the list
    public void testRemove2(){
        Assert.assertTrue(testAList.remove(0));
        Assert.assertEquals("2", testAList.get(0));
        Assert.assertEquals(4, testAList.getListCount());
    }

    @Test
    public void testContains(){
        Assert.assertTrue(testAList.contains("1"));
        Assert.assertTrue(testAList.contains("5"));
        Assert.assertFalse(testAList.contains("Q"));
    }

    @Test
    public void testFind(){
        Assert.assertEquals(0, testAList.find("1"));
        Assert.assertEquals(3, testAList.find("4"));
        Assert.assertEquals(-1, testAList.find("Horse"));
    }

    @Test
    public void testSize(){
        Assert.assertEquals(5, testAList.getListCount());
    }

    @Test
    // test get when object exists
    public void testGet(){
        Assert.assertEquals("3", testAList.get(2));
    }

    @Test
    // test get when object does not exist
    public void testGet2(){
        Assert.assertNull(testAList.get(8));
    }

    @Test
    // test get when passing an invalid index
    public void testGet3(){
        Assert.assertNull(testAList.get(-1));
    }

    @Test
    public void testToString(){
        String expected = "[1][2][3][4][5]";
        Assert.assertEquals(expected, testAList.toString());
    }

    @Test
    // test toString with a null list
    public void testToString2(){
        String expected = "list has not been instantiated";
        Assert.assertEquals(expected,nullList.toString());
    }

    @Test
    // test toString with an empty list
    public void testToString3(){
        testAList.clear();
        String expected = "list is empty";
        Assert.assertEquals(expected, testAList.toString());
    }

//        @Test
//        // test copy an existing list
//        public void testCopy(){
//            SinglyLinkedList copyOfTestList = new SinglyLinkedList();
//            copyOfTestList = testList.copy();
//            Assert.assertEquals(testList.toString(),copyOfTestList.toString());
//        }
//
//        @Test
//        // test copy an empty list
//        public void testCopy2(){
//            SinglyLinkedList copyOfTestList = new SinglyLinkedList();
//            testList.clear();
//            copyOfTestList = testList.copy();
//            Assert.assertEquals(testList.toString(),copyOfTestList.toString());
//        }
//
//        @Test
//        // test copy a null list
//        public void testCopy3(){
//            SinglyLinkedList copyOfTestList = new SinglyLinkedList();
//            copyOfTestList = nullList.copy();
//            Assert.assertEquals(nullList.toString(),copyOfTestList.toString());
//        }
//
//        @Test
//        // sort a list of E's
//        public void testSort(){
//            testList.add("Q");
//            testList.add("8");
//            Assert.assertEquals("[1][2][3][4][5][8][Q]", testList.sort().toString());
//        }

}