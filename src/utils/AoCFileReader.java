package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AoCFileReader {
    public static List<Integer> readIntegerLineByLine(File f) {
        List<Integer> res = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Integer> readIntegerLine(File f) {
        List<Integer> res = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String[] line = br.readLine().split(",");
            for (String i : line) {
                res.add(Integer.parseInt(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Long> readLongLine(File f) {
        List<Long> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String[] line = br.readLine().split(",");
            for (String i : line) {
                res.add(Long.parseLong(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<List<String>> readListOfCharList(File f) {
        List<List<String>> res = new ArrayList<List<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> charLine = new ArrayList<String>();
                for (char c : line.toCharArray()) {
                    charLine.add(String.valueOf(c));
                }
                res.add(charLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readOneLine(File f) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            line = br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static List<String> readMulitpleLines(File f) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static Map<String, Character> readStringMap(File f) {
        Map<String, Character> res = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.put(line.split(" => ")[0], line.split(" => ")[1].charAt(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static List<int[]> readProgram(File f) {
        List<int[]> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                int[] pLine = new int[split.length];
                for (int i = 0; i < split.length; ++i) {
                    pLine[i] = Integer.parseInt(split[i]);
                }
                res.add(pLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<String> readPassports(File f) {
        List<String> passports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = "";
            String passport = "";
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    passports.add(passport);
                    passport = "";
                    continue;
                } else if (passport.isEmpty()){
                    passport = line;
                } else {
                    passport += " " + line;
                }
            }
            passports.add(passport);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passports;
    }

}
