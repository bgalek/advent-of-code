package com.github.bgalek.advent.twentytwenty.day3;

import com.github.bgalek.utils.AdventOfCodeTask;

public class Level2 extends AdventOfCodeTask {

    private static final String[][] inputAs2DArray = getInputAs2DArray("3.input");

    public static void main(String[] args) {
        printResult(
                Level1.countSlopes(1, 1) *
                Level1.countSlopes(3, 1) *
                Level1.countSlopes(5, 1) *
                Level1.countSlopes(7, 1) *
                Level1.countSlopes(1, 2)
        );
    }
}