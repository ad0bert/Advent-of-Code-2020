package main.day03;

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
        List<List<String>> input = AoCFileReader.readListOfCharList(new File(this.inputFile1));
        System.out.println(calcTrees(input, 3, 1));
    }

    @Override
    public void solvePart2() {
        List<List<String>> input = AoCFileReader.readListOfCharList(new File(this.inputFile2));
        System.out.println(
                calcTrees(input, 1, 1) *
                calcTrees(input, 3, 1) *
                calcTrees(input, 5, 1) *
                calcTrees(input, 7, 1) *
                calcTrees(input, 1, 2)
        );
    }

    private long calcTrees(List<List<String>> input, int xOffset, int yOffset) {
        int xPos = 0;
        int yPos = 0;
        int treeCnt = 0;
        String tree = "#";
        while (yPos < input.size()) {
            if (input.get(yPos % input.size()).get(xPos % input.get(0).size()).equals(tree)) treeCnt++;
            xPos += xOffset;
            yPos += yOffset;
        }
        return treeCnt;
    }

}
