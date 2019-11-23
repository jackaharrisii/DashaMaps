import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    Node testNode;
    Node testNode2;
    Node wanderer;

    @Before
    public void setUp() throws Exception {
        testNode = new Node("p", "psoriasis");
        testNode2 = new Node("f", "fjord");
        testNode.setNext(testNode2).setPrev(testNode);
        wanderer = new Node("w", "The Wanderer");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getKey() {
        Assert.assertEquals("p", testNode.getKey());
    }

    @Test
    public void getValue() {
        Assert.assertEquals("psoriasis", testNode.getValue());
    }

    @Test
    public void getNext() {
        Assert.assertEquals("f", testNode.getNext().getKey());
    }

    @Test
    public void setNext() {
        testNode2.setNext(wanderer);
        Assert.assertEquals(wanderer, testNode2.getNext());
    }

    @Test
    public void hasNext() {
        Assert.assertTrue(testNode.hasNext());
        Assert.assertFalse(wanderer.hasNext());
    }

    @Test
    public void getPrev() {
        Assert.assertEquals(testNode, testNode2.getPrev());
    }

    @Test
    public void setPrev() {
        wanderer.setPrev(testNode2);
        Assert.assertEquals(testNode2,wanderer.getPrev());
    }

//    @Test
//    public void linkToPrev() {
//    }

}