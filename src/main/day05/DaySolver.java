package main.day05;

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
        int maxId = Integer.MIN_VALUE;
        for (String boardingPass : input) {
            int row = Integer.parseInt(boardingPass.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1"), 2);
            int col = Integer.parseInt(boardingPass.substring(7).replaceAll("L", "0").replaceAll("R", "1"), 2);
            int seatId = row * 8 + col;
            if (seatId > maxId) {
                maxId = seatId;
            }
        }
        System.out.println(maxId);
    }

    @Override
    public void solvePart2() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile2));
        Map<Integer, List<Integer>> seatMap = new HashMap<>();
        for (String boardingPass : input) {
            int row = Integer.parseInt(boardingPass.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1"), 2);
            int col = Integer.parseInt(boardingPass.substring(7).replaceAll("L", "0").replaceAll("R", "1"), 2);
            seatMap.putIfAbsent(row, new ArrayList<>());
            seatMap.get(row).add(row * 8 + col);
        }
        for (Map.Entry<Integer, List<Integer>> row : seatMap.entrySet()) {
            if (row.getValue().size() < 8) {
                Collections.sort(row.getValue());
                int currSeatId = row.getValue().get(0);
                for (int i = 1; i < row.getValue().size()-1; i++) {
                    if (currSeatId+1 != row.getValue().get(i)){
                        System.out.println(currSeatId+1);
                        break;
                    }
                    currSeatId++;
                }
            }
        }
    }

}
