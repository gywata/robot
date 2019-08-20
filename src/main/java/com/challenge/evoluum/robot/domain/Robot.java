package com.challenge.evoluum.robot.domain;

public class Robot {

    private static String ERROR = "400 Bad Request";

    private int axisX = 0;
    private int axisY = 0;
    private char direction = 'N';
    private boolean isAxisX = false;

    public Robot() {

    }

    private void changeDirection(char turn) {

        switch (direction) {
            case 'N':
                direction = turn == 'L' ? 'W' : 'E';
                isAxisX = true;
                break;
            case 'S':
                direction = turn == 'L' ? 'E' : 'W';
                isAxisX = true;
                break;
            case 'W':
                direction = turn == 'L' ? 'S' : 'N';
                isAxisX = false;
                break;
            case 'E':
                direction = turn == 'L' ? 'N' : 'S';
                isAxisX = false;
                break;
        }
    }

    public String move(String movement) {

        for (char c : movement.toCharArray()) {
            switch (c) {
                case 'M':
                    if (direction == 'N'|| direction == 'E') {
                        if (isAxisX) axisX++;
                        else axisY++;
                        if (axisX > 4 || axisY > 4) return ERROR;
                    } else {
                        if (isAxisX) axisX--;
                        else axisY--;
                        if (axisX < 0 || axisY < 0) return ERROR;
                    }
                    break;
                case 'L':
                    changeDirection('L');
                    break;
                case 'R':
                    changeDirection('R');
                    break;
                default:
                    return ERROR;
            }
        }

        return "(" + axisX + ", " + axisY + ", " + direction + ")";
    }

    @Override
    public String toString() {
        return "(" + axisX + ", " + axisY + ", " + direction + ")";
    }
}
