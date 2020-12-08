package main.day08;

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
        System.out.println(runProgram(input).getValue());
    }

    @Override
    public void solvePart2() {
        List<String> input = AoCFileReader.readMulitpleLines(new File(this.inputFile2));
        int res = 0;
        for (int i = 0; i < input.size(); i++) {
            Map.Entry<Boolean, Integer> progRes = null;
            if (input.get(i).contains("jmp")) {
                progRes = swapAndCheck(input, i, "jmp", "nop");
            } else if (input.get(i).contains("nop")) {
                progRes = swapAndCheck(input, i, "nop", "jmp");
            }
            if (progRes != null && progRes.getKey()) {
                res = progRes.getValue();
                break;
            }
        }
        System.out.println(res);
    }

    private Map.Entry<Boolean, Integer> runProgram(List<String> input) {
        Set<Integer> visited = new HashSet<>();
        int pos = 0;
        int acc = 0;
        while (visited.add(pos) && pos != input.size()) {
            String[] keyValue = input.get(pos).split(" ");
            if (keyValue[0].equals("jmp")) {
                pos += Integer.parseInt(keyValue[1]);
            } else if (keyValue[0].equals("nop")) {
                pos++;
            } else if (keyValue[0].equals("acc")) {
                acc += Integer.parseInt(keyValue[1]);
                pos++;
            }
        }
        return new AbstractMap.SimpleEntry<>(pos == input.size(), acc);
    }

    private Map.Entry<Boolean, Integer> swapAndCheck(
            List<String> input,
            int pos,
            String toReplace,
            String replacement
    ) {
        input.set(pos, input.get(pos).replace(toReplace, replacement));
        Map.Entry<Boolean, Integer> progRes = runProgram(input);
        input.set(pos, input.get(pos).replace(replacement, toReplace));
        return progRes;
    }

}
