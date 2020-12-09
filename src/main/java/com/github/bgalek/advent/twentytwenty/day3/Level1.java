package com.github.bgalek.advent.twentytwenty.day3;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1 extends AdventOfCodeTask {
    private static final String[][] inputAs2DArray = getInputAs2DArray("3.input");

    public static void main(String[] args) {
        printResult(countSlopes(3, 1));
    }

    static long countSlopes(int right, int down) {
        String[][] map = Arrays.stream(inputAs2DArray)
                .map(column -> {
                    List<String> strings = Arrays.asList(column);
                    ArrayList<String> arrayList = new ArrayList<>(strings);
                    for (int i = 0; i < strings.size() * column.length; i++) arrayList.addAll(strings);
                    return arrayList.toArray(String[]::new);
                }).toArray(String[][]::new);
        for (int i = 1; i < map.length; i++) markX(map, right * i, down * i);
        return Arrays.stream(map).flatMap(Arrays::stream).filter(it -> it.equals("X")).count();
    }

    private static void markX(String[][] map, int x, int y) {
        if (y > map.length || x > map[0].length) return;
        if (map[y][x].equals(".")) map[y][x] = "O";
        else map[y][x] = "X";
    }
}