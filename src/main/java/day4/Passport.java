package day4;

import java.util.*;

public class Passport {

   private static final Set<String> EXPECTED_KEYS = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt",
            "hcl", "ecl", "pid"));



    public int numberOfCorrectPassports(List<Map<String,String>> allPassports){
        int numberOfPassports = 0;
        for (Map<String,String> passport: allPassports){
            if (passport.keySet().containsAll(EXPECTED_KEYS) ){
                numberOfPassports ++;
            }
        }
        return numberOfPassports;
    }
}
