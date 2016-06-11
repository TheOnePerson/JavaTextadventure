/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

/**
 *
 * @author Andreas
 */
public class Room {
    int Roomnumber;
    int RoomNorth;
    int RoomEast;
    int RoomWest;
    int RoomSouth;
    String Description;
    public Room(int myroomnumber, int isroomnorth, int isroomeast, int isroomwest, int isroomsouth, String mydescription) {
        Roomnumber = myroomnumber;
        RoomNorth = isroomnorth;
        RoomEast = isroomeast;
        RoomWest = isroomwest;
        RoomSouth = isroomsouth;
        Description = mydescription;
    }
}
