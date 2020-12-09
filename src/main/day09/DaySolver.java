package main.day09;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.List;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    private final int STEP_WIDTH = 25;
    private long RES_PART1 = 0;

    @Override
    public void solvePart1() {
        List<Long> input = AoCFileReader.readLongLineByLine(new File(this.inputFile1));
        for (int i = STEP_WIDTH; i < input.size(); i++) {
            if (!checkIfOk(input.subList(i - STEP_WIDTH, i), input.get(i))) {
                RES_PART1 = input.get(i);
                break;
            }
        }
        System.out.println(RES_PART1);
    }

    @Override
    public void solvePart2() {
        List<Long> input = AoCFileReader.readLongLineByLine(new File(this.inputFile2));
        long res = 0;
        boolean stop = false;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                List<Long> sub = input.subList(i, j);
                int sum = sub.stream().mapToInt(Long::intValue).sum();
                if (sum == RES_PART1) {
                    sub.sort(Long::compareTo);
                    res = sub.get(0) + sub.get(sub.size() - 1);
                    stop = true;
                    break;
                }
                if (sum > RES_PART1) break;
            }
            if (stop) break;
        }
        System.out.println(res);
    }

    private boolean checkIfOk(List<Long> toCheck, Long nrToCheck) {
        for (int i = 0; i < toCheck.size(); i++) {
            for (int j = 0; j < toCheck.size(); j++) {
                if (i == j) continue;
                if (nrToCheck.equals(toCheck.get(i) + toCheck.get(j))) return true;
            }
        }
        return false;
    }

}
