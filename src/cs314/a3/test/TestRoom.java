/**
 * 
 */
package cs314.a3.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import cs314.a3.src.Door;
//import cs314.a3.src.Key;
//import cs314.a3.src.Player;
import cs314.a3.src.Room;
import cs314.a3.src.Item;

//import cs314.a3.src.Wall;

public class TestRoom {

    private Room simpleRoom;

    @Before public void setUp() {
        simpleRoom = new Room();
    }

    @After public void tearDown() {
        // Nothing to tear down, thanks automatic GC! -jt
    }

    /**
     * Test method for {@link cs314.a3.src.Room#addItem(cs314.a3.src.Item)}.
     * (I expect this test to fail -jt)
     */
    @Test(expected = NullPointerException.class) public void testAddNullItem() {
        Item[] pre = simpleRoom.getRoomContents();
        simpleRoom.addItem(null);
        Item[] post = simpleRoom.getRoomContents();
        assertTrue(pre.length == post.length);
    }

    /**
     * Test method for {@link cs314.a3.src.Room#addItem(cs314.a3.src.Item)}.
     */
    @Test public void testAddItem() {
        setUp();
        Item itemA = new Item();
        itemA.setDesc("A Rock");
        simpleRoom.addItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 1);
        assertTrue(itemA == simpleRoom.getRoomContents()[0]);

    }

    /**
     * Test method for {@link cs314.a3.src.Room#removeItem(Item)}
     */
    @Test public void testRemoveNullItem() {
        setUp();
    }

    /**
     * Test method for {@link cs314.a3.src.Room#removeItem(Item)}
     */
    @Test public void testRemoveItemNotThere() {

    }
}
