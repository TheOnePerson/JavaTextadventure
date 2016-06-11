/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class Textadventure {
    Parser parser; 
    Object[] AllObjects;
    Room[] AllRooms;

    public static void main (String[] args)
{
    Textadventure obj = new Textadventure ();
    obj.run (args);
}
    
    /**
     * @param args
     */
    public void  run(String[] args) {
        System.out.println("Welcome to a generic text adventure!");
        this.InitRooms();
        this.InitObjects();
        this.ProgramLoop();
    }   
    private void InitRooms() {
        AllRooms = new Room[2];
        AllRooms[0] = new Room(1,1,-1,-1,-1,"Das ist ein Raum");
        AllRooms[1] = new Room(2,-1,-1,-1,0,"Das ist auch ein Raum");        
    }
    private void InitObjects() {
        AllObjects = new Object[6];
        AllObjects[4] = new Object("key", "This is a key.", 2, false);
        AllObjects[5] = new Object("door", "This is a door.", 1, true);
        AllObjects[0] = new Object("north", "", 0, true);
        AllObjects[1] = new Object("east", "", 0, true);
        AllObjects[2] = new Object("south", "", 0, true);
        AllObjects[3] = new Object("west", "", 0, true);
    }
    private void ProgramLoop() {
        parser = new Parser();
        int roomnumber = 0;
        int Status = 2;
        boolean newinroom = true;
        while (Status == 2) {
            if (newinroom) {
                System.out.println();
                System.out.println(AllRooms[roomnumber].Description);
                System.out.println();
                newinroom = false;
            }
            Scanner inputReader = new Scanner(System.in);
            if (parser.parse_input(inputReader.nextLine())) {
                switch (parser.Command) {
                    case "go":
                        int newroomnumber = -1;
                        switch (parser.Object1) {
                            case "north":
                                newroomnumber = AllRooms[roomnumber].RoomNorth;
                                break;
                            case "south":
                                newroomnumber = AllRooms[roomnumber].RoomSouth;
                                break;
                            case "east":
                                newroomnumber = AllRooms[roomnumber].RoomEast;
                                break;
                            case "west":
                                newroomnumber = AllRooms[roomnumber].RoomWest;
                        }
                        if ( newroomnumber>=0) {
                            roomnumber = newroomnumber;
                            System.out.println("You leave the room");
                            newinroom = true;
                        }
                        else {
                           System.out.println("You run into a wall"); 
                        }                    
                        break;
                    case "quit":
                        Status = 0;
                }
            }
            else {
                System.out.println("Invalid Input");
            }
        }
        switch (Status){
            case 0:
                System.out.println("Bye");
        }                   
        
    }
}
