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
    private Item itemA;

    @Before public void setUp() {
        //System.out.println("setUp()");
        simpleRoom = new Room();
        itemA = new Item();
        itemA.setDesc("A Rock");
    }

    @After public void tearDown() {
        // Nothing to tear down, thanks automatic GC! -jt
    }

    /**
     * Test method for {@link cs314.a3.src.Room#addItem(cs314.a3.src.Item)}.
     * (I expect this test to fail -jt)
     */
    @Test public void testAddNullItem() {
        Item[] pre = simpleRoom.getRoomContents();
        simpleRoom.addItem(null);
        Item[] post = simpleRoom.getRoomContents();
        assertTrue(pre.length == post.length);
        assertTrue(simpleRoom.roomEmpty());
    }

    /**
     * Test method for {@link cs314.a3.src.Room#addItem(cs314.a3.src.Item)}.
     */
    @Test public void testAddItem() {
        simpleRoom.addItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 1);
        assertTrue(itemA == simpleRoom.getRoomContents()[0]);
        assertFalse(simpleRoom.roomEmpty());
        simpleRoom.addItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 2);
        assertTrue(itemA == simpleRoom.getRoomContents()[1]);

    }

    /**
     * Test method for {@link cs314.a3.src.Room#removeItem(Item)}
     * This should fail quietly. How the heck to verify? -jt
     */
    @Test public void testRemoveNullItem() {
        //setUp();
        simpleRoom.addItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 1);
        simpleRoom.removeItem(null);
        assertTrue(simpleRoom.getRoomContents().length == 1);
        
    }

    /**
     * Test method for {@link cs314.a3.src.Room#removeItem(Item)}
     */
    @Test public void testRemoveItemNotThere() {
        simpleRoom.addItem(new Item());
        simpleRoom.addItem(new Item());
        simpleRoom.removeItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 2);
    }
    
    /**
     * Test method for {@link cs314.a3.src.Room#removeItem(Item)}
     */
    @Test public void testRemoveItem() {
        simpleRoom.addItem(itemA);
        simpleRoom.removeItem(itemA);
        assertTrue(simpleRoom.roomEmpty());
        simpleRoom.addItem(new Item());
        simpleRoom.addItem(itemA);
        simpleRoom.removeItem(itemA);
        assertTrue(simpleRoom.getRoomContents().length == 1);
        
    }
}
