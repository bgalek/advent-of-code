package com.github.bgalek.advent.twentytwenty.day1;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.List;
import java.util.stream.Collectors;

public class Level1 extends AdventOfCodeTask {

    private static final int TARGET = 2020;

    public static void main(String[] args) {
        List<Integer> lines = getInput("1.input").stream().map(Integer::parseInt).collect(Collectors.toList());
        printResult(find2ProductsOfTarget(lines));
    }

    private static int find2ProductsOfTarget(List<Integer> lines) {
        for (Integer line : lines) {
            for (Integer line2 : lines) {
                if (TARGET - line - line2 == 0) {
                    return (line * line2);
                }
            }
        }
        throw new IllegalStateException("there should be at least one right answer!");
    }
}