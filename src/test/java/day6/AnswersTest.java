package day6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AnswersTest {

    @Test
    public void checkIndividualGroupAnswers() {
        List<String> firstGroup = Collections.singletonList("abc");
        List<String> secondGroup = Arrays.asList("a", "b", "c");
        List<String> thirdGroup = Arrays.asList("ab", "ac");
        List<String> fourthGroup = Arrays.asList("a", "a", "a", "a");
        List<String> fifthGroup = Collections.singletonList("b");
        Answers answers = new Answers();
        int expectedResult1 = 3;
        int expectedResult2 = 3;
        int expectedResult3 = 3;
        int expectedResult4 = 1;
        int expectedResult5 = 1;
        assertEquals(expectedResult1, answers.countAnswersForGroup(firstGroup));
        answers = new Answers();
        assertEquals(expectedResult2, answers.countAnswersForGroup(secondGroup));
        answers = new Answers();
        assertEquals(expectedResult3, answers.countAnswersForGroup(thirdGroup));
        answers = new Answers();
        assertEquals(expectedResult4, answers.countAnswersForGroup(fourthGroup));
        answers = new Answers();
        assertEquals(expectedResult5, answers.countAnswersForGroup(fifthGroup));
    }

    @Test
    public void checkYesAnswers() {
        List<String> firstGroup = Collections.singletonList("abc");
        List<String> secondGroup = Arrays.asList("a", "b", "c");
        List<String> thirdGroup = Arrays.asList("ab", "ac");
        List<String> fourthGroup = Arrays.asList("a", "a", "a", "a");
        List<String> fifthGroup = Collections.singletonList("b");
        List<List<String>> groupsAnswers = new ArrayList<>();
        groupsAnswers.add(firstGroup);
        groupsAnswers.add(secondGroup);
        groupsAnswers.add(thirdGroup);
        groupsAnswers.add(fourthGroup);
        groupsAnswers.add(fifthGroup);
        Answers answers = new Answers();
        int actualResult = answers.yesAnswerCount(groupsAnswers);
        int expectedResult = 11;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkPartOneAllAnswersAnsweredYes() {
        AnswersReader answersReader = new AnswersReader();
        List<String> rowAnswersInput = answersReader.readAnswerFile("day6/answers");
        List<List<String>> allAnswers = answersReader.putAnswersIntoGroups(rowAnswersInput);
        Answers answers = new Answers();
        System.out.println(answers.yesAnswerCount(allAnswers));
    }

}