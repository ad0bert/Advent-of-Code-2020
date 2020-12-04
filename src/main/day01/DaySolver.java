package main.day01;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.List;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    private static int SUM_TO_CHECK = 2020;

    @Override
    public void solvePart1() {
        List<Integer> input = AoCFileReader.readIntegerLineByLine(new File(this.inputFile1));
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if (input.get(i) + input.get(j) == SUM_TO_CHECK) {
                    System.out.println(input.get(i)*input.get(j));
                    return;
                }
            }
        }
    }

    @Override
    public void solvePart2() {
        List<Integer> input = AoCFileReader.readIntegerLineByLine(new File(this.inputFile2));
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                for (int k = 0; k < input.size(); k++) {
                    if (input.get(i) + input.get(j) + input.get(k) == SUM_TO_CHECK) {
                        System.out.println(input.get(i)*input.get(j)*input.get(k));
                        return;
                    }
                }
            }
        }
    }

}
