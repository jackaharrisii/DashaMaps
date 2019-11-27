import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapThreeTest {

    private DashaMapThree testDashaMapThree;
    private DashaMapThree testWordListThree;

    @Before
    public void setUp() throws Exception {
        testDashaMapThree = new DashaMapThree();
        testDashaMapThree.put("aardvark", "5");
        testWordListThree = new DashaMapThree();
        testWordListThree.addAllValuesFromWordList(Reader.readWordList());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void putTest(){
        testDashaMapThree.put("cat", "9");
        Assert.assertEquals("9", testDashaMapThree.getDashaMapThree().getSinglyLinkedList("ca").get("cat"));
    }

    @Test
    public void setTest() {
        testDashaMapThree.set("aardvark", "9");
        Assert.assertEquals("9", testDashaMapThree.getDashaMapThree().getSinglyLinkedList("aa").get("aardvark"));
    }

    @Test
    public void delete() {
        testDashaMapThree.put("giraffe", "13");
        Assert.assertEquals("13", testDashaMapThree.getDashaMapThree().getSinglyLinkedList("gi").get("giraffe"));
        testDashaMapThree.delete("giraffe");
        Assert.assertNull(testDashaMapThree.getDashaMapThree().getSinglyLinkedList("giraffe"));
    }

    @Test
    public void get() {
        Assert.assertEquals("5", testDashaMapThree.get("aardvark"));
    }

    @Test
    public void getWordList(){
        Assert.assertEquals("2", testWordListThree.get("me"));
    }

    @Test
    public void getWordList2(){
        Assert.assertEquals("34", testWordListThree.get("both"));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testDashaMapThree.isEmpty());
    }


    @Test
    public void isEmpty2() {
        testDashaMapThree.delete("aardvark");
        Assert.assertTrue(testDashaMapThree.isEmpty());
    }

    @Test
    public void isWordListEmpty(){
        Assert.assertFalse(testWordListThree.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(1, testDashaMapThree.size(), 0.0001);
    }

    @Test
    public void wordListSize(){
        Assert.assertEquals(122, testWordListThree.size());
    }
    // size is two fewer words than DashaMapOne, because DashaMapTwo omits the two words of only one character each

}