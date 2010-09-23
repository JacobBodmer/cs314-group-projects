package cs314.a2;

/**  Cave Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac CaveGame.java
     To run:     java CaveGame

     The main routine is CaveGame.main
				    
**/


// class Item

public class Item {

  private String description;

  public void setDesc(String d){
      description = d;
  }

  public String getDesc(){
	     return description;
  }

}

