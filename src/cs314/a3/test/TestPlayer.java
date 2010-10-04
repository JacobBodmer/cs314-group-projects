package cs314.a3.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314.a3.src.*;

public class TestPlayer {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBadDirection() {
		Player player = new Player();
		Room room = new Room();
		player.setLoc(room);
		
		try {
			player.go(-1);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		try {
			player.go(6);
			assertTrue(false);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
		
	@Test
	public void testGoWalls() {
		Player player = new Player();
		Room room = new Room();
		player.setLoc(room);

		try {
			for (int i = 0; i < 6; i++) {
				player.go(i);
				assertSame(player.getLoc(), room);
			}
		} catch (Exception e) {
			fail("Exception thrown while testing directions");
		}
	}
	
	@Test
	public void testSimpleStructure() {
		Player player = new Player();
		Room[] rooms = new Room[7];
		for(int i = 0; i < 7; i++) {
			rooms[i] = new Room();
		}
		player.setLoc(rooms[0]);
		
		rooms[0].setSide(0, rooms[1]);
		rooms[1].setSide(1, rooms[0]);
		rooms[0].setSide(1, rooms[2]);
		rooms[2].setSide(0, rooms[0]);
		rooms[0].setSide(2, rooms[3]);
		rooms[3].setSide(3, rooms[0]);
		rooms[0].setSide(3, rooms[4]);
		rooms[4].setSide(2, rooms[0]);
		rooms[0].setSide(4, rooms[5]);
		rooms[5].setSide(5, rooms[0]);
		rooms[0].setSide(5, rooms[6]);
		rooms[6].setSide(4, rooms[0]);

		// north
		player.go(0);
		assertSame(player.getLoc(), rooms[1]);
		player.go(1);
		assertSame(player.getLoc(), rooms[0]);

		// south
		player.go(1);
		assertSame(player.getLoc(), rooms[2]);
		player.go(0);
		assertSame(player.getLoc(), rooms[0]);

		// east
		player.go(2);
		assertSame(player.getLoc(), rooms[3]);
		player.go(3);
		assertSame(player.getLoc(), rooms[0]);

		// west
		player.go(3);
		assertSame(player.getLoc(), rooms[4]);
		player.go(2);
		assertSame(player.getLoc(), rooms[0]);

		// up
		player.go(4);
		assertSame(player.getLoc(), rooms[5]);
		player.go(5);
		assertSame(player.getLoc(), rooms[0]);

		// down
		player.go(5);
		assertSame(player.getLoc(), rooms[6]);
		player.go(4);
		assertSame(player.getLoc(), rooms[0]);
	}
	
	@Test
	public void testGoDoor() {
		Player player = new Player();
		Key key1 = new Key(), key2 = new Key();
		Room room1 = new Room(), room2 = new Room();
		Door door1 = new Door(room1, room2, key1), door2 = new Door(room1, room2, key2);
		
		player.setLoc(room1);

		player.pickUp(key1);
		room1.setSide(0, door1);
		room1.setSide(1, door2);
		room2.setSide(1, door1);
		room2.setSide(0, door2);
	
		player.go(1);
		assertSame(player.getLoc(), room1);
		
		player.go(0);
		assertSame(player.getLoc(), room2);
		
		player.go(0);
		assertSame(player.getLoc(), room2);
		
		player.go(1);
		assertSame(player.getLoc(), room1);
	}
	
	@Test
	public void testPickUpGive() {
		Player player = new Player();
		Item item = new Item();
		
		assertFalse(player.haveItem(item));
		
		player.pickUp(item);
		
		assertTrue(player.haveItem(item));
	}
	
	@Test
	public void testPickUpRoom() {
		Player player = new Player();
		Room room = new Room();
		Item item = new Item();
		
		assertFalse(player.haveItem(item));
		
		player.setLoc(room);
		player.pickUp(item);
		
		assertTrue(player.haveItem(item));
	}
	
	@Test
	public void testPickUpLimit() {
		Player player = new Player();
		Room room = new Room();
		Item item1 = new Item(), item2 = new Item(), item3 = new Item();
		
		player.setLoc(room);
		
		assertFalse(player.haveItem(item1));
		assertFalse(player.haveItem(item2));
		assertFalse(player.haveItem(item3));
		
		player.pickUp(item1);
		player.pickUp(item2);
		player.pickUp(item3);
		
		assertTrue(player.haveItem(item1));
		assertTrue(player.haveItem(item2));
		assertFalse(player.haveItem(item3));
	}

}
