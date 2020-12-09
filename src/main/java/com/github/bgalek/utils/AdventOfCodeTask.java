package com.github.bgalek.utils;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class AdventOfCodeTask {
    protected static List<String> getInput(String inputFileName) {
        try {
            URL resource = AdventOfCodeTask.class.getClassLoader().getResource(inputFileName);
            return Files.readAllLines(Paths.get(Objects.requireNonNull(resource).toURI()));
        } catch (Exception e) {
            throw new RuntimeException("could not load input file");
        }
    }

    protected static String[][] getInputAs2DArray(String inputFileName) {
        List<String> lines = getInput(inputFileName);
        int columns = lines.get(0).length();
        int rows = lines.size();
        String[][] map = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = String.valueOf(lines.get(i).charAt(j));
            }
        }
        return map;
    }

    public static void printResult(Object result) {
        System.out.println(result.toString());
    }

    public static boolean isBetween(String input, int min, int max) {
        int i = Integer.parseInt(input);
        return i >= min && i <= max;
    }
}
