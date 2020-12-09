package com.github.bgalek.advent.twentytwenty.day2;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level2 extends AdventOfCodeTask {

    private static final Pattern PATTERN = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

    public static void main(String[] args) {
        printResult(getInput("2.input")
                .stream()
                .map(Level2::parseInput)
                .filter(Level2::isValid)
                .count());
    }

    private static PasswordPolicy parseInput(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            return new PasswordPolicy(Integer.parseInt(matcher.group(1)) - 1, Integer.parseInt(matcher.group(2)) - 1, matcher.group(3), matcher.group(4));
        }
        throw new IllegalStateException("input lines should be in the same format! " + line);
    }

    private static boolean isValid(PasswordPolicy password) {
        return password.raw.charAt(password.position1) == password.requiredChar.charAt(0) ^ password.raw.charAt(password.position2) == password.requiredChar.charAt(0);
    }

    private static record PasswordPolicy(int position1, int position2, String requiredChar, String raw) {
    }
}