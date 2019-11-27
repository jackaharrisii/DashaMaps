import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapTwoTest {

    private DashaMapTwo testDashaMapTwo;
    private DashaMapTwo testWordListTwo;

    @Before
    public void setUp() throws Exception {
        testDashaMapTwo = new DashaMapTwo();
        testDashaMapTwo.put("dog", "5");
        testWordListTwo = new DashaMapTwo();
        testWordListTwo.addAllValuesFromWordList(Reader.readWordList());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void putTest(){
        testDashaMapTwo.put("cat", "9");
        Assert.assertEquals("9", testDashaMapTwo.getDashaMapTwo().getSinglyLinkedList("a").get("cat"));
    }

    @Test
    public void setTest() {
        testDashaMapTwo.set("dog", "9");
        Assert.assertEquals("9", testDashaMapTwo.getDashaMapTwo().getSinglyLinkedList("o").get("dog"));
    }

    @Test
    public void delete() {
        testDashaMapTwo.put("giraffe", "13");
        Assert.assertEquals("13", testDashaMapTwo.getDashaMapTwo().getSinglyLinkedList("i").get("giraffe"));
        testDashaMapTwo.delete("giraffe");
        Assert.assertNull(testDashaMapTwo.getDashaMapTwo().getSinglyLinkedList("giraffe"));
    }

    @Test
    public void get() {
        Assert.assertEquals("5", testDashaMapTwo.getDashaMapTwo().getSinglyLinkedList("o").get("dog"));
    }

    @Test
    public void getWordList(){
        Assert.assertEquals("2", testWordListTwo.get("me"));
    }

    @Test
    public void getWordList2(){
        Assert.assertEquals("34", testWordListTwo.get("both"));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testDashaMapTwo.isEmpty());
    }


    @Test
    public void isEmpty2() {
        testDashaMapTwo.delete("dog");
        Assert.assertTrue(testDashaMapTwo.isEmpty());
    }

    @Test
    public void isWordListEmpty(){
        Assert.assertFalse(testWordListTwo.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(1, testDashaMapTwo.size(), 0.0001);
    }

    @Test
    public void wordListSize(){
        Assert.assertEquals(122, testWordListTwo.size());
    }
    // size is two fewer words than DashaMapOne, because DashaMapTwo omits the two words of only one character each

}