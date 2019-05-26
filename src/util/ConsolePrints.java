package util;

import gameObjects.Player;
import gameObjects.Table;

/***
 * Simple class for Console prints
 *
 */
public class ConsolePrints {

    /**
     * Prints current game status
     *
     * @param player
     * @param playBoard
     */
    public static void printCurrentInfo(Player player, Table playBoard){
        System.out.println("    Playboard dimension: " + playBoard.getDimension());
        System.out.println("    Players current position:  " + player.getPosition());
        System.out.println("    " + player.getOnBoardStatus());
        System.out.println("    Players current direction:  " + player.getDirection());
    }

    public static void printCommands(){
        System.out.println("********************************** Commands **********************************");
        System.out.println("    0: Quits simulation and prints results");
        System.out.println("    1: Move forward one step");
        System.out.println("    2: Move backwards one step");
        System.out.println("    3: Turn right");
        System.out.println("    4: Turn left");
        System.out.println("    5: Get current info");
        System.out.println("    6: Print commands");
        System.out.println("******************************************************************************");
    }
}
