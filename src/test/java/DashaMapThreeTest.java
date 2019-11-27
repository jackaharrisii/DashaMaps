import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapThreeTest {

    private DashaMapThree testDashaMapThree;

    @Before
    public void setUp() throws Exception {
        testDashaMapThree = new DashaMapThree();
        testDashaMapThree.put("aardvark", "5");
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
        Assert.assertEquals("5", testDashaMapThree.getDashaMapThree().getSinglyLinkedList("aa").get("aardvark"));
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
    public void size() {
        Assert.assertEquals(1, testDashaMapThree.size(), 0.0001);
    }

}