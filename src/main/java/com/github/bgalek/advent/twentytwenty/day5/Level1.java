package com.github.bgalek.advent.twentytwenty.day5;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 extends AdventOfCodeTask {


    public static void main(String[] args) {
        List<Integer> boardingPasses = getInput("5.input")
                .stream()
                .map(line -> line.chars()
                        .mapToObj(i -> (char) i)
                        .map(character -> List.of('B', 'R').contains(character) ? "1" : "0")
                        .collect(Collectors.joining("")))
                .mapToInt(value -> Integer.parseInt(value, 2))
                .boxed()
                .sorted(Comparator.comparingInt(value -> value))
                .collect(Collectors.toList());
        printResult(boardingPasses.get(boardingPasses.size() - 1));
    }
}