package main.day04;

import main.AbstractSolver;
import utils.AoCFileReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DaySolver extends AbstractSolver {

    public DaySolver(String day) {
        super(day);
    }

    @Override
    public void solvePart1() {
        List<String> passports = AoCFileReader.readPassports(new File(this.inputFile1));
        int validCnt = 0;
        for (String passport : passports) {
            Passport passportClass = new Passport(passport);
            if (passportClass.isValidPassport()) {
                validCnt++;
            }
        }
        System.out.println(validCnt);
    }

    @Override
    public void solvePart2() {
        List<String> passports = AoCFileReader.readPassports(new File(this.inputFile2));
        int validCnt = 0;
        for (String passport : passports) {
            Passport passportClass = new Passport(passport);
            if (passportClass.isValidPassport2()) {
                validCnt++;
            }
        }
        System.out.println(validCnt);
    }

    private class Passport {
        private String byr = null;
        private String iyr = null;
        private String eyr = null;
        private String hgt = null;
        private String hcl = null;
        private String ecl = null;
        private String pid = null;
        private String cid = null;
        private static final String HEX_COLOR_PATTERN
                = "^#([a-fA-F0-9]{6})$";

        private final Pattern pattern = Pattern.compile(HEX_COLOR_PATTERN);

        Passport(String passportString) {
            String[] parts = passportString.split(" ");
            for (String part : parts) {
                String[] keyValue = part.split(":");
                if (keyValue[0].equals("byr")) {
                    this.byr = keyValue[1];
                } else if (keyValue[0].equals("iyr")) {
                    this.iyr = keyValue[1];
                } else if (keyValue[0].equals("eyr")) {
                    this.eyr = keyValue[1];
                } else if (keyValue[0].equals("hgt")) {
                    this.hgt = keyValue[1];
                } else if (keyValue[0].equals("hcl")) {
                    this.hcl = keyValue[1];
                } else if (keyValue[0].equals("ecl")) {
                    this.ecl = keyValue[1];
                } else if (keyValue[0].equals("pid")) {
                    this.pid = keyValue[1];
                } else if (keyValue[0].equals("cid")) {
                    this.cid = keyValue[1];
                } else {
                    System.out.println(passportString);
                    throw new RuntimeException();
                }
            }
        }

        boolean isValidPassport() {
            return
                    this.byr != null &&
                            this.iyr != null &&
                            this.eyr != null &&
                            this.hgt != null &&
                            this.hcl != null &&
                            this.ecl != null &&
                            this.pid != null;
        }

        boolean isValidPassport2() {
            return isValidPassport() &&
                    isByrValid() &&
                    isIyrValid() &&
                    isEyrValid() &&
                    isHgtValid() &&
                    isHclValid() &&
                    isEclValid() &&
                    isPidValid();
        }

        boolean isByrValid() {
            try {
                int value = Integer.parseInt(this.byr);
                if (value >= 1920 && value <= 2002) {
                    return true;
                }
            } catch (Exception ex) {
            }
            return false;
        }

        boolean isIyrValid() {
            try {
                int value = Integer.parseInt(this.iyr);
                if (value >= 2010 && value <= 2020) {
                    return true;
                }
            } catch (Exception ex) {
            }
            return false;
        }

        boolean isEyrValid() {
            try {
                int value = Integer.parseInt(this.eyr);
                if (value >= 2020 && value <= 2030) {
                    return true;
                }
            } catch (Exception ex) {
            }
            return false;
        }

        boolean isHgtValid() {
            try {
                if (this.hgt.endsWith("in")) {
                    int value = Integer.parseInt(this.hgt.replaceFirst("in", ""));
                    if (value >= 59 && value <= 76) {
                        return true;
                    }
                }
                if (this.hgt.endsWith("cm")) {
                    int value = Integer.parseInt(this.hgt.replaceFirst("cm", ""));
                    if (value >= 150 && value <= 193) {
                        return true;
                    }
                }
            } catch (Exception ex) {
            }
            return false;
        }

        boolean isHclValid() {
            try {
                return pattern.matcher(this.hcl).matches();
            } catch (Exception ex) {
            }
            return false;
        }

        List<String> eclMatcher = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

        boolean isEclValid() {
            try {
                return eclMatcher.contains(this.ecl);
            } catch (Exception ex) {
            }
            return false;
        }

        boolean isPidValid() {
            try {
                Integer.parseInt(this.pid);
                return this.pid.length() == 9;
            } catch (Exception ex) {
            }
            return false;
        }

    }

}
