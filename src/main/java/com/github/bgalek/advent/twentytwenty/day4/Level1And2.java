package com.github.bgalek.advent.twentytwenty.day4;

import com.github.bgalek.utils.AdventOfCodeTask;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Level1And2 extends AdventOfCodeTask {

    private static final List<String> INPUT = getInput("4.input");
    private static final List<Integer> EMPTY_LINES_INDICES = Stream.concat(Stream.of(0), IntStream.range(0, INPUT.size())
            .filter(i -> INPUT.get(i).equals(""))
            .boxed())
            .collect(Collectors.toList());

    public static void main(String[] args) {
        printResult(IntStream.range(0, EMPTY_LINES_INDICES.size())
                .boxed()
                .map(Level1And2::getPassport)
                .filter(Level1And2::isValid)
                .count()
        );
    }

    private static boolean isValid(Map<String, String> passport) {
        if (!passport.containsKey("byr")) return false;
        if (!passport.get("byr").matches("\\d{4}") || !isBetween(passport.get("byr"), 1920, 2002)) return false;

        if (!passport.containsKey("iyr")) return false;
        if (!passport.get("iyr").matches("\\d{4}") || !isBetween(passport.get("iyr"), 2010, 2020)) return false;

        if (!passport.containsKey("eyr")) return false;
        if (!passport.get("eyr").matches("\\d{4}") || !isBetween(passport.get("eyr"), 2020, 2030)) return false;

        if (!passport.containsKey("hgt")) return false;

        if (!passport.get("hgt").endsWith("cm") && !passport.get("hgt").endsWith("in")) return false;
        if (passport.get("hgt").endsWith("cm") && !isBetween(passport.get("hgt").substring(0, passport.get("hgt").length() - 2), 150, 193))
            return false;
        if (passport.get("hgt").endsWith("in") && !isBetween(passport.get("hgt").substring(0, passport.get("hgt").length() - 2), 59, 76))
            return false;

        if (!passport.containsKey("hcl")) return false;
        if (!passport.get("hcl").matches("#[a-z0-9]{6}")) return false;

        if (!passport.containsKey("ecl")) return false;
        if (!List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(passport.get("ecl"))) return false;

        if (!passport.containsKey("pid")) return false;
        if (!passport.get("pid").matches("\\d{9}")) return false;

        if (!passport.containsKey("cid") && passport.keySet().size() != 7) return false;
        return true;
    }

    private static Map<String, String> getPassport(int index) {
        int fromIndex = EMPTY_LINES_INDICES.get(index);
        int toIndex = EMPTY_LINES_INDICES.size() - 1 == index ? INPUT.size() : EMPTY_LINES_INDICES.get(index + 1);
        return INPUT.subList(fromIndex, toIndex)
                .stream()
                .filter(s -> !s.isBlank())
                .reduce((s1, str) -> s1.concat(" " + str))
                .stream()
                .flatMap(it -> Arrays.stream(it.split(" ")))
                .map(it -> it.split(":"))
                .collect(Collectors.toMap(it -> it[0], it -> it[1]));
    }
}