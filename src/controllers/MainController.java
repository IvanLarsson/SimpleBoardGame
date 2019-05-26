package controllers;

import util.Lib;
import gameObjects.Player;
import gameObjects.Table;

import java.util.Scanner;

import static util.ConsolePrints.printCommands;
import static util.ConsolePrints.printCurrentInfo;

public class MainController {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Table playBoard;
    
    public MainController() {
        initialize();
        run();

    }

    public void run(){
        boolean run = true;

        System.out.println("******************************** Start Info ********************************");
        printCurrentInfo(player, playBoard);
        printCommands();
        System.out.println("Enter command:");

        while (true){
            if (!run){
                scanner.close();
                System.out.println("********************************** End Results **********************************");
                printCurrentInfo(player, playBoard);
                break;
            }

            byte cmd = scanner.nextByte();

            switch (cmd) {
                case 0:
                   run = false;
                    break;
                case 1:
                    player.move(Lib.Move.FORWARD);
                    break;
                case 2:
                    player.move(Lib.Move.BACKWARD);
                    break;
                case 3:
                    player.turn(Lib.Rotation.RIGHT);
                    break;
                case 4:
                    player.turn(Lib.Rotation.LEFT);
                    break;
                case 5:
                    printCurrentInfo(player, playBoard);
                    break;
                case 6:
                    printCommands();
                    break;
                default:
                    System.out.println("Bad command, try again");
                    break;
            }
        }
    }

    public void initialize(){
        System.out.println("Enter width, height, X position, y position ");
        short tableWidth = scanner.nextShort();
        short tableHeight = scanner.nextShort();
        short xPos = scanner.nextShort();
        short yPos = scanner.nextShort();

        playBoard = new Table(tableHeight, tableWidth);
        player = new Player(xPos, yPos, playBoard);

    }
}
