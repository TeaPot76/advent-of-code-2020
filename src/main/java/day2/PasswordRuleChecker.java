package day2;

import java.util.List;

public class PasswordRuleChecker {

    public Integer numberOfCorrectPasswords(List<String> input) {
        int correctPasswords = 0;
        for (String inputLine : input) {
            String[] split = inputLine.split(":");
            String rule = split[0];
            String[] ruleArrangeRange = rule.split(" ");
            String letter = ruleArrangeRange[1];
            String[] ruleRange = ruleArrangeRange[0].split("-");
            int firstNumber = Integer.parseInt(ruleRange[0]);
            int secondNumber = Integer.parseInt(ruleRange[1]);

//            System.out.println(firstNumber);
//            System.out.println(secondNumber);
//            System.out.println(letter);

            String password = split[1].trim();
            int counter = 0;
            for (char s : password.toCharArray()) {
                if (String.valueOf(s).equals(letter)) {
                    counter++;
                }
            }
            if (counter >= firstNumber && counter <= secondNumber) {
                correctPasswords++;
            }
        }
        return correctPasswords;

    }

    public Integer numberOfCorrectPasswordsNewRul(List<String> input) {
        int correctPasswords = 0;
        for (String inputLine : input) {
            String[] split = inputLine.split(":");
            String rule = split[0];
            String[] ruleArrangeRange = rule.split(" ");
            String letter = ruleArrangeRange[1];
            String[] ruleRange = ruleArrangeRange[0].split("-");
            int firstNumber = Integer.parseInt(ruleRange[0]);
            int secondNumber = Integer.parseInt(ruleRange[1]);
            String password = split[1].trim();
            char[] passwordToArray = password.toCharArray();
            boolean checkFirstNumber = String.valueOf(passwordToArray[firstNumber - 1]).equals(letter);
            boolean checkSecondNumber = String.valueOf(passwordToArray[secondNumber - 1]).equals(letter);
            if ((checkFirstNumber && (!checkSecondNumber))
                    || ((!checkFirstNumber) && checkSecondNumber)) {
                correctPasswords++;
            }

        }
        return correctPasswords;
    }
}
