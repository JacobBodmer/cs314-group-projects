/**
CaveConfigurations.java
TODO: description of file
Author: M. Bostwick, Sep 26, 2010
 */
package cs314.a2;


/**
 * @author myles
 *
 */
public class Caves {
	public static CaveSite EmptyCave() {
		return new Room();
	}
	
	public static CaveSite TwoRoomCave() {
		Room room1 = new Room();
		Room room2 = new Room();
		
		room1.setSide(2, room2);
		room2.setSide(3, room1);
		
		return room1;
	}
	
	public static CaveSite TwoRoomCaveWithDoorAndKey() {
		Room room1 = new Room();
		Room room2 = new Room();
		Key key = new Key();
		
		room1.setSide(2, new Door(room1, room2, key));
		room1.addItem(key);
		room2.setSide(3, new Door(room2, room1, key));
		
		return room1;
	}
	
	public static CaveSite ThreeRoomCave() {
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		
		room1.setSide(2, room2);
		room2.setSide(3, room1);
		room2.setSide(2, room3);
		room3.setSide(3, room2);
		room3.setSide(2, room1);
		
		return room1;
	}
	
	public static CaveSite ThreeRoomCaveWithKey() {
		Room cave = (Room)Caves.ThreeRoomCave();
		cave.addItem(new Key());
		return cave;
	}
	
	public static CaveSite InvalidRoom() {
		Room room1 = new Room();
		room1.setSide(0, null);
		room1.setSide(1, null);
		room1.setSide(2, null);
		room1.setSide(3, null);
		room1.setSide(4, null);
		room1.setSide(5, null);
		
		return room1;
	}
	
	public static CaveSite RoomWithInvalidDoor() {
		Room room1 = new Room();
		Key key = new Key();
		room1.addItem(key);
		room1.setSide(2, new Door(null, room1, key));
		return room1;
	}
}
