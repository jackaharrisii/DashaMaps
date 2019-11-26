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
//        testDashaMapOne.getDashaMapOne().getSinglyLinkedList("d").add("dog", "5");
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
    }

    @Test
    public void get() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void size() {
    }
}