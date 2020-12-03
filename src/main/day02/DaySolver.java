package main.day02;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.List;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    @Override
    public void solvePart1() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile1));
        int cnt = 0;
        for (String line : input) {
            String[] toParse = line.split(" ");
            String[] boundary = toParse[0].split("-");
            char key = toParse[1].substring(0, 1).charAt(0);
            String toCheck = toParse[2];
            int lowerBound = Integer.parseInt(boundary[0]);
            int upperBound = Integer.parseInt(boundary[1]);
            long keyCount = toCheck.chars().filter(value -> value == key).count();
            if (keyCount >= lowerBound && keyCount <= upperBound) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    @Override
    public void solvePart2() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile2));
        int cnt = 0;
        for (String line : input) {
            String[] toParse = line.split(" ");
            String[] boundary = toParse[0].split("-");
            char key = toParse[1].substring(0, 1).charAt(0);
            String toCheck = toParse[2];
            int lowerKey = Integer.parseInt(boundary[0]);
            int upperKey = Integer.parseInt(boundary[1]);
            if ((key == toCheck.charAt(lowerKey - 1) && key != toCheck.charAt(upperKey - 1))
             || (key == toCheck.charAt(upperKey - 1) && key != toCheck.charAt(lowerKey - 1))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
