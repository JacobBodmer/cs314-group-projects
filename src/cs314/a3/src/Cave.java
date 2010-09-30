package cs314.a3.src;


/**  Cave Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac CaveGame.java
     To run:     java CaveGame

     The main routine is CaveGame.main
                
**/

/**  Cave Game  Program Code
Copyright (c) 1999 James M. Bieman
Updated August 2010
- Code is put into package cs314.a2 to match current CS314 coding standards.

To compile: javac cs314.a2.CaveGame.java
To run:     java cs314.a2.CaveGame

The main routine is CaveGame.main
			    
			    **/

/** class Cave: Primary method, createCave, creates the cave system.
                Its hard-coded, and may eventually be replaced with
		a more flexible mechanism.

		Room descriptions are followed by a room identifier,
		to ease debugging and testing.  These would be removed
		to help confuse the user, which is our ultimate aim.

		I haven't added all of the room descriptions.  They
		will be done later.
		
		In this original version all I/O is through standard I/ -
		I/O is to and from the console. 

*/

public class Cave {

  private Room entrance;
  
  public Room createCave(){
    // The outside: 
      Room  outside = new Room();
      outside.setDesc(
        "You're outside, on the edge of a cliff;\n" +
	" the cave opens straight down (outside).");
   
   // Room 1:
      Room r1 = new Room();
      r1.setDesc(
	 "The darkness is pierced by a bright light overhead.\n"
	 + "There is a narrow, dark passage to the east (r1)." );

   // Connect the outside to Room 1:
      outside.setSide(5,r1);
      r1.setSide(4,outside);
      entrance = outside;

   // Room 2:
      Room r2 = new Room();
      r2.setDesc(
	"You are in a gloomy oval shaped room with grey walls.\n" + 
	 "There is a dim light to the west, and a narrow\n" +
	 "dark hole to the east only about 18 inches high (r2).");

  // Room 3:
     Room r3 = new Room();
     r3.setDesc("You really need your flashlight here. \n"+
		"There is a wide passage that quickly narrows\n"
		+"to the west, a bright opening to the east,\n"
		+ "and a deep hole that appears to have no bottom\n"
		+ "in the middle of the room (r3).");

  // Connect Rooms 1, 2, & 3:
     r1.setSide(2,r2);
     r2.setSide(3,r1);
     r2.setSide(2,r3);
     r3.setSide(3,r2);

  // Room 4:
     Room r4 = new Room();
     r4.setDesc("There is what looks like a giant grizzly bear\n"
		+ "skull in a corner.  A passage leads to the west,\n"
		+ "another one to the north, and a slippery route\n"
		+ "goes down steeply (r4).");

  // Room 5:
     Room r5 = new Room();
     r5.setDesc("Room r5.");

  // Room 6:
     Room r6 = new Room();
     r6.setDesc("Room r6.");

  // Room 7:
     Room r7 = new Room();
     r7.setDesc("Room r7.");

  // Connect rooms 3, 4, 5, 6, & 7.
     r3.setSide(2,r4);
     r3.setSide(5,r5);
     r4.setSide(3,r3);
     r4.setSide(5,r7);
     r5.setSide(4,r3);
     r5.setSide(2,r6);
     r6.setSide(3,r5);
     r7.setSide(4,r4);

  // Room 8:
     Room r8 = new Room();
     r8.setDesc("Room r8.");

  // Room 9:
     Room r9 = new Room();
     r9.setDesc("Room r9.");

  // Room 10:
     Room r10 = new Room();
     r10.setDesc("Room r10.");

 // Room 11:
    Room r11 = new Room();
    r11.setDesc("Room r11.");
    Treasure theTreasure = new Treasure();
    theTreasure.setDesc("A bag filled with gold bars.");
    r11.addItem(theTreasure);

 // Lets connect them:
    r4.setSide(0,r8);
    r8.setSide(1,r4);
    r8.setSide(3,r9);
    r8.setSide(2,r10);
    r9.setSide(2,r8);
    r10.setSide(3,r8);

 // Create a key and put it in r6:
    Key theKey = new Key();
    theKey.setDesc("A shiny gold key.");
    r6.addItem(theKey);

 // We add a door between r10 and r11: 
    Door theDoor = new Door(r10,r11,theKey);
    r10.setSide(5,theDoor);
    r11.setSide(4,theDoor);

 // Now return the entrance:
    entrance = outside;
    return entrance;

  }
}

