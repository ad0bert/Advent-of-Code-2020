package main.day10;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    @Override
    public void solvePart1() {
        List<Integer> input = AoCFileReader.readIntegerLineByLine(new File(this.inputFile1));
        input.add(0);
        Collections.sort(input);
        input.add(input.get(input.size()-1) + 3);
        int oneCnt = 0;
        int threeCnt = 0;
        for (int i = 0; i < input.size()-1; i++) {
            int diff = input.get(i+1) - input.get(i);
            if (diff == 1) {
                oneCnt++;
            }
            if (diff == 3) {
                threeCnt++;
            }
        }
        System.out.println(oneCnt*threeCnt);
    }

    @Override
    public void solvePart2() {
        List<Integer> input = AoCFileReader.readIntegerLineByLine(new File(this.inputFile2));
        input.add(0);
        Collections.sort(input);
        input.add(input.get(input.size()-1) + 3);
        int j = 0;
        long sum = 1;
        List<Long> res = new ArrayList<>();
        res.add(1L);
        for (int i = 1; i < input.size()-1; i++) {
            while (input.get(i) - input.get(j) > 3) {
                sum -= res.get(j);
                ++j;
            }
            res.add(sum);
            sum += res.get(i);
        }
        System.out.println(res.get(res.size()-1));
    }

}
