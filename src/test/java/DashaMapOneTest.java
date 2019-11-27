import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DashaMapOneTest {

    private DashaMapOne testDashaMapOne;

    @Before
    public void setUp() throws Exception {
        testDashaMapOne = new DashaMapOne();
        testDashaMapOne.put("dog", "5");
//        testDashaMapOne.getDashaMapOne().getSinglyLinkedList("d").add("dog", "5");  // <- long version of the above line
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void putTest(){
        testDashaMapOne.put("cat", "9");
        Assert.assertEquals("9", testDashaMapOne.getDashaMapOne().getSinglyLinkedList("c").get("cat"));
    }

    @Test
    public void setTest() {
        testDashaMapOne.set("dog", "9");
        Assert.assertEquals("9", testDashaMapOne.getDashaMapOne().getSinglyLinkedList("d").get("dog"));
    }

    @Test
    public void delete() {
        testDashaMapOne.put("giraffe", "13");
        Assert.assertEquals("13", testDashaMapOne.getDashaMapOne().getSinglyLinkedList("g").get("giraffe"));
        testDashaMapOne.delete("giraffe");
        Assert.assertNull(testDashaMapOne.getDashaMapOne().getSinglyLinkedList("giraffe"));
    }

    @Test
    public void get() {
        Assert.assertEquals("5", testDashaMapOne.getDashaMapOne().getSinglyLinkedList("d").get("dog"));
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testDashaMapOne.isEmpty());
    }

    @Test
    public void isEmpty2() {
        testDashaMapOne.delete("dog");
        Assert.assertTrue(testDashaMapOne.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(1, testDashaMapOne.size(), 0.0001);
    }
}