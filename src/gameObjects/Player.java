package gameObjects;

import util.Lib;

import java.util.Arrays;

public class Player {
    private Lib.Orientation direction;
    private Table playBoard;
    private short[] playerPos = new short[2];

    private boolean isOnBoard;

    public Player(short xPos, short yPos, Table t) {
        playerPos[0] = xPos;
        playerPos[1] = yPos;

        this.direction = Lib.Orientation.NORTH;
        this.playBoard = t;

        // Check if starting pos a possible
        if (playBoard.isMovePossible(playerPos)) isOnBoard = true;
        else{
            playerPos[0] = -1;
            playerPos[1] = -1;
            isOnBoard = false;
        }

    }

    /**
     * Moves player forward or backwards depending on direction
     *
     * Formula for counting how to move:
     * N = North, S = South, W = West, E = East
     * F = Forward, B = Backward
     *
     * N: F = yPos - 1, B = yPos + 1
     * S: F = yPos + 1, B = yPos - 1
     * W: F = xPos - 1, B = xPos + 1
     * E: F = xPos + 1, B = xPos - 1
     *
     * @param m, if forward or backward
     */
    public void move(Lib.Move m){
        if (!isOnBoard) return; // No need to move the player if player has fallen off

        switch (direction){
            case NORTH:
                if (m == Lib.Move.FORWARD)
                    playerPos[1] -= 1;
                else
                    playerPos[1] += 1;
                break;
            case SOUTH:
                if (m == Lib.Move.FORWARD)
                    playerPos[1] += 1;
                else
                    playerPos[1] -= 1;
                break;
            case WEST:
                if (m == Lib.Move.FORWARD)
                    playerPos[0] -= 1;
                else
                    playerPos[0] += 1;
                break;
            case EAST:
                if (m == Lib.Move.FORWARD)
                    playerPos[0] += 1;
                else
                    playerPos[0] -= 1;
                break;
        }

        if (!playBoard.isMovePossible(playerPos)){
            playerPos[0] = -1;
            playerPos[1] = -1;
            isOnBoard = false;
        }
    }

    /**
     * Change direction of player
     * @param rot
     */
    public void turn(Lib.Rotation rot){
        switch (direction){
            case NORTH:
                if (rot == Lib.Rotation.RIGHT)
                    direction = Lib.Orientation.EAST;
                else
                    direction = Lib.Orientation.WEST;

                break;
            case SOUTH:
                if (rot == Lib.Rotation.RIGHT)
                    direction = Lib.Orientation.WEST;
                else
                    direction = Lib.Orientation.EAST;

                break;
            case WEST:
                if (rot == Lib.Rotation.RIGHT)
                    direction = Lib.Orientation.NORTH;
                else
                    direction = Lib.Orientation.SOUTH;
                break;
            case EAST:
                if (rot == Lib.Rotation.RIGHT)
                    direction = Lib.Orientation.SOUTH;
                else
                    direction = Lib.Orientation.NORTH;
                break;
        }
    }

    public Lib.Orientation getDirection(){
        return direction;
    }

    /**
     * Gets a string if player is still in the game or not
     * @return
     */
    public String getOnBoardStatus(){
        if(isOnBoard){
            return "Player is still in the game";
        } else {
            return "Player has fallen off";
        }
    }

    public String getPosition(){
        return Arrays.toString(playerPos);
    }

}
