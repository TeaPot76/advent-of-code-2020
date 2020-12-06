package day2;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PasswordRuleCheckerTest {

    @Test
    public void check(){
        List<String> examples = Arrays.asList("1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc");
        PasswordRuleChecker passwordRuleChecker = new PasswordRuleChecker();
        int result = passwordRuleChecker.numberOfCorrectPasswords(examples);
        assertEquals(2, result );

    }

    @Test
    public void findNumberOfPasswords(){
        String path = "day2/passwords";
        List<String>input =  FileReader.readAdventFiles(path);
        PasswordRuleChecker passwordRuleChecker = new PasswordRuleChecker();
        System.out.println(passwordRuleChecker.numberOfCorrectPasswords(input));

    }
    @Test
    public void findNumberOfCorrectPasswordsNewRule(){
        List<String> examples = Arrays.asList("1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc");
        List<String> examples2 = Arrays.asList("1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc",
                "2-4 d: dbbdfrr",
                "4-5 l: dfrllgt");
        PasswordRuleChecker passwordRuleChecker = new PasswordRuleChecker();
        int result = passwordRuleChecker.numberOfCorrectPasswordsNewRul(examples2);
        assertEquals(2, result );
        System.out.println(result);
    }


    @Test
    public void findNumberOfPasswordsNewRules(){
        String path = "day2/passwords";
        List<String>input =  FileReader.readAdventFiles(path);
        PasswordRuleChecker passwordRuleChecker = new PasswordRuleChecker();
        System.out.println(passwordRuleChecker.numberOfCorrectPasswordsNewRul(input));


    }



}