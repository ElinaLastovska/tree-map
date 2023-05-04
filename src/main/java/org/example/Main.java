package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    private static final Path path = Paths.get("src/main/java/map.txt");

    public static void main(String[] args) throws IOException {

        int visibleTrees = 0;
        int[][] myArray = getArray();

        for (int row = 0; row < myArray.length; row++) {
            for (int col = 0; col < myArray.length; col++) {
                if (isSeenFromLeftSide(myArray, row, col) || isSeenFromRightSide(myArray, row, col)
                        || isSeenFromUp(myArray, row, col) || isSeenFromDown(myArray, row, col)) {
                    visibleTrees++;
                }
            }
        }

        System.out.println("You can see " + visibleTrees + " trees");
    }

    public static int[][] getArray() throws IOException {
        List<String> lines = Files.readAllLines(path);
        int[][] myArray = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String[] elements = lines.get(i).split("(?<=.)");
            myArray[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                myArray[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return myArray;
    }

    private static boolean isSeenFromLeftSide(int[][] myArray, int row, int col) {
        return isVisibleHorizontally(myArray, row, col, 0, col);
    }

    private static boolean isSeenFromRightSide(int[][] myArray, int row, int col) {
        return isVisibleHorizontally(myArray, row, col, col + 1, myArray.length);
    }

    private static boolean isSeenFromUp(int[][] myArray, int row, int col) {
        return isVisibleVertically(myArray, row, col, 0, row);
    }

    private static boolean isSeenFromDown(int[][] myArray, int row, int col) {
        return isVisibleVertically(myArray, row, col, row + 1, myArray.length);
    }

    private static boolean isVisibleVertically(int[][] myArray, int row, int col, int from, int to) {
        for (int i = from; i < to; i++) {
            if (myArray[i][col] >= myArray[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleHorizontally(int[][] myArray, int row, int col, int from, int to) {
        for (int i = from; i < to; i++) {
            if (myArray[row][i] >= myArray[row][col]) {
                return false;
            }
        }
        return true;
    }

}