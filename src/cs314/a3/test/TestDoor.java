/**
TestDoor.java
TODO: description of file
Author: M. Bostwick, Sep 30, 2010
 */
package cs314.a3.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314.a3.src.Door;
import cs314.a3.src.Key;
import cs314.a3.src.Player;
import cs314.a3.src.Room;
import cs314.a3.src.Wall;

/**
 * @author myles
 *
 */
public class TestDoor {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test
	public void testTwoRoomEnter() {
		Player p = new Player();
		Room room1 = new Room();
		Room room2 = new Room();
		Key key = new Key();
		
		Door test = new Door(room1, room2, key);
		
		room1.setSide(2, test);
		room2.setSide(3, test);
		p.setLoc(room1);
		
		test.enter(p);
		
		assertNotSame(room2, p.getLoc());
		p.pickUp(key);
		test.enter(p);
		
		assertSame(room2, p.getLoc());
	}

	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test
	public void testTwoRoomWithPassageToEachSide() {
		Player p = new Player();
		Room room1 = new Room();
		Room room2 = new Room();
		Key key = new Key();
		
		Door test = new Door(room1, room2, key);
		
		room1.setSide(2, room2);
		room2.setSide(3, room1);
		p.setLoc(room1);
		
		test.enter(p);
		
		assertNotSame(room2, p.getLoc());
		p.pickUp(key);
		test.enter(p);
		
		assertSame(room2, p.getLoc());
		
		test.enter(p);
		assertSame(room1, p.getLoc());
		
		p.drop(1);
		test.enter(p);
		assertSame(room1, p.getLoc());
	}
	
	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test(expected=NullPointerException.class)
	public void testDoorWithNullRoom() {
		Player p = new Player();
		Room room1 = new Room();
		Room room2 = new Room();
		Key key = new Key();
		
		Door test = new Door(room1, null, key);
		
		room1.setSide(2, room2);
		room2.setSide(3, room1);
		p.setLoc(room1);
		
		test.enter(p);
		
		assertNotSame(room2, p.getLoc());
		p.pickUp(key);
		test.enter(p);
		
		assertSame(room2, p.getLoc());
		test.enter(p);
		
	}
	
	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test
	public void testDoorWithRecursiveRoom() {
		Player p = new Player();
		Room room1 = new Room();
		Key key = new Key();
		
		Door test = new Door(room1, room1, key);
		
		room1.setSide(2, room1);
		p.setLoc(room1);
		
		test.enter(p);
		
		assertSame(room1, p.getLoc());
		p.pickUp(key);
		test.enter(p);
		
		assertSame(room1, p.getLoc());
		
	}
	
	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test
	public void testDoorWithWallsAsSites() {
		Player p = new Player();
		Wall wall1 = new Wall();
		Wall wall2 = new Wall();
		Room room = new Room();
		Key key = new Key();
		
		Door test = new Door(wall1, wall2, key);
		
		room.setSide(2, test);
		p.setLoc(room);
		
		test.enter(p);
		
		assertSame(wall1, p.getLoc());
		p.pickUp(key);
		test.enter(p);
		
		assertSame(wall2, p.getLoc());
		
	}
	
	/**
	 * Test method for {@link cs314.a3.src.Door#enter(cs314.a3.src.Player)}.
	 */
	@Test
	public void testDoorWithWrongKeys() {
		Player p = new Player();
		Room room1 = new Room();
		Room room2 = new Room();
		Key key1 = new Key();
		Key key2 = new Key();
		
		Door test = new Door(room1, room2, key2);
		
		room1.setSide(2, test);
		p.setLoc(room1);
		
		test.enter(p);
		
		assertSame(room1, p.getLoc());
		p.pickUp(key1);
		test.enter(p);
		
		assertSame(room1, p.getLoc());
		p.pickUp(key2);
		test.enter(p);
		
		assertSame(room2, p.getLoc());
		
	}
}
