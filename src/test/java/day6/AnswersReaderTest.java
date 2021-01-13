package day6;

import org.junit.Test;

import java.util.List;

public class AnswersReaderTest {

    @Test
    public void checkIfPrintsAnswerSet() {
        String path = "day6/answers";
        AnswersReader answersReader = new AnswersReader();
        List<String> listOfAnswers = answersReader.readAnswerFile(path);
        System.out.println(listOfAnswers);
        List<List<String>> answersData = answersReader.putAnswersIntoGroups(listOfAnswers);
        System.out.println(answersData);
        List<String> thirdAnswer = answersData.get(2);
        System.out.println(thirdAnswer);
        List<String> fourthAnswer = answersData.get(3);
        System.out.println(fourthAnswer);
        String sd = listOfAnswers.get(3);

    }
}