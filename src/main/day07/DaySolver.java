package main.day07;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.*;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    @Override
    public void solvePart1() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile1));
        Map<String, List<String>> bagRules = createBagRules(input);
        List<String> goldContainers = new ArrayList<>();
        int position = -1;
        do {
            String toCheck = position == -1 ? "shiny gold" : goldContainers.get(position);
            goldContainers.addAll(getAllThatContain(bagRules, toCheck));
            position++;
        } while (position < goldContainers.size());
        Set<String> noDuplicates = new HashSet<>(goldContainers);
        System.out.println(noDuplicates.size());
    }

    @Override
    public void solvePart2() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile2));
        Map<String, List<String>> bagRules = createBagRules(input);
        List<String> goldContainers = new ArrayList<>();
        int position = -1;
        do {
            String toCheck = position == -1 ? "shiny gold" : goldContainers.get(position);
            goldContainers.addAll(bagRules.get(toCheck));
            position++;
        } while (position < goldContainers.size());
        System.out.println(goldContainers.size());
    }

    private List<String> getAllThatContain(Map<String, List<String>> bagRules, String bag) {
        List<String> containers = new ArrayList<>();
        for (Map.Entry<String, List<String>> bagRule : bagRules.entrySet()) {
            if (bagRule.getValue().contains(bag)) {
                containers.add(bagRule.getKey());
            }
        }
        return containers;
    }

    private Map<String, List<String>> createBagRules(List<String> input) {
        Map<String, List<String>> bagRules = new HashMap<>();
        for (String rule : input) {
            String[] keyValues = rule.split(" contain ");
            String key = keyValues[0].replace(" bags ", "");
            String[] values = keyValues[1]
                    .replace(".", "")
                    .replace(" bags", "")
                    .replace(" bag", "")
                    .split(", ");
            List<String> bags = new ArrayList<>();
            if (!values[0].equals("no other")) {
                for (String value : values) {
                    String[] cntValue = value.split(" ", 2);
                    for (int i = 0; i < Integer.parseInt(cntValue[0]); i++) {
                        bags.add(cntValue[1]);
                    }
                }
            }
            bagRules.putIfAbsent(key.replace(" bags", ""), bags);
        }
        return bagRules;
    }

}
