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
public class Object {
    String Name;
    String Description;
    int Location;
    boolean fixed;
    public Object(String myname, String mydescription, int mylocation, boolean isfixed){
        Name = myname;
        Description = mydescription;
        Location = mylocation;
        fixed = isfixed;
    }
}
