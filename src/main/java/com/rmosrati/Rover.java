package com.rmosrati;

public class Rover {
    private int x;
    private int y;
    private String direction;

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String navigate(String instruction) {
        for (char c : instruction.toCharArray()) {
            if ('R' == c) {
                turnRight();
            } else if ('L' == c) {
                turnLeft();
            } else if ('M' == c) {
                move();
            } else {
                throw new IllegalArgumentException(
                        "character (action) not authorized!");
            }
        }
        return x + " " + y + " " + this.direction;
    }

    private void move() {
        switch (this.direction) {
            case "N":
                this.y++;
                break;
            case "E":
                this.x++;
                break;
            case "S":
                this.y--;
                break;
            case "W":
                this.x--;
                break;
        }
    }

    private void turnLeft() {
        switch (this.direction) {
            case "N":
                this.direction = "W";
                break;
            case "W":
                this.direction = "S";
                break;
            case "S":
                this.direction = "E";
                break;
            default:
                this.direction = "N";
                break;
        }
    }

    private void turnRight() {
        switch (this.direction) {
            case "N":
                this.direction = "E";
                break;
            case "E":
                this.direction = "S";
                break;
            case "S":
                this.direction = "W";
                break;
            case "W":
                this.direction = "N";
                break;
        }
    }

}
