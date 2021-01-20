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

    public int countTheSameAnswersForGroup(List<String> groupAnswers) {
        Set<Character> uniqueAnswers = new HashSet<>();
        int answerCount = 0;
        for (String answer : groupAnswers) {
            for (char oneAnswer : answer.toCharArray()) {
                uniqueAnswers.add(oneAnswer);
            }
        }
        for (char unique : uniqueAnswers){
            boolean toAdd = true;
            for (String answer : groupAnswers){
                if (!answer.contains(String.valueOf(unique))) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd){
                answerCount ++;
            }
        }
        return answerCount;

    }

    public int countYesAnswersForAllGroups(List<List<String>> allAnswers) {
        int counter = 0;
        for (List<String> answersList : allAnswers) {
            int numberOfAnswersForGroup = countTheSameAnswersForGroup(answersList);
            counter += numberOfAnswersForGroup;
        }
        return counter;
    }


}
