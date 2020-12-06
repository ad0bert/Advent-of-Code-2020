package main.day06;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    @Override
    public void solvePart1() {
        List<String> input = AoCFileReader.readCustomDeclarationForms(new File(this.inputFile1));
        List<Set<Character>> res = new ArrayList<>();
        for (String in : input) {
            Set<Character> uniqueInput = new HashSet<>();
            for (char c : in.replaceAll(" ", "").toCharArray()) {
                uniqueInput.add(c);
            }
            res.add(uniqueInput);
        }
        System.out.println(res.stream().mapToInt(Set::size).sum());
    }

    @Override
    public void solvePart2() {
        List<String> input = AoCFileReader.readCustomDeclarationForms(new File(this.inputFile2));
        List<Set<Character>> res = new ArrayList<>();
        for (String in : input) {
            Set<Character> allYes = new HashSet<>();
            String[] persons = in.split(" ");
            for (char c : persons[0].toCharArray()) {
                allYes.add(c);
            }
            for (int i = 1; i < persons.length; i++) {
                List<Character> toRemove = new ArrayList<>();
                for (Character toCheck : allYes) {
                    if (!persons[i].contains(toCheck.toString())) {
                        toRemove.add(toCheck);
                    }
                }
                allYes.removeAll(toRemove);
            }
            res.add(allYes);
        }
        System.out.println(res.stream().mapToInt(Set::size).sum());
    }

}
