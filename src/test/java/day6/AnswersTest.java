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
        List<String> group1 = Collections.singletonList("abc");
        List<String> group2 = Arrays.asList("a", "b", "c");
        List<String> group3 = Arrays.asList("ab", "ac");
        List<String> group4 = Arrays.asList("a", "a", "a", "a");
        List<String> group5 = Collections.singletonList("b");
        Answers answers = new Answers();
        int expectedResult1 = 3;
        int expectedResult2 = 3;
        int expectedResult3 = 3;
        int expectedResult4 = 1;
        int expectedResult5 = 1;
        assertEquals(expectedResult1, answers.countAnswersForGroup(group1));
        answers = new Answers();
        assertEquals(expectedResult2, answers.countAnswersForGroup(group2));
        answers = new Answers();
        assertEquals(expectedResult3, answers.countAnswersForGroup(group3));
        answers = new Answers();
        assertEquals(expectedResult4, answers.countAnswersForGroup(group4));
        answers = new Answers();
        assertEquals(expectedResult5, answers.countAnswersForGroup(group5));
    }

    @Test
    public void checkYesAnswers() {
        List<String> group1 = Collections.singletonList("abc");
        List<String> group2 = Arrays.asList("a", "b", "c");
        List<String> group3 = Arrays.asList("ab", "ac");
        List<String> group4 = Arrays.asList("a", "a", "a", "a");
        List<String> group5 = Collections.singletonList("b");
        List<List<String>> groupsAnswers = new ArrayList<>();
        groupsAnswers.add(group1);
        groupsAnswers.add(group2);
        groupsAnswers.add(group3);
        groupsAnswers.add(group4);
        groupsAnswers.add(group5);
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

    @Test
    public void checkSameAnswerCount(){
        List<String> group1 = Collections.singletonList("abc");
        List<String> group2 = Arrays.asList("a", "b", "c");
        List<String> group3 = Arrays.asList("ab", "ac");
        List<String> group4 = Arrays.asList("a", "a", "a", "a");
        List<String> group5 = Collections.singletonList("b");
        Answers answers = new Answers();
        int expectedResult1 = 3;
        int expectedResult2 = 0;
        int expectedResult3 = 1;
        int expectedResult4 = 1;
        int expectedResult5 = 1;

        assertEquals(expectedResult1, answers.countTheSameAnswersForGroup(group1));
        assertEquals(expectedResult2, answers.countTheSameAnswersForGroup(group2));
        assertEquals(expectedResult3, answers.countTheSameAnswersForGroup(group3));
        assertEquals(expectedResult4, answers.countTheSameAnswersForGroup(group4));
        assertEquals(expectedResult5, answers.countTheSameAnswersForGroup(group5));

    }

    @Test
    public void checkCountForAllSameYesAnswersForAllGroups(){
        List<String> group1 = Collections.singletonList("abc");
        List<String> group2 = Arrays.asList("a", "b", "c");
        List<String> group3 = Arrays.asList("ab", "ac");
        List<String> group4 = Arrays.asList("a", "a", "a", "a");
        List<String> group5 = Collections.singletonList("b");
        List<List<String>> groupsAnswers = new ArrayList<>();
        groupsAnswers.add(group1);
        groupsAnswers.add(group2);
        groupsAnswers.add(group3);
        groupsAnswers.add(group4);
        groupsAnswers.add(group5);
        Answers answers = new Answers();
        int actualResult = answers.countYesAnswersForAllGroups(groupsAnswers);
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void checkPartTwoAllSameAnswersAnsweredYes() {
        AnswersReader answersReader = new AnswersReader();
        List<String> rowAnswersInput = answersReader.readAnswerFile("day6/answers");
        List<List<String>> allAnswers = answersReader.putAnswersIntoGroups(rowAnswersInput);
        Answers answers = new Answers();
        System.out.println(answers.countYesAnswersForAllGroups(allAnswers));
    }



}