package com.github.bgalek.advent.twentytwenty.day2;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level1 extends AdventOfCodeTask {

    private static final Pattern PATTERN = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

    public static void main(String[] args) {
        printResult(getInput("2.input")
                .stream()
                .map(Level1::parseInput)
                .filter(Level1::isValid)
                .count());
    }

    private static PasswordPolicy parseInput(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            return new PasswordPolicy(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), matcher.group(3), matcher.group(4));
        }
        throw new IllegalStateException("input lines should be in the same format! " + line);
    }

    private static boolean isValid(PasswordPolicy password) {
        int requiredCharsCount = password.raw.length() - password.raw().replaceAll(password.requiredChar, "").length();
        return requiredCharsCount >= password.min && requiredCharsCount <= password.max;
    }

    private static record PasswordPolicy(int min, int max, String requiredChar, String raw) {
    }
}