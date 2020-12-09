package com.github.bgalek.advent.twentytwenty.day1;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 extends AdventOfCodeTask {

    private static final int TARGET = 2020;

    public static void main(String[] args) {
        List<Integer> lines = getInput("1.input").stream().map(Integer::parseInt).collect(Collectors.toList());
        printResult(find3ProductsOfTarget(lines));
    }

    private static int find3ProductsOfTarget(List<Integer> lines) {
        for (Integer line : lines) {
            for (Integer line2 : lines) {
                for (Integer line3 : lines) {
                    if (TARGET - line - line2 - line3 == 0) {
                        return (line * line2 * line3);
                    }
                }
            }
        }
        throw new IllegalStateException("there should be at least one right answer!");
    }
}