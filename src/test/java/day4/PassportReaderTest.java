package day4;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PassportReaderTest {

    @Test
    public void testReader() {
        PassportReader passportReader = new PassportReader();
        List<String> example = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in"
        );

        List<Map<String, String>> expectedResult = new ArrayList<>();
        Map<String , String> passport1 = new HashMap<>();
        passport1.put("ecl","gry");
        passport1.put("pid","860033327");
        passport1.put("eyr","2020");
        passport1.put("hcl","#fffffd");
        passport1.put("byr", "1937");
        passport1.put("iyr", "2017");
        passport1.put("cid", "147");
        passport1.put("hgt","183cm");

        Map<String , String> passport2 = new HashMap<>();
        passport2.put("iyr", "2013");
        passport2.put("ecl","amb");
        passport2.put("cid", "350");
        passport2.put("eyr","2023");
        passport2.put("pid","028048884");
        passport2.put("hcl","#cfa07d");
        passport2.put("byr", "1929");

        Map<String , String> passport3 = new HashMap<>();
        passport3.put("hcl","#ae17e1");
        passport3.put("iyr", "2013");
        passport3.put("eyr","2024");
        passport3.put("ecl","brn");
        passport3.put("pid","760753108");
        passport3.put("byr", "1931");
        passport3.put("hgt","179cm");

        Map<String , String> passport4 = new HashMap<>();
        passport4.put("hcl","#cfa07d");
        passport4.put("eyr","2025");
        passport4.put("pid","166559648");
        passport4.put("iyr", "2011");
        passport4.put("ecl","brn");
        passport4.put("hgt","59in");


        expectedResult.add(passport1);
        expectedResult.add(passport2);
        expectedResult.add(passport3);
        expectedResult.add(passport4);

        List<Map<String, String>> actual = passportReader.convertToPassports(example);
        assertEquals(expectedResult, actual);
//        assertTrue(actual.contains(passport1));
//        assertTrue(actual.contains(passport2));
//        assertTrue(actual.contains(passport3));
       assertTrue(actual.contains(passport4));

        System.out.println(passportReader.convertToPassports(example));
    }
    @Test
    public void checkIfInputPrints(){
        PassportReader passportReader = new PassportReader();
        List<String> passportsInput = passportReader.readPassportsInput("day4/passports");
        System.out.println(passportsInput);
        List<Map<String, String>> passportsList = passportReader.convertToPassports(passportsInput);
        System.out.println(passportsList);
    }

    @Test
    public void checkIfCorrectNumberOfPassportsIsFound(){
        PassportReader passportReader = new PassportReader();
        List<String> example = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in"
        );
        List<Map<String, String>> allPassports = passportReader.convertToPassports(example);

        Passport passport = new Passport();

        int result = passport.numberOfCorrectPassports(allPassports);
        assertEquals(2, result);

    }

    @Test
    public void checkNumberOfPassportsFound(){
        PassportReader passportReader = new PassportReader();
        List<String> passportsInput = passportReader.readPassportsInput("day4/passports");
        List<Map<String, String>> passports = passportReader.convertToPassports(passportsInput);
        Passport passport = new Passport();
        System.out.println(passport.numberOfCorrectPassports(passports));
    }

    @Test
    public void checkNumberOfCorrectPassports(){
        PassportReader passportReader = new PassportReader();
        List<String> passportList = Arrays.asList(
                "eyr:1972 cid:100",
        "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
            "",
        "iyr:2019",
        "hcl:#602927 eyr:1967 hgt:170cm",
        "ecl:grn pid:012533040 byr:1946",
        "",
        "hcl:dab227 iyr:2012",
        "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
        "",
        "hgt:59cm ecl:zzz",
        "eyr:2038 hcl:74454a iyr:2023",
        "pid:3556412378 byr:2007",
                "",
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
        "hcl:#623a2f",
        "",
        "eyr:2029 ecl:blu cid:129 byr:1989",
        "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
        "",
        "hcl:#888785",
        "hgt:164cm byr:2001 iyr:2015 cid:88",
        "pid:545766238 ecl:hzl",
        "eyr:2022",
        "",
        "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
        );

        Passport passport = new Passport();
        List <Map<String, String>> listOfAllPassports = passportReader.convertToPassports(passportList);
        System.out.println(listOfAllPassports.size());
        int numberOfCorrectPasswords = passport.numberOfPassportsWithCorrectDetails(listOfAllPassports);
        System.out.println(passport.numberOfPassportsWithCorrectDetails(listOfAllPassports));

        List<String> passportsInput = passportReader.readPassportsInput("day4/passports");
        List<Map<String, String>> allPassports = passportReader.convertToPassports(passportsInput);
        System.out.println(passport.numberOfPassportsWithCorrectDetails(allPassports));


    }





}