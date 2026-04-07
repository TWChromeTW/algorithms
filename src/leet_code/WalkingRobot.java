//task number from leetcode 874

package leet_code;

import java.util.*;

class WalkingRobot {

    private String direction = "n";
    private int[] posRobot = {0, 0};
    private Set<String> map = new HashSet<>();
    private int maxSquare = 0;

    private void rotateDir(int val) {
        switch (direction) {
            case "n" -> {
                if (val == -2) direction = "w";
                else direction = "e";
            }
            case "w" -> {
                if (val == -2) direction = "s";
                else direction = "n";
            }
            case "s" -> {
                if (val == -2) direction = "e";
                else direction = "w";
            }
            case null, default -> {
                if (val == -2) direction = "n";
                else direction = "s";
            }
        }
    }

    private void walk(int val) {
        switch (direction) {
            case "n" -> {
                int target = posRobot[1] + val;
                while (posRobot[1] != target) {
                    posRobot[1] += 1;
                    String key = "x=" + posRobot[0] + ",y=" + posRobot[1];
                    if (map.contains(key)) {
                        posRobot[1] -= 1;
                        return;
                    }
                }
            }
            case "s" -> {
                int target = posRobot[1] - val;
                while (posRobot[1] != target) {
                    posRobot[1] -= 1;
                    String key = "x=" + posRobot[0] + ",y=" + posRobot[1];
                    if (map.contains(key)) {
                        posRobot[1] += 1;
                        return;
                    }
                }
            }
            case "w" -> {
                int target = posRobot[0] - val;
                while (posRobot[0] != target) {
                    posRobot[0] -= 1;
                    String key = "x=" + posRobot[0] + ",y=" + posRobot[1];
                    if (map.contains(key)) {
                        posRobot[0] += 1;
                        return;
                    }
                }
            }
            case "e" -> {
                int target = posRobot[0] + val;
                while (posRobot[0] != target) {
                    posRobot[0] += 1;
                    String key = "x=" + posRobot[0] + ",y=" + posRobot[1];
                    if (map.contains(key)) {
                        posRobot[0] -= 1;
                        return;
                    }
                }
            }
        }
    }

    private void buildMapWall(int[][] arr) {
        for (int[] point : arr) {
            map.add("x=" + point[0] + ",y=" + point[1]);
        }
    }

    private int calculate(int x, int y) {
        return x * x + y * y;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        buildMapWall(obstacles);

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1 || commands[i] == -2) {
                rotateDir(commands[i]);
            } else {
                walk(commands[i]);
                maxSquare = Math.max(maxSquare, calculate(posRobot[0], posRobot[1]));
            }
        }

        return maxSquare;
    }
}