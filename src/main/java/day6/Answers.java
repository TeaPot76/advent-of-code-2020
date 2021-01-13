package day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answers {

    public int yesAnswerCount(List<List<String>> allAnswers) {
        int counter = 0;
        for (List<String> answersList : allAnswers) {
            int numberOfAnswersForGroup = countAnswersForGroup(answersList);
            counter += numberOfAnswersForGroup;
        }

        return counter;
    }

    public int countAnswersForGroup(List<String> groupAnswers) {
        Set<Character> uniqueAnswers = new HashSet<>();
        for (String answer : groupAnswers) {
            for (char oneAnswer : answer.toCharArray()) {
                uniqueAnswers.add(oneAnswer);
            }
        }
        return uniqueAnswers.size();
    }
}
