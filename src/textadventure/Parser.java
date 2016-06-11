/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.Arrays;

/**
 *
 * @author Andreas
 */
public class Parser {
    String[] Objects = { "key", "door", "north", "east", "west", "south"};
    String[] Commands = {"go", "open", "close", "inspect", "take", "drop", "use", "inventory", "quit"};  
    String[] Delete = {",",".","-",";","!","?"};
    String Command;
    String Object1;
    String Object2;
    public boolean parse_input(String input) {   
        int counterobjects = 0;
        boolean retval = false;
        input = input.toLowerCase();
        for (int i=0; i < Delete.length; i++) {
            input = input.replace(Delete[i],"");
        }
        Command = "";
        Object1 = "";
        Object2 = "";
        for (String thisword: input.split(" ")){
            if (Arrays.asList(Commands).contains(thisword)){
                retval = true;
                Command = thisword;
            }
            else if (Arrays.asList(Objects).contains(thisword)){                
                counterobjects++;
                retval = true;
                if (counterobjects==1){
                Object1 = thisword;
                }
                else if (counterobjects==2){
                Object2 = thisword;
                }
            }
        }   
        return retval;
    }
}




