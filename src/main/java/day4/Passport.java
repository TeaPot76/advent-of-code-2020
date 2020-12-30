package day4;

import java.util.*;

public class Passport {

    private static final Set<String> EXPECTED_KEYS = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt",
            "hcl", "ecl", "pid"));

    private boolean checkByr(Map<String, String> passport) {
        String valueOfByr = passport.get("byr");
        int fourDigits = Integer.parseInt(valueOfByr);
        if (fourDigits >= 1920 && fourDigits <= 2002) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIyr(Map<String, String> passport) {
        String valueOfIyr = passport.get("iyr");
        int fourDigits = Integer.parseInt(valueOfIyr);
        return (fourDigits >= 2010 && fourDigits <= 2020);
    }

    private boolean checkEyr(Map<String, String> passport) {
        String valueOfEyr = passport.get("eyr");
        int fourDigits = Integer.parseInt(valueOfEyr);
        return (fourDigits >= 2020 && fourDigits <= 2030);
    }

    private boolean checkHgt(Map<String, String> passport) {
        String valueOfHgt = passport.get("hgt");

        if (valueOfHgt.contains("cm")) {
            String[] cms = valueOfHgt.split("cm");
            return (Integer.valueOf(cms[0]) >= 150 && Integer.valueOf(cms[0]) <= 195);
        } else {
            String[] inch = valueOfHgt.split("in");
            return (Integer.valueOf(inch[0]) >= 59 && Integer.valueOf(inch[0]) <= 76);
        }

//        number followed by either cm or in:
//        If cm, the number must be at least 150 and at most 193.
//        If in, the number must be at least 59 and at most 76.

    }

    private boolean checkHcl(Map<String, String> passport) {
        String valueOfHcl = passport.get("hcl");
        if (valueOfHcl.matches("^#[0-9a-f]{6}$")) {
            return true;
        } else {

            return false;
        }
    }

//        a # followed by exactly six characters 0-9 or a-f.


    private boolean checkEcl(Map<String, String> passport) {
        String valueOfEcl = passport.get("ecl");
//        ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        if (valueOfEcl.equals("amb") || valueOfEcl.equals("brn") || valueOfEcl.equals("gry") || valueOfEcl.equals("blu")
                || valueOfEcl.equals("grn") || valueOfEcl.equals("hzl") || valueOfEcl.equals("oth")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPid(Map<String, String> passport) {
        String valueOfPid = passport.get("pid");
//        pid (Passport ID) - a nine-digit number, including leading zeroes.

        if (valueOfPid.length() == 9 && (valueOfPid.contains("1") || valueOfPid.contains("2") || valueOfPid.contains("3")
                || valueOfPid.contains("4") || valueOfPid.contains("5") || valueOfPid.contains("6") || valueOfPid.contains("7") || valueOfPid.contains("8")
                || valueOfPid.contains("9") || valueOfPid.contains("0"))) {
            return true;
        } else {
            return false;
        }
    }

    public int numberOfCorrectPassports(List<Map<String, String>> allPassports) {
        int numberOfPassports = 0;
        for (Map<String, String> passport : allPassports) {
            if (passport.keySet().containsAll(EXPECTED_KEYS)) {
                numberOfPassports++;
            }
        }
        return numberOfPassports;
    }

    public int numberOfPassportsWithCorrectDetails(List<Map<String, String>> allPassports) {
        int numberOfPassportsWithCorrectDetails = 0;
        List<Map<String, String>> correctPassports = new ArrayList<>();

        for (Map<String, String> passport : allPassports) {
            if (passport.keySet().containsAll(EXPECTED_KEYS)) {
                correctPassports.add(passport);
            }
        }
        for (Map<String, String> correctPassport : correctPassports) {
            if (checkByr(correctPassport) && checkIyr(correctPassport) && checkEyr(correctPassport)
                    && checkHgt(correctPassport) && checkPid(correctPassport) && checkEcl(correctPassport) && checkHcl(correctPassport)) {
                numberOfPassportsWithCorrectDetails++;
            }
        }
        return numberOfPassportsWithCorrectDetails;
    }
}
